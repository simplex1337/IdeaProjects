import javax.swing.JFrame;
import java.util.Random;

public class Main
{
    private static final int size = 100;

    public static void main(String[] args) {
        Random rnd = new Random();
        Point[] point = new Point[size];
        for (int i = 0; i < size; i++)
//            point[i] = new Point(rnd.nextInt(100), rnd.nextInt(100));
            point[i] = new Point();
        PointFrame frame = new PointFrame(point);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
