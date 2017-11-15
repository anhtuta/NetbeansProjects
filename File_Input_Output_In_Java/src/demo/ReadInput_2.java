/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnhTu
 */
public class ReadInput_2 {
    public static void main(String[] args) {
        int n, s, t;
        int [][]w;
        try {
            FileInputStream fis = new FileInputStream("D:\\Documents\\C,C++\\dijkstra.txt");
            DataInputStream dis = new DataInputStream(fis);
            
            Scanner sc = new Scanner(dis);
            n = sc.nextInt();
            s = sc.nextInt();
            t = sc.nextInt();
            
            System.out.println("n = " + n);
            System.out.println("s = " + s);
            System.out.println("t = " + t);
            
            w = new int[n+1][n+1];
            
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    int temp = sc.nextInt();
                    w[i][j] = temp;
                }
            }
            
            System.out.println("Mang w:");
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    System.out.print(w[i][j] + " ");
                }
                System.out.println();
            }
            
            dis.close();
            fis.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadInput_2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadInput_2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
