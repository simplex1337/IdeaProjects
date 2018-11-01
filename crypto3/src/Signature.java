import java.io.*;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Random;

public class Signature {

    private int[] hash;

    public Signature(String file) throws NoSuchAlgorithmException {
        this.hash = new Hash(file).getHash();
    }

    public void rsa(String filename) throws Exception {
        Random rnd = new Random();
        int p = get_big_prime(50, 500);
        int q = get_big_prime(50, 500);
        int d;
        long c;
        long n = p * q;
        long f = (p - 1) * (q - 1);
        do
            d = rnd.nextInt((int)f - 2);
        while (gcd(d, f) != 1);
        c = ext_gcd(d, f) + f;
        int[] sign = new int[hash.length];
        for (int i = 0; i < hash.length; i++) {
            sign[i] = mod_pow(hash[i], c, n);
//            System.out.print(hash[i] + " ");
        }
        int[] keys = {d, (int) n};
        write_in_file(integers_to_bytes(keys), "src/rsa_keys");
        write_in_file(integers_to_bytes(sign), filename);
    }

    public void check_rsa(String filename) {
        int[] sign = bytes_to_ints(byte_parse_file(filename));
        int[] keys = bytes_to_ints(byte_parse_file("src/rsa_keys"));
        int d = keys[0];
        int n = keys[1];
        int[] calc_hash = new int[sign.length];
//        System.out.println();
        for (int i = 0; i < calc_hash.length; i++) {
            calc_hash[i] = mod_pow(sign[i], d, n);
//            System.out.print(cacl_hash[i] + " ");
        }
        if (Arrays.equals(hash, calc_hash))
            System.out.println("This sign is valid");
        else
            System.out.println("This sign is invalid");
    }

    public void el_gamal(String filename) throws Exception {
        int p = get_big_prime();
        Random rnd = new Random();
        int g, k;
        int q = (p - 1) / 2;
        do {
            g = rnd.nextInt(p - 3) + 2;
        } while (mod_pow(g, q, p) == 1);
        int x = rnd.nextInt(p - 1);
        int y = mod_pow(g, x, p);
        do
            k = rnd.nextInt(p - 2);
        while (gcd(k, p - 1) != 1);
        int r = mod_pow(g, k, p);
        int[] u = new int[hash.length];
        int[] sign = new int[hash.length + 1];
        int _k = (int) ext_gcd(k, p - 1);
        System.out.println("k = " + _k);
        for (int i = 0; i < u.length; i++) {
            u[i] = (hash[i] - x * r) % (p - 1) + (p - 1);
//            System.out.println("u = " + u[i]);
            sign[i] = (_k * u[i]) % (p - 1) + (p - 1);
        }
        sign[sign.length - 1] = r;
        int keys[] = {y, p, g};
        write_in_file(integers_to_bytes(keys), "src/elg_keys");
        write_in_file(integers_to_bytes(sign), filename);
    }

    //выяснить почему не работает
    public void check_el_gamal(String filename) {
        int[] keys = bytes_to_ints(byte_parse_file("src/elg_keys"));
        int[] sign = bytes_to_ints(byte_parse_file(filename));
        int y = keys[0];
        int p = keys[1];
        int g = keys[2];
        int r = sign[sign.length - 1];
        int yr[] = new int[hash.length];
        int calc_hash[] = new int[hash.length];
        for (int i = 0; i < hash.length; i++) {
            yr[i] = (mod_pow(y, r, p) * mod_pow(r, sign[i], p)) % p;
            calc_hash[i] = mod_pow(g, hash[i], p);
//            System.out.println(sign[i] +  " " + yr[i] + " " + calc_hash[i]);
        }
        if (Arrays.equals(yr, calc_hash))
            System.out.println("This sign is valid");
        else
            System.out.println("This sign is invalid");
    }

    public void gost(String filename) throws Exception {
        int q = get_big_prime(1000,3000);
        int a, b = 1, p, g, x, y, k, r;
        int[] sign = new int[hash.length + 1];
        do {
            b++;
            p = b * q + 1;
        } while (!is_prime(p));
        Random rnd = new Random();
        do {
            g = rnd.nextInt(p - 3) + 2;
            a = mod_pow(g, b, p);
        } while (a < 2);
        x = rnd.nextInt(q - 2) + 1;
        y = mod_pow(a, x, p);
//        System.out.println("q = " + q + " b = " + b + " p = " + p + " y = " + y);
        do {
            k = rnd.nextInt(q - 2) + 1;
            r = mod_pow(a, k, p) % q;
        } while (r == 0);
//        System.out.println("r = " + r);
        for(int i = 0; i < hash.length; i++) {
            sign[i] = (k * hash[i] + x * r) % q;
        }
        sign[sign.length - 1] = r;
        int keys[] = {p, q, a, y};
        write_in_file(integers_to_bytes(keys), "src/gost_keys");
        write_in_file(integers_to_bytes(sign), filename);
    }

