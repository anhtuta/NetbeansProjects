/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatsocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnhTu
 */
public class ChatClient {
    public static void main(String[] args) {
        try {
            Socket socket=new Socket("localhost", 3333); //localhost nghĩa là cả server và client chỉ dùng chạy trong máy này thôi
            DataInputStream dataInStr=new DataInputStream(socket.getInputStream());//để đọc data từ server
            DataOutputStream dataOutStr=new DataOutputStream(socket.getOutputStream());
            Scanner sc=new Scanner(System.in);
            while(true) {
                //truyền data lên server
                String str=sc.nextLine();
                dataOutStr.writeUTF(str);
                dataOutStr.flush(); //push data onto server
                if(str.equals("q")) break;
                
                //đọc data từ server:
                String str2=dataInStr.readUTF();
                System.out.println("Server say: "+str2);
            }
            
            dataOutStr.close();
            dataInStr.close();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
