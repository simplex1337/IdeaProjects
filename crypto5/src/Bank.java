import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Hashtable;
import java.util.Random;

public class Bank {

    private int p, q, n, c, d;
    private Hashtable<Integer, Integer> used_cash; // <id of bn, banknote>

    public Bank() {
        this.p = get_big_prime();
        this.q = get_big_prime();
        this.n = p * q;
        int f = (p - 1) * (q - 1);
        Random rnd = new Random();
        do
            this.d = rnd.nextInt((int)f - 2);
        while (gcd(d, f) != 1);
        this.c = (int) ext_gcd(d, f) + f;

        this.used_cash = new Hashtable<Integer, Integer>();

    }

    public int get_big_prime() {
        Random random = new Random();
        int x;
        do x = random.nextInt(500) + 500; while(!is_prime(x)  || !is_prime((x - 1) / 2));
        return x;
    }

    public boolean check_banknote(int n, int banknote) {
        if (this.used_cash.containsKey(n) && this.used_cash.get(n) == banknote)
            return false;
        else return true;
    }

    public void add_banknote(int n, int banknote) {
        this.used_cash.put(n, banknote);
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

    public int mod_pow(long a, long pow, long mod) {
        long res = 1;
        while (pow > 0) {
            if (pow % 2 == 1)
                res = (res * a) % mod;
            a = (a * a) % mod;
            pow >>= 1;
        }
        return (int) res;
    }

    public long ext_gcd(long a, long b ) { //ax + by = d
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

    public long gcd(long a, long b) {
        return (b != 0) ? gcd(b, a % b) : a;
    }

    public int[] getHash(int n) throws NoSuchAlgorithmException {
        byte[] bytes = int_to_bytes(n);
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(bytes);
        int[] hash_int = byte_mod(hash);
        return hash_int;
    }

    public byte[] int_to_bytes(int digit){
        return ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN).putInt(digit).array();
    }

    private int[] byte_mod(byte[] bytes) {
        int buf[] = new int[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
//            System.out.print(" " + bytes[i]);
            buf[i] = bytes[i] + 128;
//            System.out.print(" " + buf[i]);
        }
        return buf;
    }

    public int getN() {
        return n;
    }

    public int getD() {
        return d;
    }

    public int getC() {
        return c;
    }
}
