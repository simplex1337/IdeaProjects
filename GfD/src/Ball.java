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
        reset();
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
        if (this.getX() + this.getR() > bounds.getMaxX()) {
            pl1.setScore(pl1.getScore() + 1);
            return true;
        }
        if (this.getX() < bounds.getMinX()) {
            pl2.setScore(pl2.getScore() + 1);
            return true;
        }
        if ((this.getX() + this.getR() - 10 < bounds.getMinX() + pl1.getW()
                && pl1.getY() + pl1.getH() > this.getY() + this.getR()
                && pl1.getY() < this.getY() + this.getR()) ||
                this.getX() + this.getR() > bounds.getMaxX() - pl2.getW()
                && pl2.getY() + pl2.getH() > this.getY() + this.getR()
                && pl2.getY() < this.getY() + this.getR()) {
            setVecx(getVecx() * -1);
        }
        if ((this.getY() + this.getR()) > bounds.getMaxY() || (this.getY() - this.getR()) < bounds.getMinY())
            setVecy(getVecy() * -1);
        setX(getX() + getVecx());
        setY(getY() + getVecy());
        return false;
    }

    public void reset() {
        setX(bounds.getMaxX() / 2);
        setY(bounds.getMaxY() / 2);
        Random rnd = new Random(System.currentTimeMillis());
        if (rnd.nextBoolean())
            setVecx(3);
        else
            setVecx(-3);
        setVecy((rnd.nextInt(3) - 2) * 3);
    }
}
