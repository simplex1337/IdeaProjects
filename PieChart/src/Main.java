import javax.swing.*;

/**
 * Created by alex on 18.12.16.
 */
public class Main {
    public static void main(String[] argv) {

        Pie pie = new Pie(20, 20);

        Frame frame = new Frame(pie);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
