import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by alex on 06.02.17.
 */

public class Frame extends JFrame {

    private static final int MENU = 0;
    private static final int GAME = 1;
    private static final int SCORE = 2;

    private Rectangle bounds;

    private Player1 player1;
    private Player2 player2;

    private Ball ball;

    private KeyListener binds;
    private JLabel score;

    private GameRender render;

    private Timer tick;

    int frames;

    public Frame() {
        System.out.println("Setting up frame...");
        setTitle("Game for Dec, GOTY");
        setBounds(300, 100, 700, 440);
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
        this.render.setSize(this.getSize());

        this.tick = new Timer(10, actionEvent -> {
            render.repaint();
            player1.move();
            player2.move();
            if (render.getStatus() == GAME) {
                if (ball.move(player1, player2)) {
                    render.setStatus(SCORE);
                    game();
                }
            }
            frames++;
        });
        tick.setRepeats(true);
        tick.start();

        new Timer(1000, actionEvent -> {
            System.out.println("FPS: " + frames);
            frames = 0;
        }).start();

        System.out.println("Setting keybindings");
        binds = new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_Q) {
                    if (render.getStatus() > 0) {
                        render.setStatus(MENU);
                        render.zPane.removeAll();
                        render.zPane.add(render);
                        menu();
                    } else {
                        System.exit(0);
                    }
                } else {
                    toggle(e, true);
                }
            }
            @Override
            public void keyReleased(KeyEvent e) { toggle(e, false); }

            @Override
            public void keyTyped(KeyEvent e) {
            }

            private void toggle(KeyEvent e, boolean pressed) {
                if (e.getKeyCode() == KeyEvent.VK_E) player1.toggleUp(pressed);
                if (e.getKeyCode() == KeyEvent.VK_D) player1.toggleDown(pressed);
                if (e.getKeyCode() == KeyEvent.VK_O) player2.toggleUp(pressed);
                if (e.getKeyCode() == KeyEvent.VK_L) player2.toggleDown(pressed);
            }
        };

        render.addKeyListener(binds);

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
        start.setSize(140, 30);
        start.setMargin(new Insets(0,0,0,0));
        start.setLocation(this.getWidth() / 2 - start.getWidth() / 2, this.getHeight() / 2);

        JButton exit = new JButton("Exit");
        exit.setFont(new Font("Verdana", Font.PLAIN, 12));
        exit.setSize(140, 30);
        exit.setMargin(new Insets(0,0,0,0));
        exit.setLocation(this.getWidth() / 2 - exit.getWidth() / 2, this.getHeight() / 2 + exit.getHeight());

        JLabel gameName = new JLabel("Game for Dec");
        gameName.setFont(new Font("Verdana", Font.BOLD, 24));
        gameName.setBounds(0,0,180,30);
        gameName.setSize(190, 30);
        gameName.setLocation(this.getWidth() / 2 - gameName.getWidth() / 2, this.getHeight() / 4);

        this.add(render.zPane, BorderLayout.CENTER);
        render.zPane.add(gameName);
        render.zPane.add(start);
        render.zPane.add(exit);
        render.requestFocus();

        start.addActionListener(e -> {
            render.zPane.remove(gameName);
            render.zPane.remove(start);
            render.zPane.remove(exit);

            score = new JLabel();
            score.setFont(new Font("Verdana", Font.BOLD, 24));
            score.setBounds(0,0, 90,30);
            score.setSize(80, 30);
            score.setLocation(this.getWidth() / 2 - score.getWidth() / 2,
                    (int) bounds.getHeight() + (int) bounds.getMinY() * 3);
            render.zPane.add(score);

            game();
        });

        exit.addActionListener(e -> {
            System.exit(0);
        });

        setVisible(true);
    }

    public void game() {
        if (render.getStatus() != 0)
            score.setText(player1.getScore() + " - " + player2.getScore());

        JLabel gap = new JLabel();
        gap.setFont(new Font("Verdana", Font.BOLD, 24));
        gap.setBounds(0,0,30,30);
        gap.setSize(30, 30);
        gap.setLocation(this.getWidth() / 2 - gap.getWidth() / 2, this.getHeight() / 4);
        render.zPane.add(gap);
        new Thread(() -> {
            for (int i = 3; i > 0; i--) {
                gap.setText("" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            render.zPane.remove(gap);
            if (render.getStatus() == 0) {
                score.setText(player1.getScore() + " - " + player2.getScore());

                JButton back = new JButton("Menu");
                back.setFont(new Font("Verdana", Font.PLAIN, 12));
                back.setSize(70, 30);
                back.setMargin(new Insets(0,0,0,0));
                back.setLocation((int) bounds.getMaxX() - back.getWidth(),
                        (int) bounds.getHeight() + (int) bounds.getMinY() * 3);
                back.addActionListener(actionEvent -> {
                    render.setStatus(MENU);
                    render.zPane.removeAll();
                    render.zPane.add(render);
                    menu();
                });
                render.zPane.add(back);

            }

            ball.reset();
            render.setStatus(GAME);
        }).start();
    }

}
