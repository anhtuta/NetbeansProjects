/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnhTu
 */
public class Server {
    public static void main(String[] args) {
        try {
            System.out.println("begin opening socket...");
            int port=6666;//trên máy tính có mấy nghìn cổng, ko rõ lắm...
            ServerSocket ss = new ServerSocket(port);
            Socket socket=ss.accept();
            
            DataInputStream dataInStream=new DataInputStream(socket.getInputStream()); //dataInStream dùng để nhận dữ liệu từ client
            String str=dataInStream.readUTF(); //đọc dữ liệu từ client
            System.out.println(str);  //in dữ liệu vừa đọc đc
            
            DataOutputStream out=new DataOutputStream(socket.getOutputStream());
            out.writeUTF("server received from client!"); //gửi phản hồi lại client
            
            dataInStream.close();
            out.close();
            socket.close();
            System.out.println("finished");
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
