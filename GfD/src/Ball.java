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
        if (rnd.nextBoolean())
            setVecx(3);
        else
            setVecx(-3);
        setVecy((rnd.nextInt(3) - 2) * 3);
        setR(10);
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

    private void setVecx(int vecx) {
        if (vecx != 0)
            this.vecx = vecx;
        else
            this.vecx = 1;
    }

    private void setVecy(int vecy) {
        if (vecy != 0)
            this.vecy = vecy;
        else
            this.vecy = 1;
    }

    public boolean move(Player1 pl1, Player2 pl2) {
        if (this.getX() + this.getR() > bounds.getMaxX() || this.getX() < bounds.getMinX())
            return true;
        if (this.getX() + this.getR() == pl2.getX() && (this.getY() >= pl2.getY() || this.getY() <= pl2.getY() + pl2.getH()) ||
                this.getX() == pl2.getX() && (this.getY() >= pl1.getY() || this.getY() <= pl1.getY() + pl1.getH()))
            setVecx(getVecx() * -1);
        if ((this.getY() + this.getR()) > bounds.getMaxY() || (this.getY() - this.getR()) < bounds.getMinY())
            setVecy(getVecy() * -1);
        setX(getX() + getVecx());
        setY(getY() + getVecy());
        return false;
    }
}
