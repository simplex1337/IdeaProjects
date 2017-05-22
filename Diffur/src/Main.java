/**
 * Created by alex on 17.05.17.
 */
public class Main {

    public static double a = 0,
                         b = 1,
                         h = 0.1,
                         e = 0.1,
                         y0 = 1;

    public static double func(double x, double y) {
        return 2 * (x * x + y);
    }

    public static void main(String[] args) {
//        print(E(h, y0, 1), E(h, y0, 0));
        Eiler(h);
        System.out.println();
        Runge2P(h);
        System.out.println();
        Runge4(h);
//        print(RK2V(h, y0, 1), RK2V(h, y0, 0));
//        print(RK2P(h, y0, 1), RK2P(h, y0, 0));
//        print(RK4(h, y0, 1), RK4(h, y0, 0));
    }

    public static void Eiler(double h) {
        double hh = h;
        int step = 1;
        while(true) {
            double y1[] = E(hh, y0, 0);
            double y2[] = E(hh * 0.5, y0, 0);
            double max = -1.0;
            for(int i = 0; i < y1.length; i++) {
                if (Math.abs(y1[i] - y2[i * 2]) > max) {
                    max = Math.abs(y1[i] - y2[i * 2]);
                }
            }
            if (max > 3 * e) {
                hh *= 0.5;
                step++;
            }
            else {
                System.out.println("Колличество шагов в методе Эйлера: " + step);
                print(E(hh, y0, 1), E(hh, y0, 0));
                return;
            }
        }
    }

    public static void Runge2V(double h) {
        double hh = h;
        int step = 1;
        while(true) {
            double y1[] = RK2V(hh, y0, 0);
            double y2[] = RK2V(hh * 0.5, y0, 0);
            double max = -1.0;
            for(int i = 0; i < y1.length; i++) {
                if (Math.abs(y1[i] - y2[i * 2]) > max) {
                    max = Math.abs(y1[i] - y2[i * 2]);
                }
            }
            if (max > 3 * e) {
                hh *= 0.5;
                step++;
            }
            else {
                System.out.println("Колличество шагов в методе Р. - К. 2-го порядка с усреднением по времени: " + step);
                print(RK2V(hh, y0, 1), RK2V(hh, y0, 0));
                return;
            }
        }
    }

    public static void Runge2P(double h) {
        double hh = h;
        int step = 1;
        while(true) {
            double y1[] = RK2P(hh, y0, 0);
            double y2[] = RK2P(hh * 0.5, y0, 0);
            double max = -1.0;
            for(int i = 0; i < y1.length; i++) {
                if (Math.abs(y1[i] - y2[i * 2]) > max) {
                    max = Math.abs(y1[i] - y2[i * 2]);
                }
            }
            if (max > 3 * e) {
                hh *= 0.5;
                step++;
            }
            else {
                System.out.println("Колличество шагов в методе Р. - К. 2-го порядка с усреднением по производной: "
                        + step);
                print(RK2P(hh, y0, 1), RK2P(hh, y0, 0));
                return;
            }
        }
    }

    public static void Runge4(double h) {
        double hh = h;
        int step = 1;
        while(true) {
            double y1[] = RK4(hh, y0, 0);
            double y2[] = RK4(hh * 0.5, y0, 0);
            double max = -1.0;
            for(int i = 0; i < y1.length; i++) {
                if (Math.abs(y1[i] - y2[i * 2]) > max) {
                    max = Math.abs(y1[i] - y2[i * 2]);
                }
            }
            if (max > 15 * e) {
                hh *= 0.5;
                step++;
            }
            else {
                System.out.println("Колличество шагов в методе Р. - К. 4-го порядка: " + step);
                print(RK4(hh, y0, 1), RK4(hh, y0, 0));
                return;
            }
        }
    }

    public static double[] E(double h, double y0, int flg) {
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
        if (flg == 0)
            return y;
        else return x;
    }

    public static double[] RK2V(double h, double y0, double flg) { //усреднение по времени
        double hh = h;
        double x[] = new double[(int) ((b - a) / hh) + 1];
        double y[] = new double[(int) ((b - a) / hh) + 1];
        y[0] = y0;
        double tmp = a;
        for(int i = 0; tmp <= b; tmp += hh, i++) {
            x[i] = tmp;
        }
//        double yd[] = new double[(int) ((b - a) / hh)];
        double yd;
        for (int i = 0; i < x.length - 1; i++) {
            yd = y[i] + hh * 0.5 * func(x[i], y[i]);
            y[i + 1] = y[i] + func(x[i] + hh * 0.5, yd);
        }
        if (flg == 0)
            return y;
        else return x;
    }

    public static double[] RK2P(double h, double y0, double flg) { //усреднение по производной
        double hh = h;
        double x[] = new double[(int) ((b - a) / hh) + 1];
        double y[] = new double[(int) ((b - a) / hh) + 1];
        y[0] = y0;
        double tmp = a;
        for(int i = 0; tmp <= b; tmp += hh, i++) {
            x[i] = tmp;
        }
        double yd;
        for (int i = 0; i < x.length - 1; i++) {
            yd = y[i] + hh * 0.5 * func(x[i], y[i]);
            y[i + 1] = y[i] + hh * 0.5 * (func(x[i], y[i]) + func(x[i] + hh, yd));
        }
        if (flg == 0)
            return y;
        else return x;
    }

    public static double[] RK4(double h, double y0, double flg) { //усреднение по времени
        double hh = h;
        double x[] = new double[(int) ((b - a) / hh) + 1];
        double y[] = new double[(int) ((b - a) / hh) + 1];
        y[0] = y0;
        double tmp = a;
        for(int i = 0; tmp <= b; tmp += hh, i++) {
            x[i] = tmp;
        }
        double k1, k2, k3, k4;
        for (int i = 0; i < x.length - 1; i++) {
            k1 = func(x[i], y[i]);
            k2 = func(x[i] + hh * 0.5, y[i] + hh * 0.5 * k1);
            k3 = func(x[i] + hh * 0.5, y[i] + hh * 0.5 * k2);
            k4 = func(x[i] + hh, y[i] + hh * k3);
            y[i + 1] = y[i] + (hh / 6.0) * (k1 + 2 * k2 + 2 * k3 + k4);
        }
        if (flg == 0)
            return y;
        else return x;
    }

    public static void print(double x[], double y[]) {
        for(int i = 0; i < x.length; i++) {
            System.out.printf("%.4f ", x[i]);
        }

        System.out.println();

        for(int i = 0; i < y.length; i++) {
            System.out.printf("%.4f ", y[i]);
        }
    }
}
