import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import java.util.Random;

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
        Button btn3 = new Button("CHG SMTHG");

        JTextField textField = new JTextField();
        JTextField textField1 = new JTextField();
        JTextField textField2 = new JTextField();
        JTextField textField3 = new JTextField();

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
                if (i != 0)
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

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Random rnd = new Random();
                String s = textField.getText();
                String s1 = textField1.getText();
                String s2 = textField2.getText();
                String s3 = textField3.getText();
                try {
                    Double i2 = Double.valueOf(s);
                    Integer i3 = Integer.valueOf(s);
                    Integer i4 = Integer.valueOf(s);
                    Integer i5 = Integer.valueOf(s);
                    System.out.println(i2);
                    pie.setValue(i2, rnd.nextInt(pie.getSize()));
                    pie.setColor(i3, i4, i5, rnd.nextInt(pie.getSize()));
                }catch (NumberFormatException e) {
                    System.err.println("Неверный формат строки!");
                }
                repaint();
            }
        });

        btn.setBounds(20, 450, 50, 50);
        btn1.setBounds(100, 450, 50, 50);
        btn2.setBounds(170, 450, 50, 50);
        btn3.setBounds(550, 290, 50, 50);
        textField.setBounds(550, 50, 50, 50);
        textField1.setBounds(550, 110, 50, 50);
        textField2.setBounds(550, 170, 50, 50);
        textField3.setBounds(550, 230, 50, 50);


        add(textField);
        add(textField1);
        add(textField2);
        add(textField3);
        add(btn);
        add(btn1);
        add(btn2);
        add(btn3);
        add(new MyComponent(pie));


        setBounds(300, 100, 700, 700);
    }
}
