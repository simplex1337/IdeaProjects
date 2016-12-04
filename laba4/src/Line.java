import java.util.Random;

/**
 * Created by alex on 03.12.16.
 */
public class Line extends Point {

    private Point p1;
    private Point p2;


    public Line() {
        p1 = new Point();
        p2 = new Point();
    }

    public Line(double x1, double y1, double x2, double y2) {
        p1 = new Point(x1, y1);
        p2 = new Point(x2, y2);
    }

    public Line(double lengh) {

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

    public void move() {

    }
}
