/**
 * Created by alex on 03.12.16.
 */
public class Diamond extends Rectangle {

    private Point p1;
    private Point p2;
    private Point p3;
    private Point p4;

    public Diamond() {
        p1 = new Point();
        p2 = new Point();
        p3 = new Point(p1.getX(), p2.getY());
        p4 = new Point(p2.getX(), p1.getY());
    }

}
