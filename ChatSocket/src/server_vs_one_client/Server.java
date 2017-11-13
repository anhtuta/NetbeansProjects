/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_vs_one_client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnhTu
 */
public class Server {
    ServerSocket serverSocket;
    Socket socketOfServer;
    BufferedWriter bw;
    BufferedReader br;
    
    public void createASocket() {
        try {
            serverSocket = new ServerSocket(9999);
            System.out.println("Server is waiting to accept user...");
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void acceptAClient() {
        try {
            socketOfServer = serverSocket.accept(); // Chấp nhận một yêu cầu kết nối từ phía Client. Đồng thời nhận được một đối tượng Socket tại server.
            System.out.println("Accepted a client!");
            
            // Mở luồng vào ra trên Socket tại Server.
            bw = new BufferedWriter(new OutputStreamWriter(socketOfServer.getOutputStream()));
            br = new BufferedReader(new InputStreamReader(socketOfServer.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public String recieveFromClient() {
        try {
            return br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void sendToClient(String response) {
        try {
            bw.write(response);
            bw.newLine();
            bw.flush();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void closeServer() {
        try {
            br.close();
            bw.close();
            socketOfServer.close();
            serverSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public static void main(String[] args) {
        Server server = new Server();
        server.createASocket();
        server.acceptAClient();
        
        String message;
        
        while(true) {
            message = server.recieveFromClient();
            server.sendToClient(message.toUpperCase());

            if(message.equalsIgnoreCase("quit")) { //do có lệnh line = line.toUpperCase(); ở trên nên phải cần IgnoreCase
                break;
            }
        }
        
        System.out.println("Server closed!");
        server.closeServer();
    }
}
