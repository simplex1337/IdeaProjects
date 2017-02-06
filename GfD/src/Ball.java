import java.awt.*;
import java.util.Random;

public class Ball {

    private double x, y;
    private int r, vecx, vecy;
    private Rectangle bounds;

    public Ball() {}
    public Ball(Frame frame) {
        bounds = frame.getBounds();
        setX(bounds.getCenterX());
        setY(bounds.getCenterY());
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
    private void setR(int r) {
        if (r > 0 && r < bounds.getHeight() / 2)
            this.r = r;
        else
            this.r = 5;
    }
    private void setX(double x) {
        if (x > bounds.getMinX() && x < bounds.getMaxX())
            this.x = x;
        else
            this.x = bounds.getWidth() / 2;
    }
    private void setY(double y) {
        if (y > bounds.getMinY() && y < bounds.getMaxY())
            this.y = y;
        else
            this.y = bounds.getHeight() / 2;
    }
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
