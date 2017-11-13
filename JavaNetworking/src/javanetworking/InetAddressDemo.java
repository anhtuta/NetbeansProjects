/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javanetworking;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnhTu
 */
public class InetAddressDemo {
    public static void main(String[] args) {
        try {
            InetAddress addr=InetAddress.getByName("google.com.vn");
            System.out.println("Địa chỉ IP =   "+addr.getHostAddress());
            System.out.println("Tên trang web: "+addr.getHostName());
        } catch (UnknownHostException ex) {
            Logger.getLogger(InetAddressDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Socket sock = new Socket("www.javatutorial.com", 80);
            InetAddress addr = sock.getInetAddress();
            System.out.println("Connected to " + addr);
            System.out.println(addr.getHostName());    //tên của trang web
            System.out.println(addr.getHostAddress()); //địa chỉ IP của trang web
            sock.close();
        } catch (java.io.IOException e) {
            System.out.println("Can't connect");
            System.out.println(e);
        }

    }
}
