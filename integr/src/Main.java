/**
 * Created by alex on 09.05.17.
 */
public class Main {

    public static double a = 0,
                         b = 3,
                         h = 0.5,
                         e = 0.001;

    public static double func(double x) {
        return x * x * x;
    }

    public static void main(String[] args) {
        trap();
        simp();
    }

    public static void trap() {
        int step = 0;
        double hh = h;
        while(t(hh) - t(hh / 2) > 3 * e) {
            hh *= 0.5;
            step++;
        }
        System.out.println("метод трапеций " + step + " шагов ");
        System.out.printf("%.5f", t(hh / 2));
        System.out.println();

    }

    public static void simp() {
        int step1 = 0;
        double hh = h;
        while(s(hh) - s(hh / 2) > 15 * e) {
            hh *= 0.5;
            step1++;
        }
        System.out.println("метод симпсона " + step1 + " шагов ");
        System.out.printf("%.5f", s(hh / 2));
        System.out.println();
    }

    public static double t(double h) {
        double x[] = new double[(int) ((b - a) / h) + 1];
        double y[] = new double[(int) ((b - a) / h) + 1];
        double tmp = a;
        for(int i = 0; tmp <= b; tmp += h, i++) {
            x[i] = tmp;
            y[i] = func(x[i]);
        }
        double ans = 0;
        for(int i = 1; i < y.length - 1; i++)
            ans += y[i];
        return h * (0.5 * (y[0] + y[y.length - 1]) + ans);

    }

    public static double s(double h) {
        double x[] = new double[(int) ((b - a) / h) + 1];
        double y[] = new double[(int) ((b - a) / h) + 1];
        double tmp = a;
        for(int i = 0; tmp <= b; tmp += h, i++) {
            x[i] = tmp;
            y[i] = func(x[i]);
        }
        double ans = 0, ans1 = 0;
        for(int i = 1; i < y.length - 1; i += 2)
            ans += y[i];
        for(int i = 2; i < y.length - 2; i += 2)
            ans1 += y[i];
        return ((h / 3.0) * ((y[0] + y[y.length - 1]) + (4 * ans) + (2 * ans1)));
    }

    /*public static void initH() {
        switch (x.length - 1) {
            case 1: h = new double[]{0.5, 0.5};
                break;
            case 2: h = new double[]{1.0 / 6.0, 2.0 / 3.0, 1.0 / 6.0};
                break;
            case 3: h = new double[]{1.0 / 8.0, 3.0 / 8.0, 3.0 / 8.0, 1.0 / 8.0};
                break;
            case 4: h = new double[]{7.0 / 90.0, 32.0 / 90.0, 12.0 / 90.0, 32.0 / 90.0, 7.0 / 90.0};
                break;
            case 5: h = new double[]{19.0 / 288.0, 75.0 / 288.0, 60.0 / 288.0, 50.0 / 288.0, 75.0 / 288.0,
                    19.0 / 288.0};
                break;
            case 6: h = new double[]{41.0 / 840.0, 216.0 / 840.0, 27.0 / 840.0, 272.0 / 840.0, 27.0 / 840.0,
                    216.0 / 840.0, 41.0 / 840.0};
                break;
            case 7: h = new double[]{751.0 / 17280.0, 3577.0 / 17280.0, 1323.0 / 17280.0, 2989.0 / 17280.0,
                    2989.0 / 17280.0, 1323.0 / 17280.0, 3577.0 / 17280.0, 751.0 / 17280.0};
                break;
            case 8: h = new double[]{989.0 / 28350.0, 5888.0 / 28350.0, -928.0 / 28350.0, 10496.0 / 28350.0,
                    -928.0 / 28350.0, 10496.0 / 28350.0, -928.0 / 28350.0, 5888.0 / 28350.0, 989.0 / 28350.0};
                break;
        }
    }*/
}
