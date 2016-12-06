import java.util.Random;

/**
 * Created by alex on 03.12.16.
 */
public class Circle extends Ellipse  {

    private Point p1;

    private int width;

    public Circle() {
        p1 = new Point();
        Random rnd = new Random();
        width = rnd.nextInt(200);
    }

    public void forward(int distance) {
        Random rnd = new Random();
        if (getX() >= 690 - width / 2 || getY() >= 665 - width * 2 || getX() < 0 || getY() < 0)
            setCourse(getCourse() + rnd.nextInt(180));
        setX(getX() + Math.cos(course / 180 * Math.PI));
        setY(getY() + Math.sin(course / 180 * Math.PI));
    }

}
