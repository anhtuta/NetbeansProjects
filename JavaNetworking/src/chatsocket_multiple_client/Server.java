/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatsocket_multiple_client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
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
        int port=8000;
        try {
            ServerSocket serverSocket=new ServerSocket(port);
            int clientNum=1;
            while(true) {
                Socket connectToClient=serverSocket.accept();
                System.out.println("Khởi động cho luồng client: "+clientNum);
                InetAddress clientInetAddress=connectToClient.getInetAddress();
                String name=clientInetAddress.getHostName();
                System.out.println("Host name của client "+clientNum+" là: "+name);
                System.out.println("Địa chỉ IP của client "+clientNum+" là: "+clientInetAddress.getHostAddress());
                
                HandleAClient thread=new HandleAClient(connectToClient, name);
                thread.start();
                clientNum++;
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class HandleAClient extends Thread {
    private Socket connectToClient;
    String clientHostname;
    
    public HandleAClient(Socket socket, String hostname) {
        connectToClient=socket;
        clientHostname=hostname;
    }

    @Override
    public void run() {
        try {
            DataInputStream inputFromClient=new DataInputStream(connectToClient.getInputStream());
            DataOutputStream outputToClient=new DataOutputStream(connectToClient.getOutputStream());
            
            while(true) {
                String str=inputFromClient.readUTF();
                System.out.println("\nBán kính nhận từ client "+clientHostname+" là: "+str);
                double r=Double.parseDouble(str);
                double area=r*r*Math.PI;
                
                outputToClient.writeUTF(String.valueOf(area));
                outputToClient.flush();
            }
        } catch (IOException ex) {
            Logger.getLogger(HandleAClient.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
}