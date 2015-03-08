package gameclient.gui;


import data.Game;
import data.KeyboardCommand;
import data.Location;
import data.Map;
import data.Player;
import data.Projectile;
import gameclient.Connection;
import gameclient.GameClient;
import java.awt.event.ActionEvent;
import static java.awt.event.KeyEvent.VK_DOWN;
import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;
import static java.awt.event.KeyEvent.VK_SPACE;
import static java.awt.event.KeyEvent.VK_UP;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Papucs
 */
public class Board {
    
    
    private Game game;
    private GameClient gameClient;
    
    private HashMap<Integer, Integer> playerIDandNumberMap;
    private boolean playerIDandNumberMapInited = false;
    
    private final String PLAYER1_UP = "\"kepek/KEKTANK_UP.png\"";
    private final String PLAYER1_DOWN = "\"kepek/KEKTANK_DOWN.png\"";
    private final String PLAYER1_LEFT = "\"kepek/KEKTANK_LEFT.png\"";
    private final String PLAYER1_RIGHT = "\"kepek/KEKTANK_RIGHT.png\"";
    
    private final String PLAYER2_UP = "\"kepek/PIROSTANK_UP.png\"";
    private final String PLAYER2_DOWN = "\"kepek/PIROSTANK_DOWN.png\"";
    private final String PLAYER2_LEFT = "\"kepek/PIROSTANK_LEFT.png\"";
    private final String PLAYER2_RIGHT = "\"kepek/PIROSTANK_RIGHT.png\"";
                    
    private final String PLAYER3_UP = "\"kepek/ZOLDTANK_UP.png\"";
    private final String PLAYER3_DOWN = "\"kepek/ZOLDTANK_DOWN.png\"";
    private final String PLAYER3_LEFT = "\"kepek/ZOLDTANK_LEFT.png\"";
    private final String PLAYER3_RIGHT = "\"kepek/ZOLDTANK_RIGHT.png\"";
    
    private final String PLAYER4_UP = "\"kepek/SARGATANK_UP.png\"";
    private final String PLAYER4_DOWN = "\"kepek/SARGATANK_DOWN.png\"";
    private final String PLAYER4_LEFT = "\"kepek/SARGATANK_LEFT.png\"";
    private final String PLAYER4_RIGHT = "\"kepek/SARGATANK_RIGHT.png\"";
    
    private final String BLOCK = "\"kepek/FAL.png\"";
    
     private Connection connection;
    
   public Board(Game game){
       this.game = game;//new Game(new Map(), null);
      
       
   }
   
   public void setGameClient(GameClient gameClient) {
        this.gameClient = gameClient;
    }

    public void setGame(Game game) {
        this.game = game;
    }
    
    private void initPlayerIDandNumberMap() {
        this.playerIDandNumberMap = new HashMap<>();
        ArrayList<Player> players = this.game.getGameState().getPlayers();

        for (int i = 0; i < players.size(); ++i) {
            this.playerIDandNumberMap.put(players.get(i).getPlayerNumber(), i);
        }

        this.playerIDandNumberMapInited = true;

    }
   
