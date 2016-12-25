import javafx.scene.shape.Arc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
