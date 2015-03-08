package gameclient;

import data.Game;
import data.Map;
import data.KeyboardCommand;
import data.GameState;
import gameclient.gui.Board;
import gameclient.gui.GameFrame;
import gameclient.gui.GamePanel;
import java.io.IOException;

public class GameClient {

    private Game game;
    private GameFrame gameFrame;
    private GamePanel gamePanel;
    private Connection connection;
    private Board board;

    // next releas
    public GameClient() {
        this.game = new Game(new Map(), null);

        //this.gamePanel = new GamePanel(this.game);
        //this.gameFrame = new GameFrame(this.gamePanel);
        this.board = new Board(game);
        this.board.setGameClient(this);
        //this.gamePanel.setGameClient(this);
        game.setGameState(new GameState());

        //this.connection = new Connection(this, args[0], args[1], args[2]);
       // this.connection = new Connection(this, "1", "localhost", "12345");
    }
    
    public void startConnection(){
        this.connection = new Connection(this,"1","localhost", "12345");
    }

    public Board getBoard() {
        return board;
    }

    public void setNewGameState(GameState gameState) {
        this.game.setGameState(gameState);
        this.board.paint();
    }

    public void sendKeyboardCommand(KeyboardCommand keyboardCommand) throws IOException {
        this.connection.sendKeyboardCommand(keyboardCommand);
    }

}
