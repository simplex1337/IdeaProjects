import java.awt.*;
import java.util.Random;


public class Point
{
    private double x;
    private double y;
    protected double course;
    private Color color;

    public Point() {
        Random rnd = new Random();
        x = rnd.nextInt(489);
        y = rnd.nextInt(464);
        color = new Color(rnd.nextFloat(),rnd.nextFloat(),rnd.nextFloat());
        course = rnd.nextInt(360);
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
        Random rnd = new Random();
        color = new Color(rnd.nextFloat(),rnd.nextFloat(),rnd.nextFloat());
        course = rnd.nextInt(360);
    }


    public void forward(int distance) {
        Random rnd = new Random();
        if (getX() >= 490 || getY() >= 465 || getX() < 0 || getY() < 0)
            setCourse(getCourse() + rnd.nextInt(180));
        x += distance * Math.cos(course / 180 * Math.PI);
        y += distance * Math.sin(course / 180 * Math.PI);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Color gettColor() {
        return color;
    }

    public double getCourse() {
        return course;
    }

    public void setCourse(double course) {
        this.course = course;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void chaos(int distance) {
        Random rnd = new Random();

        x += distance * (rnd.nextDouble() - 0.5);
        y += distance * (rnd.nextDouble() - 0.5);
    }

    public void mv() {
        x++;
        y++;
    }
}
