import java.util.Random;

/**
 * Created by alex on 03.12.16.
 */
public class Rectangle extends Line {

    private Point p1;
    private Point p2;
    private Point p3;
    private Point p4;

    public Rectangle() {
        Random rnd = new Random();
//        int i = rnd.nextInt(360);
        p1 = new Point();
        p2 = new Point();
        p3 = new Point();
        p4 = new Point();
    }

    @Override

    public void move() {
    }


}
