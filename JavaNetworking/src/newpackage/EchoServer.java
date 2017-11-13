/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketImpl;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnhTu
 */
//muốn chạy ctrinh này cần sử dụng telnet để kết nối với server: 127.0.0.1 và cổng 8189
public class EchoServer {
    public static void main(String[] args) {
        int port=8189;
        try {
            ServerSocket ss=new ServerSocket(port);
            Socket inComing=ss.accept();
            
            BufferedReader br=new BufferedReader(new InputStreamReader(inComing.getInputStream()));
            PrintWriter pw=new PrintWriter(inComing.getOutputStream(), true);
            
            pw.println("Welcome to my server, Enter anything to chat to me, Enter Bye to exit...");
            String str;
            while((str=br.readLine()) != null) {
                System.out.println("Echo: "+str);
                if(str.trim().equalsIgnoreCase("bye")) break;
            }
            
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(EchoServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
