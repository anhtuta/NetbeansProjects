/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatsocket_multiple_client;

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
            Socket socketToConnectToServer =new Socket("localhost", 8000);
            DataInputStream inputFromServer=new DataInputStream(socketToConnectToServer.getInputStream());
            DataOutputStream outputToServer=new DataOutputStream(socketToConnectToServer.getOutputStream());
            
            Scanner str=new Scanner(System.in);
            while(true) {
                System.out.println("Nhap ban kinh: ");
                String radius=str.nextLine();
                outputToServer.writeUTF(radius);
                outputToServer.flush();
                
                String area=inputFromServer.readUTF();
                System.out.println("Diện tích là: "+area);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
