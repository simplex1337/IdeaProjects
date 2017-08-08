import javax.swing.*;
import java.awt.*;

/**
 * Created by alex on 06.02.17.
 */
public class GameRender extends JComponent {

    private Player1 player1;
    private Player2 player2;
    private Rectangle rectangle;
    private Ball ball;
    private int status;

    public GameRender(Player1 player1, Player2 player2, Rectangle rectangle, Ball ball) {

        this.player1 = player1;
        this.player2 = player2;
        this.rectangle = rectangle;
        this.ball = ball;
        this.status = 0;

//        new Thread(this).start();


    }

    public void setStatus(int status) { this.status = status; }

    public boolean getStatus() { return this.status == 1; }

    @Override
    public void paint(Graphics g) {
        if (getStatus())
            g.drawRect((int) rectangle.getX(), (int) rectangle.getY(), (int) rectangle.getWidth(),
                (int) rectangle.getHeight());

        if (getStatus())
            g.fillOval((int) ball.getX(), (int) ball.getY(), ball.getR(), ball.getR());

        g.fillRect((int) player1.getX(), (int) player1.getY(), player1.getW(), player1.getH());

        g.fillRect((int) player2.getX(), (int) player2.getY(), player2.getW(), player2.getH());

        Toolkit.getDefaultToolkit().sync();
    }


    public void run () {
        while (true) {
            try {
                ball.move(player1, player2);
                player1.move();
                player2.move();
//                    Frame.super.repaint();
                super.repaint();
                Thread.sleep(10);
            } catch (InterruptedException err) {
                err.printStackTrace();
            }
        }
    }

}
