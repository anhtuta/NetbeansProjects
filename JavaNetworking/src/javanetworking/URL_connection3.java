/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javanetworking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnhTu
 */
public class URL_connection3 {
    public static void main(String[] args) {
        try {
            URL url=new URL("http://sis.hust.edu.vn");
            URLConnection urlCon=url.openConnection();
            System.out.println("content = "+urlCon.getContent());
            System.out.println("contentEncoding = "+urlCon.getContentEncoding());
            System.out.println("contentType = "+urlCon.getContentType());
            System.out.println("lastModified = "+urlCon.getLastModified());
            System.out.println("Expiration = "+urlCon.getExpiration());
            System.out.println("content = "+urlCon.getContent());
            System.out.println("IfModifiedSince = "+urlCon.getIfModifiedSince());
            System.out.println("urlCon instanceof HttpURLConnection? " + (urlCon instanceof HttpURLConnection));
            
            ///read this page:
            BufferedReader br=new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
            String line;
            while((line = br.readLine()) != null) { 
                System.out.println(line);  //in ra từng dòng của file. line là dữ liệu trên từng dòng
            }
            br.close();
        } catch (MalformedURLException ex) {
            Logger.getLogger(URL_connection3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(URL_connection3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
