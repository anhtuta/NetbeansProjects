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
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author AnhTu
 */
public class URL_connection2 {

    public static void main(String[] args) {
        {
            try {
                URL url = new URL("http://sis.hust.edu.vn");
                URLConnection urlConnection = url.openConnection();
                HttpURLConnection connection = null;
                if (urlConnection instanceof HttpURLConnection) {
                    connection = (HttpURLConnection) urlConnection;
                } else {
                    System.out.println("Please enter an HTTP URL.");
                    return;
                }
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String current;
                while ((current = in.readLine()) != null) {
                    System.out.println(current);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
