import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by alex on 09.05.17.
 */
public class Main {

    public static double[] x;
    public static double[] y;
    public static double[] h;

    public static void main(String[] args) throws IOException {
        File file = new File("in").getAbsoluteFile();
        loadFile(file);
        if (x.length != y.length || x.length > 9) {
            System.out.println("Некорректные данные");
            System.exit(0);
        }
        initH();
        double ans = 0;

        for(int i = 0; i < x.length; i++) {
            ans += y[i] * h[i];
        }
        System.out.printf("%.3f", ans* (x[x.length - 1] - x[0]));
    }

    public static void loadFile(File file) throws IOException {
        List<String> lines = null;
        String[] lines1;
        String[] lines2;
        try {
            lines = Files.readAllLines(Paths.get(String.valueOf(file)), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Can't open file");
        }
        lines1 = lines.get(0).split(" ");
        lines2 = lines.get(1).split(" ");
        x = new double[lines1.length];
        y = new double[lines2.length];
        for(int i = 0; i < lines1.length; i++) {
            x[i] = Double.parseDouble(lines1[i]);
            y[i] = Double.parseDouble(lines2[i]);
        }
    }

    public static void initH() {
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
    }
}
