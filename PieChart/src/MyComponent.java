import javax.swing.*;
import java.awt.*;


/**
 * Created by alex on 18.12.16.
 */
public class MyComponent extends JComponent {

    private Pie pie;

    MyComponent(Pie pie) {
        this.pie = pie;
    }

    @Override
    public void paint(Graphics g) {
        drawPie((Graphics2D) g, pie);
    }

    void drawPie(Graphics2D g, Pie pie) {
        for (int i = 0; i < pie.getSize(); i++) {
            g.setColor(pie.getColor(i));
            g.fillArc(pie.getX(), pie.getY(), pie.getR() , pie.getR(), (int) Math.round(pie.getStartAngle(i)),
                    (int) Math.round(pie.getArcAngle(i)));
        }
    }

}
