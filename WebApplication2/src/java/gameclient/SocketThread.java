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
public class SocketThread extends Thread{
    
    Integer port;
    String hostName;
    
    public SocketThread(Integer port, String name) {
       this.port=port;
       hostName=name;
    }

    @Override
    public void run() {
        try {
            new SztekSocket(port, hostName);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
    
}
