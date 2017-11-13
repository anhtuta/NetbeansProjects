/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket_thread;

/**
 *
 * @author AnhTu
 */

///Run Server first, and then run client
//see more at project: o7planning_JavaSocket
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        System.out.println("Server is waiting for client...");
        
        int clientNum = 0;
        
        try {
            serverSocket = new ServerSocket(7777);// Mở một ServerSocket tại cổng 7777.
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            while(true) {
                Socket socketSOfServer = serverSocket.accept();
                new ServerThread(clientNum++, socketSOfServer).start();
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                serverSocket.close();
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    static class ServerThread extends Thread {
        private int clientNum;
        private Socket socketOfServer;

        public ServerThread(int clientNum, Socket socketOfServer) {
            this.clientNum = clientNum;
            this.socketOfServer = socketOfServer;
            
            System.out.println("New connection with client#" + this.clientNum +" at " + socketOfServer);
        }

        @Override
        public void run() {
            try {
                String line;
                BufferedReader is = new BufferedReader(new InputStreamReader(socketOfServer.getInputStream()));
                BufferedWriter os = new BufferedWriter(new OutputStreamWriter(socketOfServer.getOutputStream()));
            
                while(true) {
                    line = is.readLine();
                    line = line.toUpperCase();
                    
                    os.write(line);
                    os.newLine();
                    os.flush();
                    
                    if(line.equalsIgnoreCase("quit")) {
                        os.write("quitserver");
                        os.newLine();
                        os.flush();
                        break;
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
        
    }
}
