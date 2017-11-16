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

/**
 *
 * @author AnhTu
 */
public class FileWriterDemo {
    public static void main(String[] args) {
        ////tạo 1 file mới, sau đó ghi vào file đó
        try {
            File file = new File("anhtu.txt");
            file.createNewFile();  //tạo 1 file mới
            
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            
            //ghi vào file anhtu.txt:
            bw.write("tạ anh tú"); bw.newLine(); //nếu thay 2 lệnh này = lệnh bw.write("tạ anh tú\n"); thì phần mềm Notepad ko đọc được ký tự xuống dòng
            bw.write("bkhn"); bw.newLine();
            bw.write("đtvt");
            
            //đóng luồng lại:
            bw.close();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(FileWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        ////////////xong file có tên anhtu.txt trong thư mục của project
        
        ////////tạo file mới lần nữa rồi ghi vào file này nhưng dùng hàm
        FileWriterDemo file2 = new FileWriterDemo();
        file2.writeFile("att.txt","đây là lần thất bại thứ bao nhiêu rồi? cuối cùng cũng thành công");
    }
    
    public void writeFile(String filename, String data) {
        try {
            File file = new File(filename);
            file.createNewFile();
            
            FileWriter fw = new FileWriter(file);
            
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write(data); //ghi dữ liệu data vào file
            bw.newLine();
            bw.write("kết thúc ghi file");
            bw.close();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(FileWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
