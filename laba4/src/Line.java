import java.util.Random;

/**
 * Created by alex on 03.12.16.
 */
public class Line extends Point {

    private Point p1;
    private Point p2;


    public Line() {
        Random rnd = new Random();
        double i = rnd.nextInt(360);
        p1 = new Point(i);
        p2 = new Point(i);
    }

    public Line(double x1, double y1, double x2, double y2) {
        p1 = new Point(x1, y1);
        p2 = new Point(x2, y2);
    }

    public Line(double lenght) {

    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public double getX1() {
        return p1.getX();
    }

    public double getX2() {
        return p2.getX();
    }

    public double getY1() {
        return p1.getY();
    }

    public double getY2() {
        return p2.getY();
    }

    public void setLine(double x1, double y1, double x2, double y2) {
        p1.setX(x1);
        p1.setY(y1);
        p2.setX(x2);
        p2.setY(y2);
    }

    public double getHeight() {
        return Math.abs(getY1()- getY2());
    }

    public double getWidth() {
        return Math.abs(getX1()- getX2());
    }

    public double getLenght() {
        return Math.sqrt(Math.pow(getHeight(), 2) + Math.pow(getWidth(), 2));
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
    }

    public void vraw() {
        p1.setX( p1.getX() + Math.cos(course / 180 * Math.PI));
        p1.setY( p1.getY() + Math.cos(course / 180 * Math.PI));
        p2.setX( p2.getX() + Math.cos(course / 180 * Math.PI));
        p2.setY( p2.getY() + Math.cos(course / 180 * Math.PI));
    }

}
