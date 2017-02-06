/**
 * Created by alex on 06.02.17.
 */

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Player1 player1 = new Player1();
        Player2 player2 = new Player2();


        Frame frame = new Frame(player1, player2);
        

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
