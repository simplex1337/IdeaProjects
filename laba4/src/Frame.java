import javax.swing.JFrame;

public class Frame extends JFrame
{
    public Frame(Point point, Line line, Rectangle rectangle, Triangle triangle, Ellipse ellipse,
                 Circle circle) {
        setTitle("Laba 3");
        add(new PaintComponent(point, line, rectangle, triangle, ellipse, circle));
        setBounds(400, 100, 700, 700);
    }
}
