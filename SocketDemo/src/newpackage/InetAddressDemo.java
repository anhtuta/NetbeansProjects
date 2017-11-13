/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnhTu
 */
public class InetAddressDemo {
    public static void main(String[] args) {
        //vi du 1
        try {
            InetAddress host = InetAddress.getByName("sis.hust.edu.vn");
            System.out.println(host);
            if(!host.isReachable(5000)) System.out.println("could not connect this host");
        } catch (UnknownHostException ex) {
            Logger.getLogger(InetAddressDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(InetAddressDemo.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("could not find this host");
        }
        
        //vi du 2
        byte[] addr = {8,8,8,8};
        try {
            InetAddress host2 = InetAddress.getByAddress(addr);
            if(!host2.isReachable(5000)) System.out.println("could not connect this host"); //Cố gắng kết nối trong 5s. sau 5 giây nếu ko kết nối đc thì mới thông báo
        } catch (UnknownHostException ex) {
            Logger.getLogger(InetAddressDemo.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("could not find this host");
        } catch (IOException ex) {
            Logger.getLogger(InetAddressDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
