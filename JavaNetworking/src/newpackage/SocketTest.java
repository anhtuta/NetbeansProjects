/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnhTu
 */
public class SocketTest {
    //ko chạy ctrinh này đc, lỗi Connection timed out
    public static void main(String[] args) {
        try {
            String hostname="sis.hust.edu.vn";
            Socket s=new Socket(hostname, 8000);
            BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
            
            String str;
            while((str=br.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IOException ex) {
            Logger.getLogger(SocketTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
