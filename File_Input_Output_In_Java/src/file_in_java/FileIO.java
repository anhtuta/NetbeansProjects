/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file_in_java;

/**
 *
 * @author admin
 */
import java.io.*;
import java.util.*;
public class FileIO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PrintWriter w;
        Scanner sc;
        System.out.println("enter somethings to write into file test.txt:");
        try
        {
            w=new PrintWriter(new FileOutputStream("test.txt"));
            sc=new Scanner(System.in);
            String s="";
            do{
                s=sc.nextLine();
                w.println(s);
            } while (s.length()>0);
            w.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
