import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Point
{
    private double x;
    private double y;
    protected double course;
    private Color color;

    public Point() {
        Random rnd = new Random();
        x = rnd.nextInt(500);
        y = rnd.nextInt(500);
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
        if (getX() >= 500 || getY() >= 500)
            setCourse(360 - getCourse());
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

}
