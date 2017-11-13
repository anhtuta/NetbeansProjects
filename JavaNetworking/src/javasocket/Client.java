/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnhTu
 */
public class Client {
    public static void main(String[] args) {
        try {
            System.out.println("client connecting...");
            Socket socket=new Socket("localhost", 6666); //this client connect to server=localhost, port=6666
            
            DataOutputStream dos=new DataOutputStream(socket.getOutputStream()); //đẩy dữ liệu từ client lên server
            dos.writeUTF("Hello anhtu's server");
            //dos.flush(); //push data onto server
            
            DataInputStream din=new DataInputStream(socket.getInputStream());
            String kq=din.readUTF();  //đọc data từ server
            System.out.println(kq); //in data vừa đọc đc
            
            din.close();
            dos.close();
            socket.close();
            System.out.println("client finished");
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
