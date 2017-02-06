import javax.swing.*;

/**
 * Created by alex on 06.02.17.
 */
public class Frame extends JFrame {

    public Frame(Player1 player1, Player2 player2) {

        setTitle("Game for Dec");

        add(new MyComponent(player1, player2));

        setBounds(300, 100, 700, 700);
    }
}
