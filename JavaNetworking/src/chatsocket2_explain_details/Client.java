/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatsocket2_explain_details;

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
public class Client {
    public static void main(String[] args) {
        try {
            Socket socketToConnectToServer =new Socket("localhost", 3333);
            DataInputStream inputFromServer=new DataInputStream(socketToConnectToServer.getInputStream());
            DataOutputStream outputToServer=new DataOutputStream(socketToConnectToServer.getOutputStream());
            
            //DataInputStream str=new DataInputStream(System.in); //tạo 1 luồng để nhập data từ bàn phím
            Scanner str=new Scanner(System.in);
            while(true) {
                System.out.println("Nhap ban kinh: ");
                //CHÚ Ý: LÀM NHƯ SAU KO CHẠY ĐC:
                //do đó cần phải dùng hàm nextLine(), sau đó ép kiểu về double:
//                double r=str.nextDouble();
//                
//                outputToServer.writeDouble(r);
//                outputToServer.flush();
//                
//                String area=inputFromServer.readUTF();
//                System.out.println("Dien tich hinh tron nhan duoc tu server: "+area);
                String radius=str.nextLine();
                outputToServer.writeUTF(radius);
                outputToServer.flush();
                //if(radius.equalsIgnoreCase("q")) break;
                
                String area=inputFromServer.readUTF();
                System.out.println("Diện tích là: "+area);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
