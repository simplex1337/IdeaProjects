import java.util.Random;

/**
 * Created by alex on 03.12.16.
 */
public class Circle extends Ellipse {
    private Point p1;

    private int width;

    public Circle() {
        p1 = new Point();
        Random rnd = new Random();
        width = rnd.nextInt(200);
    }

    public void move1() {
        p1.forward(1);
    }

}
