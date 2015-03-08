/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameclient;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Papucs
 */
public class ClientServer {
    Integer port;
    
    public ClientServer(Integer port){
        this.port=port;
    
    int socks = 0;
    while(true && socks<1){
        try {
            ServerSocket clientServer = new ServerSocket(port);
            Socket s0 = clientServer.accept();
            Scanner sc0 = new Scanner (s0.getInputStream());
            System.out.println(sc0.next());
            ++socks;
            sc0.close();
            clientServer.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
}
