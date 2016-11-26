import javax.swing.JFrame;

public class PointFrame extends JFrame
{
    public PointFrame(Point[] point) {
        setTitle("Laba 3");
        add(new PointComponent(point));
        setBounds(400, 100, 500, 500);
    }
}
