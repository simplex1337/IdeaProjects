import java.awt.Graphics;
import javax.swing.JComponent;

public class PointComponent extends JComponent implements Runnable
{
    private Point[] point;
    private static final int size = 100;


    public PointComponent(Point[] point) {
        this.point = point;
        (new Thread(this)).start();

    }
    

    @Override
    public void paint(Graphics g)
    {
        for (int i = 0; i < size; i++) {
            int x1 = (int) Math.round(point[i].getX());
            int y1 = (int) Math.round(point[i].getY());
            g.setColor(point[i].gettColor());
            g.drawRect(x1, y1, 1, 1);
        }
    }

    @Override
    public void run() {
        while (true) try {
            for (int i = 0; i < size; i++)
                point[i].forward(1);
            super.repaint();
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
