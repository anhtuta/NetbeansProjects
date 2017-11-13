/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file_in_java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnhTu
 */
//cái này chính là filereader và filewriter

public class FileTextDemo {
    public static void main(String[] args) {
        //đọc 1 file ở desktop, ghi kq ra console
        try {
            FileReader fr = new FileReader("C:\\Users\\AnhTu\\Desktop\\syntax java.txt");
            BufferedReader br = new BufferedReader(fr);
            
            String line = "";
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
            
            br.close(); fr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileTextDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileTextDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            ////ghi dữ liệu vào 1 file ở desktop
            FileWriter fw = new FileWriter("E:\\Java\\testjava.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            
            BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\AnhTu\\Desktop\\syntax java.txt"));
            //ghi dữ liệu từ file syntax java.txt vào file testjava:
            String line = br2.readLine();
            while(line != null) {
                System.out.println(line);
                bw.write(line);
                bw.newLine();  //tương đương với: bw.write("\n"); nhưng nên dùng newLine hơn vì có thể hiển thị newLine trong phần mềm notepad
                line = br2.readLine(); //đọc dòng tiếp theo
            }
            
            //cach 2:
//            String line2 = null;
//            while((line2 = br2.readLine()) != null) {
//                bw.write(line2);
//                System.out.println("write successfully");
//            }
//            
            br2.close(); bw.close(); fw.close();
        } catch (IOException ex) {
            Logger.getLogger(FileTextDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
