/**
 * Created by alex on 03.12.16.
 */
public class Triangle extends Line {

    Point p1;
    Point p2;
    Point p3;


    public Triangle() {
        p1 = new Point();
        p2 = new Point();
        p3 = new Point();
    }

    public Point getP3() {
        return p3;
    }

    public double getX3() {
        return p3.getX();
    }

    public double getY3() {
        return p3.getX();
    }
}
