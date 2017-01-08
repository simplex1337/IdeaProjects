import java.awt.*;
import java.util.Random;

/**
 * Created by alex on 20.12.16.
 */
abstract public class Circle {

    private Color color;
    private int r;

    public Circle() {
        Random rnd = new Random();
        color = new Color(rnd.nextFloat(), rnd.nextFloat(), rnd.nextFloat());
        r = rnd.nextInt(360);
    }

    public Circle(int r) {
        Random rnd = new Random();
        color = new Color(rnd.nextFloat(), rnd.nextFloat(), rnd.nextFloat());
        this.r = r;
    }

    public int getR() {
        return r;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(int i, int i2, int i3) {
        color = new Color(i, i2, i3);
    }


}
