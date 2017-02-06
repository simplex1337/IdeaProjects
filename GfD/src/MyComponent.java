import javax.swing.*;
import java.awt.*;

/**
 * Created by alex on 06.02.17.
 */
public class MyComponent extends JComponent {

    private Player1 player1;
    private Player2 player2;

    public MyComponent(Player1 player1, Player2 player2) {

        this.player1 = player1;
        this.player2 = player2;

    }

    @Override
    public void paint(Graphics g) {
        drawSes((Graphics2D) g, getBounds(), player1, player2);

    }

    void drawSes(Graphics2D g, Rectangle area, Player1 player1, Player2 player2) {

        g.fillRect((int) player1.getX(), (int) player1.getY(), player1.getW(), player1.getH());

        g.fillRect((int) player2.getX(), (int) player2.getY(), player2.getW(), player2.getH());
    }
}
