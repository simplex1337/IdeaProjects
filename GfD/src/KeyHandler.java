import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import static javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW;

/**
 * Created by fle4er on 11.07.17.
 */

public class KeyHandler {
    private enum Actions {
        PL1_UP(KeyStroke.getKeyStroke(KeyEvent.VK_E, 0)),
        PL1_DOWN(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0)),
        PL2_UP(KeyStroke.getKeyStroke(KeyEvent.VK_O, 0)),
        PL2_DOWN(KeyStroke.getKeyStroke(KeyEvent.VK_L, 0));

        private KeyStroke keyStroke;

        Actions(KeyStroke keyStroke) {
            this.keyStroke = keyStroke;
        }

        public KeyStroke getKeyStroke() { return this.keyStroke; }
    }

    public KeyHandler(Frame frame, Player1 player1, Player2 player2) {
        int condition = WHEN_IN_FOCUSED_WINDOW;
        InputMap inputMap = frame.getRootPane().getInputMap(condition);
        ActionMap actionMap = frame.getRootPane().getActionMap();

        for (Actions i : Actions.values()) {
            inputMap.put(i.getKeyStroke(), i.toString());
            actionMap.put(i.toString(), new PlayerAction(i.toString(), player1, player2));
        }

    }

    private class PlayerAction extends AbstractAction {

        private String action;
        private Player1 player1;
        private Player2 player2;

        public PlayerAction(String action, Player1 player1, Player2 player2) {
            this.action = action;
            this.player1 = player1;
            this.player2 = player2;
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            if (action.startsWith("PL1")) {
                if (action.endsWith("UP"))
                    player1.moveup();
                else
                    player1.movedown();
            } else {
                if (action.endsWith("UP"))
                    player2.moveup();
                else
                    player2.movedown();
            }
        }

    }
}

