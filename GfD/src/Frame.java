import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by alex on 06.02.17.
 */

public class Frame extends JFrame {

    private static final int MENU = 0;

    private Rectangle bounds;

    private Player1 player1;
    private Player2 player2;

    private Ball ball;

    private KeyAdapter binds;

    private GameRender render;

    public Frame() {
        System.out.println("Setting up frame...");
        setTitle("Game for Dec, GOTY");
        setBounds(300, 100, 700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        System.out.println("Setting frame done");

        JLabel label = new JLabel("LOADING...");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setForeground(new Color(186, 189, 182));
        label.setFont(new Font("Verdana", Font.PLAIN, 20));
        this.getContentPane().setBackground(Color.BLACK);
        this.add(label);

        setVisible(true);

        System.out.println("Loading bounds");
        this.bounds = new Rectangle(10,10,671,330);
        System.out.println("Loading player 1 preferences");
        this.player1 = new Player1(bounds);
        System.out.println("Loading player 2 preferences");
        this.player2 = new Player2(bounds);
        System.out.println("Loading ball preferences");
        this.ball = new Ball(bounds);

        System.out.println("Loading done. Setting render");
        this.render = new GameRender(this.player1, this.player2, this.bounds, this.ball);

        System.out.println("Setting keybinds");
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

        System.out.println("All done");
    }

    public void menu() {
        render.setStatus(MENU);
        add(render);
    }

}