   public String paint(){
       
       String board="";
       
       if (game.getGameState() != null) {

            if (!playerIDandNumberMapInited) {
                initPlayerIDandNumberMap();
            }
       
       ArrayList<Player> players = game.getGameState().getPlayers();
            ArrayList<Projectile> projectiles = game.getGameState().getProjectiles();

           //Players
            board+="<script>window.onload = function() {var blocks = document.getElementById(\"blocks\");var canvas = document.getElementById(\"myCanvas\");var ctx = canvas.getContext(\"2d\"); ";
                               
            
            
            for (Player player : players) {
                if (player.isAlive()) {
                    switch (playerIDandNumberMap.get(player.getPlayerNumber())) {
                        case 0:

                            switch (player.getDirection()) {
                                case UP:
                                    board+="var player1 =document.getElementById(\"player1\");player1.src="+PLAYER1_UP+";ctx.drawImage(player1, "+Integer.toString(player.getLocation().getX() * 2)+","+Integer.toString(player.getLocation().getY() * 2)+");";
                                    break;
                                case DOWN:
                                    board+="var player1 =document.getElementById(\"player1\");player1.src="+PLAYER1_DOWN+";ctx.drawImage(player1, "+Integer.toString(player.getLocation().getX() * 2)+","+Integer.toString(player.getLocation().getY() * 2)+");";
                                    break;
                                case RIGHT:
                                    board+="var player1 =document.getElementById(\"player1\");player1.src="+PLAYER1_RIGHT+";ctx.drawImage(player1, "+Integer.toString(player.getLocation().getX() * 2)+","+Integer.toString(player.getLocation().getY() * 2)+");";
                                    break;
                                case LEFT:
                                    board+="var player1 =document.getElementById(\"player1\");player1.src="+PLAYER1_LEFT+";ctx.drawImage(player1, "+Integer.toString(player.getLocation().getX() * 2)+","+Integer.toString(player.getLocation().getY() * 2)+");";
                                    break;
                            }
                            break;
                        case 1:
                           switch (player.getDirection()) {
                                case UP:
                                    board+="var player2 =document.getElementById(\"player2\");player2.src="+PLAYER2_UP+";ctx.drawImage(player2, "+Integer.toString(player.getLocation().getX() * 2)+","+Integer.toString(player.getLocation().getY() * 2)+");";
                                    break;
                                case DOWN:
                                    board+="var player2 =document.getElementById(\"player2\");player2.src="+PLAYER2_DOWN+";ctx.drawImage(player2, "+Integer.toString(player.getLocation().getX() * 2)+","+Integer.toString(player.getLocation().getY() * 2)+");";
                                    break;
                                case RIGHT:
                                    board+="var player2 =document.getElementById(\"player2\");player2.src="+PLAYER2_RIGHT+";ctx.drawImage(player2, "+Integer.toString(player.getLocation().getX() * 2)+","+Integer.toString(player.getLocation().getY() * 2)+");";
                                    break;
                                case LEFT:
                                    board+="var player2 =document.getElementById(\"player2\");player2.src="+PLAYER2_LEFT+";ctx.drawImage(player2, "+Integer.toString(player.getLocation().getX() * 2)+","+Integer.toString(player.getLocation().getY() * 2)+");";
                                    break;
                            }
                            break;
                        case 2:
                            switch (player.getDirection()) {
                                case UP:
                                    board+="var player3 =document.getElementById(\"player3\");player3.src="+PLAYER3_UP+";ctx.drawImage(player3, "+Integer.toString(player.getLocation().getX() * 2)+","+Integer.toString(player.getLocation().getY() * 2)+");";
                                    break;
                                case DOWN:
                                    board+="var player3 =document.getElementById(\"player3\");player3.src="+PLAYER3_DOWN+";ctx.drawImage(player3, "+Integer.toString(player.getLocation().getX() * 2)+","+Integer.toString(player.getLocation().getY() * 2)+");";
                                    break;
                                case RIGHT:
                                    board+="var player3 =document.getElementById(\"player3\");player3.src="+PLAYER3_RIGHT+";ctx.drawImage(player3, "+Integer.toString(player.getLocation().getX() * 2)+","+Integer.toString(player.getLocation().getY() * 2)+");";
                                    break;
                                case LEFT:
                                    board+="var player3 =document.getElementById(\"player3\");player3.src="+PLAYER3_LEFT+";ctx.drawImage(player3, "+Integer.toString(player.getLocation().getX() * 2)+","+Integer.toString(player.getLocation().getY() * 2)+");";
                                    break;
                            }
                            break;
                        case 3:  
                            switch (player.getDirection()) {
                                case UP:
                                    board+="var player4 =document.getElementById(\"player4\");player4.src="+PLAYER4_UP+";ctx.drawImage(player4, "+Integer.toString(player.getLocation().getX() * 2)+","+Integer.toString(player.getLocation().getY() * 2)+");";
                                    break;
                                case DOWN:
                                    board+="var player4 =document.getElementById(\"player4\");player4.src="+PLAYER4_DOWN+";ctx.drawImage(player4, "+Integer.toString(player.getLocation().getX() * 2)+","+Integer.toString(player.getLocation().getY() * 2)+");";
                                    break;
                                case RIGHT:
                                    board+="var player4 =document.getElementById(\"player4\");player4.src="+PLAYER4_RIGHT+";ctx.drawImage(player4, "+Integer.toString(player.getLocation().getX() * 2)+","+Integer.toString(player.getLocation().getY() * 2)+");";
                                    break;
                                case LEFT:
                                    board+="var player4 =document.getElementById(\"player4\");player4.src="+PLAYER4_LEFT+";ctx.drawImage(player4, "+Integer.toString(player.getLocation().getX() * 2)+","+Integer.toString(player.getLocation().getY() * 2)+");";
                                    break;
                            }
                            break;
                    }
                }
            }
            
            
            if (game != null) {
            ArrayList<Location> walls = game.getMap().getWalls();
           
            int i=0;
            for (Location location : walls) {
                board+="var wall"+i+" =document.createElement(\'img\');wall"+i+".src="+BLOCK+";blocks.appendChild(wall"+i+");ctx.drawImage(wall"+i+", "+Integer.toString(location.getX() * 2)+","+Integer.toString(location.getY() * 2)+");";
            ++i;
            }
            
        }
       }
       board+="}</script>";
       return board;
   }
   
  // public void initializeKeyboardStuff() {
       
       public void shoot(){
        Action shootAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    System.out.println("space pressed");
                    gameClient.sendKeyboardCommand(new KeyboardCommand(VK_SPACE, true));
                } catch (IOException ex) {
                    Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
       }
       
       public void pressedLeft(){
       Action pressedLeftAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    System.out.println("left pressed");
                    gameClient.sendKeyboardCommand(new KeyboardCommand(VK_LEFT, true));
                } catch (IOException ex) {
                    Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
       };
       }
       /*
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
        };*/
/*
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
        getActionMap().put("rightReleased", releasedRightAction);*/
   // }
}
