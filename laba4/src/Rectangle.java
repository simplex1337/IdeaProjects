import java.util.Random;

/**
 * Created by alex on 03.12.16.
 */
public class Rectangle extends Point {

    private Point p1;
    private Point p2;
    private Point p3;
    private Point p4;

    public Rectangle() {
        Random rnd = new Random();
//        int i = rnd.nextInt(360);
        p1 = new Point();
        p2 = new Point();
        p3 = new Point(p1.getX(), p2.getY());
        p4 = new Point(p2.getX(), p1.getY());
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
        return p3.getY();
    }

    public double getY1() {
        return p1.getY();
    }

    public double getY2() {
        return p2.getY();
    }

    public double getX4() {
        return p4.getX();
    }

    public double getY4() {
        return p4.getY();
    }

    public void move() {
        Random rnd = new Random();
        int i = rnd.nextInt(180);
        if (getX1() >= 690 || getY1() >= 665 || getX1() < 0 || getY1() < 0 ||
                getX2() >= 690 || getY2() >= 665 || getX2() < 0 || getY2() < 0 ) {
            setCourse(getCourse() + i);
//            p2.setCourse(p2.getCourse() + i);
        }
        p1.setX( p1.getX() + Math.cos(course / 180 * Math.PI));
        p1.setY( p1.getY() + Math.sin(course / 180 * Math.PI));
        p2.setX( p2.getX() + Math.cos(course / 180 * Math.PI));
        p2.setY( p2.getY() + Math.sin(course / 180 * Math.PI));
        p3.setX( p3.getX() + Math.cos(course / 180 * Math.PI));
        p3.setY( p3.getY() + Math.sin(course / 180 * Math.PI));
        p4.setX( p4.getX() + Math.cos(course / 180 * Math.PI));
        p4.setY( p4.getY() + Math.sin(course / 180 * Math.PI));
    }


}
