import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by alex on 18.12.16.
 */
public class Frame extends JFrame {

    private int i;

    public Frame(Pie pie) {

        
        setTitle("PieChart");

        Button btn = new Button("PUSH");
        Button btn1 = new Button("REMOVE");
        Button btn2 = new Button("CLEAR");

//        JTable tab = new JTable(new MyTableModel());

//        tab.setPreferredScrollableViewportSize(new Dimension(100,100));

        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pie.addSlice();
                System.out.println("значение " + (i + 1) + "го куска = " + pie.getValue(i));
                repaint();
                i++;
            }
        });

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pie.removeSlice();
                repaint();
                i--;
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pie.clearPie();
                repaint();
                i = 0;
            }
        });

//        tab.setBounds(400, 400, 200, 200);
        btn.setBounds(20, 450, 50, 50);
        btn1.setBounds(100, 450, 50, 50);
        btn2.setBounds(170, 450, 50, 50);

//        add(tab);
        add(btn);
        add(btn1);
        add(btn2);
        add(new MyComponent(pie));


        setBounds(300, 100, 700, 700);
    }
}
