import java.util.Random;

public class Player {

    private int c;
    private int d;
    private int p;

    public Player(int p) {
        this.p = p;
        this.c = gen_c();
        this.d = (int) ext_gcd(c, p - 1) + p - 1;
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

    private int gen_c() {
        Random rnd = new Random();
        int c;
        do {
            c = rnd.nextInt(1000);
        } while (gcd(p - 1, c) != 1);
        return c;
    }

    public int getC() {
        return c;
    }

    public int getD() {
        return d;
    }

}
