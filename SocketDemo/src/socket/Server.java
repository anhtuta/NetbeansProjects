/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

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
///Run Server first, and then run client
//see more at project: o7planning_JavaSocket

public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socketOfServer = null;
        String line;
        BufferedReader is = null;
        BufferedWriter os = null;
        
        try {
            serverSocket = new ServerSocket(9999);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Server is waiting for a client...");
        
        try {
            socketOfServer = serverSocket.accept();
            System.out.println("Accept a client");
            
            is = new BufferedReader(new InputStreamReader(socketOfServer.getInputStream()));
            os = new BufferedWriter(new OutputStreamWriter(socketOfServer.getOutputStream()));
            
            while(true) {
                line = is.readLine();   //đọc 1 dòng gửi từ client sang
                line = line.toUpperCase();
                os.write(line);
                os.newLine();
                os.flush();     //nghĩa là: client cứ gửi cái j tới thì gửi lại y nguyên nhưng viết hoa tất!
                
                if(line.equalsIgnoreCase("quit")) {
                    os.write("You just type \"Quit\", so I closed server!");
                    os.newLine();
                    os.flush();
                    
                    os.write("serversaidquit");
                    os.newLine();
                    os.flush();
                    
                    break;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            os.close();
            is.close();
            socketOfServer.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Server stopped!");
    }
}
