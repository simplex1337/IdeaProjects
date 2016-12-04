/**
 * Created by alex on 03.12.16.
 */
public class Rectangle extends Line {

    private Line l1;

    public Rectangle() {
        l1 = new Line();
    }

    @Override

    public void move() {
        l1.move();
    }


}
