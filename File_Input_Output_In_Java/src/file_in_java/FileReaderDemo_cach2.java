/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file_in_java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnhTu
 */
public class FileReaderDemo_cach2 {
    
    public static void main(String[] args) {
        
        try {
            FileReader fr = new FileReader("anhtu.txt");
            BufferedReader br = new BufferedReader(fr);
            
            String line = "";
            line = br.readLine();
            while(line != null) { 
                System.out.println(line);  //in ra từng dòng của file. line là dữ liệu trên từng dòng
                line = br.readLine();
            }
            
            br.close();
            fr.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileReaderDemo_cach2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileReaderDemo_cach2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
