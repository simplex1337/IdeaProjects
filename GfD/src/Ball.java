import java.awt.*;
import java.util.Random;

public class Ball {

    private double x;
    private double y;

    private int r;
    private int vecx;
    private int vecy;

    private Rectangle bounds;

    public Ball(Rectangle bounds) {
        setBounds(bounds);
        setX(bounds.getMaxX() / 2);
        setY(bounds.getMaxY() / 2);
        Random rnd = new Random(System.currentTimeMillis());
        setVecx(rnd.nextInt(11) - 5);
        setVecy(rnd.nextInt(11) - 5);
        setR(5);
    }

    public int getR() { return r; }

    public double getX() { return x; }

    public double getY() { return y; }

    public int getVecy() { return vecy; }

    public int getVecx() { return vecx; }

    private void setBounds(Rectangle bounds) { this.bounds = bounds; }

    private void setR(int r) { this.r = r; }

    private void setX(double x) { this.x = x; }

    private void setY(double y) { this.y = y; }

    private void setVecx(int vecx) { this.vecx = vecx; }

    private void setVecy(int vecy) { this.vecy = vecy; }

    public void move() {
        if ((getX() + getR()) > bounds.getMaxX() || (getX() - getR()) < bounds.getMinX())
            setVecx(getVecx() * -1);
        if ((getY() + getR()) > bounds.getMaxY() || (getY() - getR()) < bounds.getMinY())
            setVecy(getVecy() * -1);
        setX(getX() + getVecx());
        setY(getY() + getVecy());
    }
}
