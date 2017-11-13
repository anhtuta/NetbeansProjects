/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnhTu
 */
public class NewClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên:");
        String s = "";
        s = sc.nextLine();
        System.out.println("Tên b là: "+s);
        
//        
//        BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
//        // Biến name
//        String name = "";
//        System.out.println("Please Enter Your Name:");
//        // Tiến hành đọc từ bàn phím
//        try {
//            name = dataIn.readLine();
//        } catch (IOException e) {
//            System.out.println("Error!");
//        }
//        // hiển thị tên
//        System.out.println("Hello " + name + "!");
//        
//        DataInputStream dis = new DataInputStream(System.in);
//        System.out.println("enter st:");
//        try {
//            String s2 = dis.readUTF();
//            System.out.println("s2 = "+s2);
//        } catch (IOException ex) {
//            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
