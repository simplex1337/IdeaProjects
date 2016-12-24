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
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pie.addSlice();
                repaint();
            }
        });
        btn.setBounds(450, 450, 50, 50);
        add(btn);
        add(new MyComponent(pie));
        setBounds(300, 100, 700, 700);
    }
}
