/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatsocket2_explain_details;

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
//chương trình server nhận bán kính hình tròn từ client và gửi về diện tích
public class Server {
    public static void main(String[] args) {
        int port=8000;
        try {
            ServerSocket serverSocket=new ServerSocket(port); //tạo ra 1 server socket
            Socket socketToConnectToClient=serverSocket.accept(); //lắng nghe yêu cầu kết nối trên server
            DataInputStream inputFromClient=new DataInputStream(socketToConnectToClient.getInputStream());  //tạo ra 1 luồng để nhận dữ liệu từ client
            DataOutputStream outputToClient=new DataOutputStream(socketToConnectToClient.getOutputStream()); //tạo ra 1 luồng để gửi dữ liệu từ client
            
            System.out.println("Waiting for client to enter the radius...");
            while(true) {
                //đọc 1 số từ client:
                String radius=inputFromClient.readUTF();
                if(radius.equals("q")) {
                    break; //nếu client gửi "q" thì kết thúc chat
                }
                System.out.println("client say: "+radius);
                
                double r=Double.parseDouble(radius);
                double area=r*r*Math.PI;
                
                //gửi kq về:
                outputToClient.writeUTF(String.valueOf(area));
                outputToClient.flush();
                System.out.println("Dien tich="+area);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
