import javax.swing.*;

/**
 * Created by alex on 29.11.16.
 */
public class Main {
    public static void main(String[] args) {
        Point point = new Point();
        Line line = new Line();
        Rectangle rectangle = new Rectangle();
        Triangle triangle = new Triangle();
        Ellipse ellipse = new Ellipse();
        Circle circle = new Circle();
        Frame frame = new Frame(point, line, rectangle, triangle, ellipse, circle);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
