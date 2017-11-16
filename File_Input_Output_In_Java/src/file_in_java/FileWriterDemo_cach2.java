/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file_in_java;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FilterWriter;
import java.io.PrintWriter;

/**
 *
 * @author AnhTu
 */
public class FileWriterDemo_cach2 {
    public static void main(String[] args) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("anhtu.txt")); //nếu ko có file này thì nó tự tạo 1 file mới
            
            //ghi vào file anhtu.txt:
            bw.write("tạ anh tú"); bw.newLine(); //nếu thay 2 lệnh này = lệnh bw.write("tạ anh tú\n"); thì phần mềm Notepad ko đọc được ký tự xuống dòng
            bw.write("bkhn"); bw.newLine();
            bw.write("đtvt");
            
            //đóng luồng lại:
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(FileWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        ////////////xong file có tên anhtu.txt trong thư mục của project
        
        //có thể dùng cách khác: dùng printwriter:
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("anhtu2.txt"));
            PrintWriter pw = new PrintWriter(bw);
            //ghi vào file anhtu2.txt:
            pw.println("Hôm nay là thứ 6");
            pw.println("Hôm nay là ngày 6/1/2017");
            pw.println("Hôm nay tao sẽ xem phim");
            
            //đóng luồng lại:
            bw.close();
            pw.close();
        } catch (IOException ex) {
            Logger.getLogger(FileWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}