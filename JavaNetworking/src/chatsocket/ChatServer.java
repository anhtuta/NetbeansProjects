/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatsocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnhTu
 *///chạy server trước rồi tới client

//read data from client: dataInStr dùng để đọc dữ liệu từ client gửi lên server
//push data from server to client: dataOutStr dùng để đẩy data từ server về client
public class ChatServer {
    public static void main(String[] args) {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(3333);
            Socket socket=serverSocket.accept(); //waiting for client connectiong to server
            
            DataInputStream dataInStr=new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutStr=new DataOutputStream(socket.getOutputStream());
            
            Scanner sc=new Scanner(System.in);
            
            System.out.println("Waiting for client to say something first...");
            while(true) {
                //read data from client:
                String str=dataInStr.readUTF();
                if(str.equals("q")) {
                    break; //nếu client gửi "q" thì kết thúc chat
                }
                
                System.out.println("client say: "+str);
                
                //truyen data từ server về client:
                String str2=sc.nextLine();
                dataOutStr.writeUTF(str2);
                dataOutStr.flush(); //đẩy data về client
            }
            
            dataOutStr.close();
            dataInStr.close();
            socket.close();
            serverSocket.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
