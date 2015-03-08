package gameclient;

import data.KeyboardCommand;
import data.GameState;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public final class Connection {

    private Socket s;
    private ObjectInputStream fromServerStream;
    private ObjectOutputStream toServerStream;
    private GameClient gameClient;

    //private final String serverIP = "localhost";
    //private final String serverIP = "192.168.0.102";
    //private final int serverPort = 1234;
    public Connection(GameClient gameClient, String id, String ip, String port) {
        try {
            System.out.println(ip  + " " + Integer.parseInt(port));
            this.s = new Socket("localhost", 65432);
            this.toServerStream = new ObjectOutputStream(s.getOutputStream());
            this.fromServerStream = new ObjectInputStream(s.getInputStream());
            this.gameClient = gameClient;
            toServerStream.writeBytes(port);
            toServerStream.flush();
            validate(id);
            
            runMyInputHandling();
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            //JOptionPane.showMessageDialog(gameClient.getGameFrame(), "Could not connect to server, exiting program.",
              //      "CONNECTION ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    public ObjectInputStream getFromServerStream() {
        return fromServerStream;
    }

    public ObjectOutputStream getToServerStream() {
        return toServerStream;
    }

    public void validate(String id) throws IOException {
        toServerStream.writeObject(id);
        toServerStream.flush();
        toServerStream.reset();
    }

    public void runMyInputHandling() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ObjectInputStream myFromServerStream = getFromServerStream();
                while (!s.isClosed()) {
                    try {
                        Object receivedMessage = myFromServerStream.readObject();
                        if (receivedMessage instanceof GameState) {
                            GameState receivedState = (GameState) receivedMessage;
                            gameClient.setNewGameState(receivedState);
                        } else if (receivedMessage instanceof String) {
                            String receivedString = (String) receivedMessage;
                            if (receivedString.equals("win")) {
                               // JOptionPane.showMessageDialog(gameClient.getGameFrame(), "YOU WIN!",
                                 //       "", JOptionPane.ERROR_MESSAGE);
                            } else if (receivedString.equals("lose")) {
                                new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                     //   JOptionPane.showMessageDialog(gameClient.getGameFrame(), "You lost :(",
                                       //         "", JOptionPane.ERROR_MESSAGE);
                                    }
                                }).start();
                            }
                        }
                    } catch (IOException | ClassNotFoundException ex) {
                        Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
                      // JOptionPane.showMessageDialog(gameClient.getGameFrame(), "Connection to server was lost, exiting program.",
                        //        "CONNECTION ERROR", JOptionPane.ERROR_MESSAGE);
                        System.exit(1);
                    }
                }
            }
        }).start();
    }

    public void sendKeyboardCommand(KeyboardCommand keyboardCommand) throws IOException {
        toServerStream.writeObject(keyboardCommand);
        toServerStream.flush();
        toServerStream.reset();
    }

}


