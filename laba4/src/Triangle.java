import java.util.Random;

/**
 * Created by alex on 03.12.16.
 */
public class Triangle extends Point{

    Point p1;
    Point p2;
    Point p3;


    public Triangle() {
        Random rnd = new Random();
        double i = rnd.nextInt(360);
        p1 = new Point(i);
        p2 = new Point(i);
        p3 = new Point(i);
    }

    public Point getP3() {
        return p3;
    }

    public double getX1() {
        return p1.getX();
    }

    public double getX2() {
        return p2.getX();
    }

    public double getX3() {
        return p3.getX();
    }

    public double getY3() {
        return p3.getX();
    }

    public double getY1() {
        return p1.getY();
    }

    public double getY2() {
        return p2.getY();
    }

    public void move() {
        Random rnd = new Random();
        int i = rnd.nextInt(180);
        if (getX1() >= 690 || getY1() >= 665 || getX1() < 0 || getY1() < 0 ||
                getX2() >= 690 || getY2() >= 665 || getX2() < 0 || getY2() < 0 ||
                getX3() >= 690 || getY3() >= 665 || getX3() < 0 || getY3() < 0) {
            setCourse(getCourse() + i);
//            p2.setCourse(p2.getCourse() + i);
        }

        p1.setX( p1.getX() + Math.cos(course / 180 * Math.PI));
        p1.setY( p1.getY() + Math.sin(course / 180 * Math.PI));
        p2.setX( p2.getX() + Math.cos(course / 180 * Math.PI));
        p2.setY( p2.getY() + Math.sin(course / 180 * Math.PI));
        p3.setX( p3.getX() + Math.cos(course / 180 * Math.PI));
        p3.setY( p3.getY() + Math.sin(course / 180 * Math.PI));
    }
}
