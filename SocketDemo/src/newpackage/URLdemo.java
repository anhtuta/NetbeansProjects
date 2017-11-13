/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnhTu
 */
public class URLdemo {
    public static void main(String[] args) {
        try {
            URL u1 = new URL("http://www.sun.com/index.html");
            System.out.println("successfully, u1 = "+u1);
        } catch (MalformedURLException ex) {
            Logger.getLogger(URLdemo.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
        }
        
        try {
            URL u2 = new URL("http","www.sun.com","/index.html");
            System.out.println("successfully, u2 = "+u2);
                    } catch (MalformedURLException ex) {
            Logger.getLogger(URLdemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        URL u3,u4;
        try {
            u3 = new URL("https://www.facebook.com/");
            u4 = new URL(u3, "/taanhtu95");
            System.out.println("successfully, u4 = "+u4+"\n");
            
//            BufferedReader br = new BufferedReader(new InputStreamReader(u4.openStream()));
//            String line;
//            while((line = br.readLine()) != null) System.out.println(line);
            //thử với url khác : u5
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(URLdemo.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
        } catch (IOException ex) {
            Logger.getLogger(URLdemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            URL u5 = new URL("http://soict.hust.edu.vn/~tungbt/index.htm");
            BufferedReader br2 = new BufferedReader(new InputStreamReader(u5.openStream()));
            String line;
            while((line = br2.readLine()) != null) System.out.println(line);;
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(URLdemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(URLdemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
