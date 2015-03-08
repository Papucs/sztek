/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameclient;

import java.io.IOException;

/**
 *
 * @author Papucs
 */
public class ClientServerThread extends Thread{
    
    Integer port;
    
    public ClientServerThread(Integer port) {
       this.port=port;
    }

    @Override
    public void run() {
        try {
            new ClientServer(port);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
    
    
}
