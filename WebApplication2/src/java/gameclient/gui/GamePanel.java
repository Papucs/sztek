package gameclient.gui;

import gameclient.GameClient;
import data.Game;
import data.KeyboardCommand;
import data.Location;
import data.Player;
import data.Projectile;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import static java.awt.event.KeyEvent.VK_DOWN;
import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;
import static java.awt.event.KeyEvent.VK_SPACE;
import static java.awt.event.KeyEvent.VK_UP;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public final class GamePanel extends JPanel {

    private Game game;
    private GameClient gameClient;

    private HashMap<Integer, Integer> playerIDandNumberMap;
    private boolean playerIDandNumberMapInited = false;

    private BufferedImage Player1_UP;
    private BufferedImage Player1_DOWN;
    private BufferedImage Player1_LEFT;
    private BufferedImage Player1_RIGHT;

    private BufferedImage Player2_UP;
    private BufferedImage Player2_DOWN;
    private BufferedImage Player2_LEFT;
    private BufferedImage Player2_RIGHT;

    private BufferedImage Player3_UP;
    private BufferedImage Player3_DOWN;
    private BufferedImage Player3_LEFT;
    private BufferedImage Player3_RIGHT;

    private BufferedImage Player4_UP;
    private BufferedImage Player4_DOWN;
    private BufferedImage Player4_LEFT;
    private BufferedImage Player4_RIGHT;

    private BufferedImage Projectile_UP;
    private BufferedImage Projectile_DOWN;
    private BufferedImage Projectile_LEFT;
    private BufferedImage Projectile_RIGHT;

    private BufferedImage Block;

    public GamePanel(Game game) {
        this.game = game;

        setLayout(null);
        setBackground(Color.BLACK);
        setFocusable(false);
        setLocation(20, 20);
        setPreferredSize(new Dimension(400, 400));

        try {
            Player1_UP = ImageIO.read(new File("kepek\\KEKTANK_UP.png"));
            Player1_DOWN = ImageIO.read(new File("kepek\\KEKTANK_DOWN.png"));
            Player1_LEFT = ImageIO.read(new File("kepek\\KEKTANK_LEFT.png"));
            Player1_RIGHT = ImageIO.read(new File("kepek\\KEKTANK_RIGHT.png"));

            Player2_UP = ImageIO.read(new File("kepek\\PIROSTANK_UP.png"));
            Player2_DOWN = ImageIO.read(new File("kepek\\PIROSTANK_DOWN.png"));
            Player2_LEFT = ImageIO.read(new File("kepek\\PIROSTANK_LEFT.png"));
            Player2_RIGHT = ImageIO.read(new File("kepek\\PIROSTANK_RIGHT.png"));

            Player3_UP = ImageIO.read(new File("kepek\\ZOLDTANK_UP.png"));
            Player3_DOWN = ImageIO.read(new File("kepek\\ZOLDTANK_DOWN.png"));
            Player3_LEFT = ImageIO.read(new File("kepek\\ZOLDTANK_LEFT.png"));
            Player3_RIGHT = ImageIO.read(new File("kepek\\ZOLDTANK_RIGHT.png"));

            Player4_UP = ImageIO.read(new File("kepek\\SARGATANK_UP.png"));
            Player4_DOWN = ImageIO.read(new File("kepek\\SARGATANK_DOWN.png"));
            Player4_LEFT = ImageIO.read(new File("kepek\\SARGATANK_LEFT.png"));
            Player4_RIGHT = ImageIO.read(new File("kepek\\SARGATANK_RIGHT.png"));

            Projectile_UP = ImageIO.read(new File("kepek\\LOVEDEK_UP.png"));
            Projectile_DOWN = ImageIO.read(new File("kepek\\LOVEDEK_DOWN.png"));
            Projectile_LEFT = ImageIO.read(new File("kepek\\LOVEDEK_LEFT.png"));
            Projectile_RIGHT = ImageIO.read(new File("kepek\\LOVEDEK_RIGHT.png"));

            Block = ImageIO.read(new File("kepek\\FAL.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        initializeKeyboardStuff();

        setVisible(true);
    }

    public void setGameClient(GameClient gameClient) {
        this.gameClient = gameClient;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void initializeKeyboardStuff() {
        Action shootAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    gameClient.sendKeyboardCommand(new KeyboardCommand(VK_SPACE, true));
                } catch (IOException ex) {
                    Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };

        Action pressedUpAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    gameClient.sendKeyboardCommand(new KeyboardCommand(VK_UP, true));
                } catch (IOException ex) {
                    Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };

        Action releasedUpAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    gameClient.sendKeyboardCommand(new KeyboardCommand(VK_UP, false));
                } catch (IOException ex) {
                    Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };

        Action pressedDownAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    gameClient.sendKeyboardCommand(new KeyboardCommand(VK_DOWN, true));
                } catch (IOException ex) {
                    Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };

        Action releasedDownAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    gameClient.sendKeyboardCommand(new KeyboardCommand(VK_DOWN, false));
                } catch (IOException ex) {
                    Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };

        Action pressedLeftAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    gameClient.sendKeyboardCommand(new KeyboardCommand(VK_LEFT, true));
                } catch (IOException ex) {
                    Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };

        Action releasedLeftAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    gameClient.sendKeyboardCommand(new KeyboardCommand(VK_LEFT, false));
                } catch (IOException ex) {
                    Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };

        Action pressedRightAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    gameClient.sendKeyboardCommand(new KeyboardCommand(VK_RIGHT, true));
                } catch (IOException ex) {
                    Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };

        Action releasedRightAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    gameClient.sendKeyboardCommand(new KeyboardCommand(VK_RIGHT, false));
                } catch (IOException ex) {
                    Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SPACE"), "shoot");
        getActionMap().put("shoot", shootAction);

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed UP"), "upPressed");
        getActionMap().put("upPressed", pressedUpAction);

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed DOWN"), "downPressed");
        getActionMap().put("downPressed", pressedDownAction);

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed LEFT"), "leftPressed");
        getActionMap().put("leftPressed", pressedLeftAction);

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed RIGHT"), "rightPressed");
        getActionMap().put("rightPressed", pressedRightAction);

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released UP"), "upReleased");
        getActionMap().put("upReleased", releasedUpAction);

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released DOWN"), "downReleased");
        getActionMap().put("downReleased", releasedDownAction);

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released LEFT"), "leftReleased");
        getActionMap().put("leftReleased", releasedLeftAction);

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released RIGHT"), "rightReleased");
        getActionMap().put("rightReleased", releasedRightAction);
    }

    private void initPlayerIDandNumberMap() {
        this.playerIDandNumberMap = new HashMap<>();
        ArrayList<Player> players = this.game.getGameState().getPlayers();

        for (int i = 0; i < players.size(); ++i) {
            this.playerIDandNumberMap.put(players.get(i).getPlayerNumber(), i);
        }

        this.playerIDandNumberMapInited = true;

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        if (game.getGameState() != null) {

            if (!playerIDandNumberMapInited) {
                initPlayerIDandNumberMap();
            }

            ArrayList<Player> players = game.getGameState().getPlayers();
            ArrayList<Projectile> projectiles = game.getGameState().getProjectiles();

            //Players
            for (Player player : players) {
                if (player.isAlive()) {
                    switch (playerIDandNumberMap.get(player.getPlayerNumber())) {
                        case 0:
                            switch (player.getDirection()) {
                                case UP:
                                    g2d.drawImage(Player1_UP, null, player.getLocation().getX() * 2, player.getLocation().getY() * 2);
                                    break;
                                case DOWN:
                                    g2d.drawImage(Player1_DOWN, null, player.getLocation().getX() * 2, player.getLocation().getY() * 2);
                                    break;
                                case RIGHT:
                                    g2d.drawImage(Player1_RIGHT, null, player.getLocation().getX() * 2, player.getLocation().getY() * 2);
                                    break;
                                case LEFT:
                                    g2d.drawImage(Player1_LEFT, null, player.getLocation().getX() * 2, player.getLocation().getY() * 2);
                                    break;
                            }
                            break;
                        case 1:
                            switch (player.getDirection()) {
                                case UP:
                                    g2d.drawImage(Player2_UP, null, player.getLocation().getX() * 2, player.getLocation().getY() * 2);
                                    break;
                                case DOWN:
                                    g2d.drawImage(Player2_DOWN, null, player.getLocation().getX() * 2, player.getLocation().getY() * 2);
                                    break;
                                case RIGHT:
                                    g2d.drawImage(Player2_RIGHT, null, player.getLocation().getX() * 2, player.getLocation().getY() * 2);
                                    break;
                                case LEFT:
                                    g2d.drawImage(Player2_LEFT, null, player.getLocation().getX() * 2, player.getLocation().getY() * 2);
                                    break;
                            }
                            break;
                        case 2:
                            switch (player.getDirection()) {
                                case UP:
                                    g2d.drawImage(Player3_UP, null, player.getLocation().getX() * 2, player.getLocation().getY() * 2);
                                    break;
                                case DOWN:
                                    g2d.drawImage(Player3_DOWN, null, player.getLocation().getX() * 2, player.getLocation().getY() * 2);
                                    break;
                                case RIGHT:
                                    g2d.drawImage(Player3_RIGHT, null, player.getLocation().getX() * 2, player.getLocation().getY() * 2);
                                    break;
                                case LEFT:
                                    g2d.drawImage(Player3_LEFT, null, player.getLocation().getX() * 2, player.getLocation().getY() * 2);
                                    break;
                            }
                            break;
                        case 3:
                            switch (player.getDirection()) {
                                case UP:
                                    g2d.drawImage(Player4_UP, null, player.getLocation().getX() * 2, player.getLocation().getY() * 2);
                                    break;
                                case DOWN:
                                    g2d.drawImage(Player4_DOWN, null, player.getLocation().getX() * 2, player.getLocation().getY() * 2);
                                    break;
                                case RIGHT:
                                    g2d.drawImage(Player4_RIGHT, null, player.getLocation().getX() * 2, player.getLocation().getY() * 2);
                                    break;
                                case LEFT:
                                    g2d.drawImage(Player4_LEFT, null, player.getLocation().getX() * 2, player.getLocation().getY() * 2);
                                    break;
                            }
                            break;
                    }
                }
            }

            // Projectiles
            for (Projectile projectile : projectiles) {
                switch (projectile.getDirection()) {
                    case UP:
                        g2d.drawImage(Projectile_UP, null, (projectile.getLocation().getX() * 2) + 6, (projectile.getLocation().getY() * 2) + 6);
                        break;
                    case DOWN:
                        g2d.drawImage(Projectile_DOWN, null, (projectile.getLocation().getX() * 2) + 6, (projectile.getLocation().getY() * 2) + 6);
                        break;
                    case RIGHT:
                        g2d.drawImage(Projectile_RIGHT, null, (projectile.getLocation().getX() * 2) + 6, (projectile.getLocation().getY() * 2) + 6);
                        break;
                    case LEFT:
                        g2d.drawImage(Projectile_LEFT, null, (projectile.getLocation().getX() * 2) + 6, (projectile.getLocation().getY() * 2) + 6);
                        break;
                }
            }

        } // if (game.getGameState() != null)

        // Map
        if (game != null) {
            ArrayList<Location> walls = game.getMap().getWalls();

            for (Location location : walls) {
                g2d.drawImage(Block, null, location.getX() * 2, location.getY() * 2);
            }
        }
    }

}
