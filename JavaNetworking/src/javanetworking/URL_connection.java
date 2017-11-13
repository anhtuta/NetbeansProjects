/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javanetworking;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author AnhTu
 */
public class URL_connection {
    public static void main(String[] args) throws MalformedURLException, IOException {
        URL url=new URL("http://sis.hust.edu.vn/");
        URLConnection urlCon=url.openConnection();
        System.out.println("urlCon = "+urlCon+"\n");
        
        InputStream inStream=urlCon.getInputStream();
        int i=inStream.read();
        while(i!=-1) {
            System.out.print((char)i);
            i=inStream.read();
        }
    }
}
