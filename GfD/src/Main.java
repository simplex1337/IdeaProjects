/**
 * Created by alex on 06.02.17.
 */

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle(10,10,671,330);

        Player1 player1 = new Player1(rectangle);
        Player2 player2 = new Player2(rectangle);


        Ball ball = new Ball(rectangle);


        Frame frame = new Frame(player1, player2, rectangle, ball);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

    }
}
