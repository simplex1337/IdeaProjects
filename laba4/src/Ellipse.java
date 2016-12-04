import java.util.Random;

/**
 * Created by alex on 03.12.16.
 */
public class Ellipse extends Point {

    private Point p1;

    private int width;
    private int height;

    public Ellipse() {
        p1 = new Point();
        Random rnd = new Random();
        width = rnd.nextInt(200);
        height = rnd.nextInt(200);
    }

    public int width() {
        return width;
    }
    public int height() {
        return height;
    }
}
