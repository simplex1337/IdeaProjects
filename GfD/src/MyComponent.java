import javax.swing.*;
import java.awt.*;

/**
 * Created by alex on 06.02.17.
 */
public class MyComponent extends JComponent implements Runnable {

    private Player1 player1;
    private Player2 player2;
    private Rectangle rectangle;
    private Ball ball;

    public MyComponent(Player1 player1, Player2 player2, Rectangle rectangle, Ball ball) {

        this.player1 = player1;
        this.player2 = player2;
        this.rectangle = rectangle;
        this.ball = ball;

        new Thread(this).start();

    }

    @Override
    public void paint(Graphics g) {
        drawSes(g, getBounds(), player1, player2, ball);

    }

    void drawSes(Graphics g, Rectangle area, Player1 player1, Player2 player2, Ball ball) {

        g.drawRect((int) rectangle.getX(), (int) rectangle.getY(), (int) rectangle.getWidth(),
                (int) rectangle.getHeight());

        g.fillOval((int) ball.getX(), (int) ball.getY(), ball.getR(), ball.getR());

        g.fillRect((int) player1.getX(), (int) player1.getY(), player1.getW(), player1.getH());

        g.fillRect((int) player2.getX(), (int) player2.getY(), player2.getW(), player2.getH());

        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void run() {
        while (true) try {
            ball.move(player1, player2);

            super.repaint();
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