    public void check_gost(String filename) {
        int[] keys = bytes_to_ints(byte_parse_file("src/gost_keys"));
        int[] sign = bytes_to_ints(byte_parse_file(filename));
        int r = sign[sign.length - 1];
        System.out.println("r = " + r);
        int p = keys[0];
        int q = keys[1];
        int a = keys[2];
        int y = keys[3];
        int flg = 0, u1, u2;
        long check;
        if (r < 1 || r > q)
            flg = 1;
        for (int i = 0; i < hash.length; i++) {
            if (sign[i] < 1 || sign[i] > q) {
                flg = 1;
                break;
            }
            u1 = (sign[i] * (int) ext_gcd(hash[i], q) % q) + q;
            u2 = (-1 * r * (int) ext_gcd(hash[i], q) % q) + q;
            check = ((mod_pow(a, u1, p) * mod_pow(y, u2, p)) % p) % q; //переполнение умножения, переделать в бигинт
//            System.out.println("check = " + check + " 1 = " + (mod_pow(a, u1, p) + " 2 = " + mod_pow(y, u2, p)));
//            System.out.println("u1 = " + u1);
            if (check != r) {
                flg = 1;
//                break;
            }
        }
//        System.out.println("sign[8] = " + sign[8]);
//        System.out.println("hash[8] = " + hash[8]);
        System.out.println("q = " + q);
        if (flg == 0)
            System.out.println("This sign is valid");
        else
            System.out.println("This sign is invalid");
    }

    private long ext_gcd(long a, long b ) { //ax + by = d
        if (b == 0) {
            long ans[] = {a, 1, 0};
            return ans[1];
        }
        long q, r;
        long x[] = {0, 0, 1};
        long y[] = {0, 1, 0};
        while (b > 0) {
            q = a / b;
            r = a - q * b;
            x[0] = x[2] - q * x[1];
            y[0] = y[2] - q * y[1];

            a = b;
            b = r;
            x[2] = x[1];
            x[1] = x[0];
            y[2] = y[1];
            y[1] = y[0];
        }
        long ans[] = {a, x[2], y[2]};
        return ans[1]; // d, x, y
    }

    private long gcd(long a, long b) {
        return (b != 0) ? gcd(b, a % b) : a;
    }

    private boolean is_prime(int p) {
        if (p <= 1)
            return false;

        int b = (int) Math.pow(p, 0.5);

        for (int i = 2; i <= b; ++i) {
            if ((p % i) == 0 ) return false;
        }
        return true;
    }

    private int get_big_prime(int low, int high) {
        Random random = new Random();
        int x;
        do x = random.nextInt(high - low) + low; while(!is_prime(x));
        return x;
    }

    private int get_big_prime() {
        Random random = new Random();
        int x;
        do x = random.nextInt(500) + 500; while(!is_prime(x)  || !is_prime((x - 1) / 2));
        return x;
    }

    private int mod_pow(long a, long pow, long mod) {
        long res = 1;
        while (pow > 0) {
            if (pow % 2 == 1)
                res = (res * a) % mod;
            a = (a * a) % mod;
            pow >>= 1;
        }
        return (int) res;
    }

    public void write_in_file(byte[] buff, String filename) {
        try {
            new FileOutputStream(filename).write(buff);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    byte[] integers_to_bytes(int[] values) throws Exception
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        for(int i=0; i < values.length; ++i)
        {
            dos.writeInt(values[i]);
        }
        return baos.toByteArray();
    }

    int[] bytes_to_ints(byte[] bytes) {
        int[] ints = new int[bytes.length / 4];
        for (int i = 0; i < bytes.length / 4; i++) {
            byte[] tmp_bytes = new byte[4];
            for (int j = 0; j < 4; j++) {
                tmp_bytes[j] = bytes[4 * i + j];
            }
            ints[i] = byte_to_int(tmp_bytes);
        }
        return ints;
    }

    public int byte_to_int(byte [] byteBarray){
        return ByteBuffer.wrap(byteBarray).order(ByteOrder.BIG_ENDIAN).getInt();
    }

    public byte[] byte_parse_file(String file) {
        byte[] buffer = new byte[0];
        try(FileInputStream fin = new FileInputStream(file))
        {
            buffer = new byte[fin.available()];
            fin.read(buffer, 0, buffer.length);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return buffer;
    }

    public byte[] int_to_byte(int digit){
        return ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN).putInt(digit).array();
    }


}
