import java.awt.*;
import javax.swing.JComponent;

public class PaintComponent extends JComponent implements Runnable
{
    private Point point;
    private Line line;
    private Rectangle rectangle;
    private Triangle triangle;
    private Ellipse ellipse;
    private Circle circle;
    private static final int size = 100;


    public PaintComponent(Point point, Line line, Rectangle rectangle, Triangle triangle, Ellipse ellipse,
                          Circle circle) {
        this.point = point;
        this.line = line;
        this.rectangle = rectangle;
        this.triangle = triangle;
        this.ellipse = ellipse;
        this.circle = circle;
        (new Thread(this)).start();

    }


    @Override
    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)  g;
        g.setColor(point.gettColor());
        g.drawRect((int) point.getX(), (int) point.getY(), 1, 1);

        g.setColor(line.gettColor());
        g.drawLine((int) line.getX1(), (int) line.getY1(), (int) line.getX2(), (int) line.getY2());

        g.setColor(rectangle.gettColor());
        g.drawRect((int) rectangle.getX1(), (int) rectangle.getY1(), (int) rectangle.getWidth(),
                (int) rectangle.getHeight());

        g.setColor(triangle.gettColor());
        g.drawLine((int) triangle.getX1(), (int) triangle.getY1(), (int) triangle.getX2(), (int) triangle.getY2());
        g.drawLine((int) triangle.getX1(), (int) triangle.getY1(), (int) triangle.getX3(), (int) triangle.getY3());
        g.drawLine((int) triangle.getX2(), (int) triangle.getY2(), (int) triangle.getX3(), (int) triangle.getY3());

        g.setColor(ellipse.gettColor());
        g.drawOval((int) ellipse.getX(), (int) ellipse.getY(), ellipse.width(), ellipse.height());

        g.setColor(circle.gettColor());
        g.drawOval((int) circle.getX(), (int) circle.getY(), circle.width(), circle.width());
    }

    @Override
    public void run() {
        while (true) try {
//            for (int i = 0; i < size; i++)
                line.move();
            super.repaint();
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
