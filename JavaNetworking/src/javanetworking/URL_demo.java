/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javanetworking;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnhTu
 */
public class URL_demo {
    public static void main(String[] args) {
        try {
            //URL url=new URL("https://www.facebook.com/photo.php?fbid=1598728527026527&set=a.1389115267987855.1073741830.100006681845792&type=3&theater");
            URL url=new URL("http://www.amrood.com/index.htm?language=en#j2se");
            System.out.println("URL is " + url.toString());
            System.out.println("protocol is " + url.getProtocol());
            System.out.println("authority is " + url.getAuthority());
            System.out.println("file name is " + url.getFile());
            System.out.println("host is " + url.getHost());
            System.out.println("path is " + url.getPath());
            System.out.println("port is " + url.getPort());
            System.out.println("default port is " + url.getDefaultPort());
            System.out.println("query is " + url.getQuery());
            System.out.println("ref is " + url.getRef());
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(URL_demo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
