/**
 * Created by alex on 17.05.17.
 */
public class Main {

    public static double a = 0,
                         b = 1,
                         h = 0.1,
                         e = 0.001,
                         y0 = 1;

    public static double func(double x, double y) {
        return 2 * (x * x + y);
    }

    public static void main(String[] args) {
        Eiler(h, y0);
    }

    public static void Eiler(double h, double y0) {
        double hh = h;
        double x[] = new double[(int) ((b - a) / hh) + 1];
        double y[] = new double[(int) ((b - a) / hh) + 1];
        y[0] = y0;
        double tmp = a;
        for(int i = 0; tmp <= b; tmp += hh, i++) {
            x[i] = tmp;
        }
        for (int i = 0; i < x.length - 1; i++) {
            y[i + 1] = y[i] + func(x[i], y[i]) * hh;
        }
        for(int i = 0; i < x.length; i++) {
            System.out.printf("%.4f ", x[i]);
        }

        System.out.println();

        for(int i = 0; i < y.length; i++) {
            System.out.printf("%.4f ", y[i]);
        }
    }
}
