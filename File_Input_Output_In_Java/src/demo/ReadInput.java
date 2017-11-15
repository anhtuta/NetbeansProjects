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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnhTu
 */

/*
file demo.txt có dạng sau:

dhbkhn
ttudstp
5
1 2 3 4 5
*/
public class ReadInput {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("D:\\Documents\\demo.txt");
            DataInputStream dis = new DataInputStream(fis);
            
            String str1 = dis.readLine();
            String str2 = dis.readLine();
            System.out.println("str1 = " + str1 + ", str2 = " + str2);
            
            
            int n = dis.readInt();
            System.out.println("n = " + n);
            int []a = new int[n];
            for (int i = 0; i < n; i++) {
                int temp = dis.readInt();
                a[i] = temp;
            }
            
            dis.close();
            fis.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadInput.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadInput.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
