/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket2;

import socket.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
        // Địa chỉ máy chủ.
        final String serverHost = "localhost";

        Socket socketOfClient = null;
        BufferedWriter os = null;
        BufferedReader is = null;

        try {
            socketOfClient = new Socket(serverHost, 9999);
            os = new BufferedWriter(new OutputStreamWriter(socketOfClient.getOutputStream()));
            is = new BufferedReader(new InputStreamReader(socketOfClient.getInputStream()));
            
            Scanner sc = new Scanner(System.in);
            String s = "";
            String response;
            
            while(!s.equalsIgnoreCase("quit")) {
                System.out.println("Say something...");
                //Đọc DL từ bàn phím
                s = sc.nextLine();  // Có thể viết gọn vòng while như sau và bỏ lệnh này đi: while(!(s = sc.nextLine()).equals("quit"))
                
                try {
                //Sau đó đẩy lên socket và gửi tới server:
                    os.write(s);
                    os.newLine();
                    os.flush();
                } catch (java.net.SocketException e) {
                    System.out.println("Server is stopped!");
                    break;
                }
                
                // sau đó nhận phản hồi từ server:
                response = is.readLine();
                if(response != null && !response.equals("")) {
                    System.out.println("Server response: "+response);
                } 
                if(response.equals("QUIT")) System.out.println("Disconnected!");;
            }
        
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            os.close();
            is.close();
            socketOfClient.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
