import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by alex on 06.02.17.
 */

public class Frame extends JFrame {

    private static final int MENU = 0;
    private static final int GAME = 1;

    private Rectangle bounds;

    private Player1 player1;
    private Player2 player2;

    private Ball ball;

    private KeyListener binds;

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
        render.setSize(this.getSize());

        System.out.println("Setting keybinds");
        binds = new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) { toggle(e, true); }

            @Override
            public void keyReleased(KeyEvent e) { toggle(e, false); }

            @Override
            public void keyTyped(KeyEvent e) { }

            private void toggle(KeyEvent e, boolean pressed) {
                if (e.getKeyCode() == KeyEvent.VK_E) player1.toggleUp(pressed);
                if (e.getKeyCode() == KeyEvent.VK_D) player1.toggleDown(pressed);
                if (e.getKeyCode() == KeyEvent.VK_O) player2.toggleUp(pressed);
                if (e.getKeyCode() == KeyEvent.VK_L) player2.toggleDown(pressed);
                if (e.getKeyCode() == KeyEvent.VK_Q) {
                    setVisible(false);
                    dispose();
                }
            }
        };

        this.addKeyListener(binds);

        this.remove(label);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout(new BorderLayout());

        setVisible(false);
    }

    public void menu() {
        render.setStatus(MENU);

        JButton start = new JButton("Start");
        start.setFocusable(false);
        start.setFont(new Font("Verdana", Font.PLAIN, 12));
        start.setSize(40, 30);
        start.setMargin(new Insets(0,0,0,0));
        start.setLocation(this.getWidth() / 4 * 3, this.getHeight() / 3 * 2);

        JButton exit = new JButton("Exit");
        exit.setFont(new Font("Verdana", Font.PLAIN, 12));
        exit.setSize(40, 30);
        exit.setMargin(new Insets(0,0,0,0));
        exit.setLocation(this.getWidth() / 4 * 3, this.getHeight() / 3 * 2 + exit.getHeight());

        JLabel gameName = new JLabel("Game for Dec");
        gameName.setFont(new Font("Verdana", Font.BOLD, 24));
        gameName.setBounds(0,0,100,30);
        gameName.setSize(180, 30);
        gameName.setLocation(this.getWidth() / 2 - gameName.getWidth() / 2, this.getHeight() / 4);

        JLayeredPane zPane = new JLayeredPane();
        this.add(zPane, BorderLayout.CENTER);
        zPane.add(gameName);
        zPane.add(start);
        zPane.add(exit);
        zPane.add(render);

        start.addActionListener(e -> {
            zPane.remove(gameName);
            zPane.remove(start);
            zPane.remove(exit);
            render.repaint();
            game();
        });

        exit.addActionListener(e -> {
            setVisible(false);
            dispose();
        });

        setVisible(true);
    }

    public void game() {
        render.setStatus(GAME);
        boolean exec = true;
        render.requestFocusInWindow();

        Timer tick = new Timer(10, actionEvent -> {
            render.repaint();
            player1.move();
            player2.move();
            ball.move(player1, player2);
        });
        tick.setRepeats(true);
        tick.start();
    }

}
