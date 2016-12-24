import javax.swing.*;
import java.awt.*;

/**
 * Created by alex on 18.12.16.
 */
public class MyComponent extends JComponent {

    /*Slice[] slices = { new Slice(5, Color.black),
            new Slice(33, Color.green),
            new Slice(20, Color.yellow), new Slice(15, Color.red) };*/

//    private Slice[] slices = new Slice[5];
    private Pie pie;


    MyComponent(Pie pie) {
        this.pie = pie;
    }

    @Override
    public void paint(Graphics g) {
        drawPie((Graphics2D) g, getBounds(), pie);
    }

    void drawPie(Graphics2D g, Rectangle area, Pie pie) {
        for (int i = 0; i < pie.getSize(); i++) {
            g.setColor(pie.getColor(i));
            g.fillArc(pie.getX(), pie.getY(), pie.getR() , pie.getR(), (int) pie.getStartAngle(i),
                    (int) pie.getArcAngle(i));
        }
    }
}
