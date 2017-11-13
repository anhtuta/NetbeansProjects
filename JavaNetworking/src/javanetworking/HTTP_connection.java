/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javanetworking;

import java.io.IOException;
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
public class HTTP_connection {
    public static void main(String[] args) {
        URL url;
        try {
            url = new URL("http://sis.hust.edu.vn/");
            HttpURLConnection httpUrlCon=(HttpURLConnection) url.openConnection();
            
            //đọc giá trị trả về trong header:
            for (int i = 0; i < httpUrlCon.getHeaderFields().size(); i++) {
                System.out.println(httpUrlCon.getHeaderFieldKey(i)+" - "+httpUrlCon.getHeaderField(i));
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(HTTP_connection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HTTP_connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
