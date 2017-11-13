/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket_thread;

/**
 *
 * @author AnhTu
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
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
            socketOfClient = new Socket(serverHost, 7777);
            os = new BufferedWriter(new OutputStreamWriter(socketOfClient.getOutputStream()));
            is = new BufferedReader(new InputStreamReader(socketOfClient.getInputStream()));
            
            ///gửi vài dòng dữ liệu tới server qua luồng ra os:
            os.write("Hello server");
            os.newLine();
            os.flush();
            
            os.write("I'm Ta anh tu");
            os.newLine();
            os.flush();
            
            os.write("quit");
            os.newLine();
            os.flush();
            
            
            //gửi hết xong thì chờ server đáp lại từ luồng vào is:
            String response;
            while((response = is.readLine()) != null) {
                System.out.println("Server response: "+response);
                if(response.equalsIgnoreCase("quitserver")) {
                    break;
                }
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
        System.out.println("closed connection to server. Done");
    }
}
