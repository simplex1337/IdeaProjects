import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by alex on 06.02.17.
 */

public class Frame extends JFrame {

    private Rectangle bounds;

    private Player1 player1;
    private Player2 player2;

    private Ball ball;

    private GameRender gr;

    private KeyAdapter binds;

    public Frame() {
        setTitle("Game for Dec, GOTY");
        setBounds(300, 100, 700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    public void load() {
        JLabel label = new JLabel("LOADING...");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setForeground(new Color(186, 189, 182));
        label.setFont(new Font("Verdana", Font.PLAIN, 20));
        this.getContentPane().setBackground(Color.BLACK);
        this.add(label);

        setVisible(true);

        this.bounds = new Rectangle(10,10,671,330);
        this.player1 = new Player1(bounds);
        this.player2 = new Player2(bounds);
        this.ball = new Ball(bounds);
    }

    public void menu() {

    }

    public void game() {
        gr = new GameRender(player1, player2, bounds, ball);
        binds = new KeyAdapter() {
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
        };

        this.addKeyListener(binds);

        this.add(gr);
    }
}
