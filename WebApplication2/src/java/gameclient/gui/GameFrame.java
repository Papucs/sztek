package gameclient.gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame {

    private final JPanel contentPane;
    private final GamePanel gamePanel;

    public GameFrame(GamePanel gamePanel) {
        contentPane = (JPanel) this.getContentPane();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(200, 200);
        setLayout(new BorderLayout());
        setResizable(false);

        this.gamePanel = gamePanel;

        contentPane.add(gamePanel, BorderLayout.CENTER);

        setVisible(true);
        pack();
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

}
