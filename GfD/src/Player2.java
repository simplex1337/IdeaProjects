import java.awt.*;

/**
 * Created by alex on 06.02.17.
 */
public class Player2 {

    private double x;
    private double y;

    private int h;
    private int w;

    private Rectangle bounds;


    public Player2(Rectangle bounds) {
        setBounds(bounds);
        setX(bounds.getMaxX() - 18);
        setY(100);
        setH(100);
        setW(20);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getH() {
        return h;
    }

    private void setBounds(Rectangle bounds) { this.bounds = bounds; }


    public int getW() {
        return w;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setW(int w) {
        this.w = w;
    }

    public void moveup() {
        if (getY()  > bounds.getMinY())
            setY(getY() - 1);
    }

    public void movedown() {
        if (getY()  < bounds.getMaxY() - getH())
            setY(getY() + 1);
    }
}
