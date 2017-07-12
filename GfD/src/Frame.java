import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by alex on 06.02.17.
 */
public class Frame extends JFrame {

    public Frame(Player1 player1, Player2 player2, Rectangle rectangle, Ball ball) {

        setTitle("Game for Dec: GOTY Edition");

        this.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                toggle(e, true);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                toggle(e, false);
            }

            @Override
            public void keyTyped(KeyEvent e) { }

            private void toggle(KeyEvent e, boolean pressed) {
                if (e.getKeyCode() == KeyEvent.VK_E) player1.toggleUp(pressed);
                if (e.getKeyCode() == KeyEvent.VK_D) player1.toggleDown(pressed);
                if (e.getKeyCode() == KeyEvent.VK_O) player2.toggleUp(pressed);
                if (e.getKeyCode() == KeyEvent.VK_L) player2.toggleDown(pressed);
            }
        });

        add(new MyComponent(player1, player2, rectangle, ball));

        setBounds(300, 100, 700, 400);
    }
}
