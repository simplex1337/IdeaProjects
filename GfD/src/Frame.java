import javax.swing.*;
import java.awt.*;

/**
 * Created by alex on 06.02.17.
 */
public class Frame extends JFrame {

    public Frame(Player1 player1, Player2 player2, Rectangle rectangle, Ball ball) {

        setTitle("Game for Dec: GOTY Edition");

        add(new MyComponent(player1, player2, rectangle, ball));

        setBounds(300, 100, 700, 400);
    }
}
