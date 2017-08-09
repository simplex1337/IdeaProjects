import java.awt.*;

/**
 * Created by alex on 06.02.17.
 */
public class Player1 {

    private double x;
    private double y;

    private int h;
    private int w;

    private Rectangle bounds;

    private boolean up;
    private boolean down;

    private int score; // количество забитых шаров

    public Player1(Rectangle bounds) {
        setBounds(bounds);
        setX(bounds.getMinX());
        setY(100);
        setH(100);
        setW(20);
        setScore(0);
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

    public int getScore() {
        return score;
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

    public void setScore(int score) {
        this.score = score;
    }

    private void moveup() {
        if (getY() > bounds.getMinY())
            setY(getY() - 5);
    }

    private void movedown() {
        if (getY() < bounds.getMaxY() - getH())
            setY(getY() + 5);
    }

    public void move() {
        if (up)
            this.moveup();
        if (down)
            this.movedown();
    }

    public void toggleUp(boolean flg) {
        if (flg) {
            if (down) {
                down = false;
            }
            up = true;
        } else
            up = false;
    }

    public void toggleDown(boolean flg) {
        if (flg) {
            if (up) {
                up = false;
            }
            down = true;
        } else
            down = false;
    }
}

