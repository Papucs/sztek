/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameclient;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Papucs
 */
public class SztekSocket{
 Socket s;
 int port;
 String name;
 
 
 public SztekSocket(int port, String name) throws IOException{
     s = new Socket("localhost",65432);
     this.port = port;
     this.name=name;
     
    PrintWriter writer = new PrintWriter(s.getOutputStream());
    Scanner sc = new Scanner(s.getInputStream());
    //System.out.println("12345");
   
    //writer.print(name);
    //writer.flush();
     writer.println(port);
     writer.println(name);
    writer.flush();
    writer.close();
   // System.out.println(sc.nextLine());
    sc.close();
    s.close();
    
    
    
    
    
 }
 
 
}
