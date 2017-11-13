/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file_in_java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnhTu
 */
public class FileSplitDemo {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("data.txt"));
            String line = br.readLine();
            
            while(line != null) {
                String [] str = line.split("-");
                System.out.println(str[0] + ","+str[1]);
                line = br.readLine();
            }
            
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileSplitDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileSplitDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
