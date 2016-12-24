import javax.swing.*;
import java.awt.*;

/**
 * Created by alex on 18.12.16.
 */
public class Main {
    public static void main(String[] argv) {

        /*Slice[] slices = new Slice[5];
        for (int i = 0; i < 5; i++) {
            slices[i] = new Slice();
        }*/

        Pie pie = new Pie(20, 20);

//        Frame frame = new Frame(slices);
        Frame frame = new Frame(pie);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
