import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by alex on 18.12.16.
 */
public class Frame extends JFrame {
    public Frame(Pie pie) {
        setTitle("PieChart");

        Button btn = new Button("PUSH");
        Button btn1 = new Button("REMOVE");
        Button btn2 = new Button("CLEAR");

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pie.addSlice();
                repaint();
            }
        });

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pie.removeSlice();
                repaint();
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pie.clearPie();
                repaint();
            }
        });

        btn.setBounds(450, 450, 50, 50);
        btn1.setBounds(520, 450, 50, 50);
        btn2.setBounds(600, 450, 50, 50);

        add(btn);
        add(btn1);
        add(btn2);
        add(new MyComponent(pie));

        setBounds(300, 100, 700, 700);
    }
}
