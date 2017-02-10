import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


/**
 * Created by alex on 06.02.17.
 */
public class Frame extends JFrame {

    public Frame(Player1 player1, Player2 player2, Rectangle rectangle, Ball ball) {

        setTitle("Game for Dec");

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
//                super.keyTyped(keyEvent);
                if (keyEvent.getKeyChar() == 'w')
                    player1.moveup();
                if (keyEvent.getKeyChar() == 's')
                    player1.movedown();
                if (keyEvent.getKeyChar() == 'o')
                    player2.moveup();
                if (keyEvent.getKeyChar() == 'k')
                    player2.movedown();
                /*switch (keyEvent.getKeyChar()) {
                    case 'w':
                        player1.moveup();
                        repaint();
                        break;
                    case 's':
                        player1.movedown();
                        repaint();
                        break;
                }*/
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent keyEvent1) {
                super.keyTyped(keyEvent1);
                switch (keyEvent1.getKeyChar()) {
                    case 'o':
                        player2.moveup();
                        repaint();
                        break;
                    case 'k':
                        player2.movedown();
                        repaint();
                        break;
                }
            }
        });

        add(new MyComponent(player1, player2, rectangle, ball));

        setBounds(300, 100, 700, 400);
    }
}
