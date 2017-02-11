import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by alex on 06.02.17.
 */
public class Frame extends JFrame {

    public Frame(Player1 player1, Player2 player2, Rectangle rectangle, Ball ball) {

        setTitle("Game for Dec");

        KeyListener listener = new KeyListener() {
            private Set<Character> pressed = new HashSet<Character>();
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                pressed.add(keyEvent.getKeyChar());
                for (Character tmp: pressed) {
                    if (tmp == 'e')
                        player1.moveup();
                    if (tmp == 'o')
                        player2.moveup();
                    if (tmp == 'd')
                        player1.movedown();
                    if (tmp == 'k')
                        player2.movedown();
                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                pressed.remove(keyEvent.getKeyChar());
            }
        };
        addKeyListener(listener);

        add(new MyComponent(player1, player2, rectangle, ball));

        setBounds(300, 100, 700, 400);
    }
}
