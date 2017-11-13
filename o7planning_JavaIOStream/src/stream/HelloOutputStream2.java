/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnhTu
 */
public class HelloOutputStream2 {
    public static void main(String[] args) {
        String pathFile = "D:\\Documents\\NetBeansProjects\\JavaIOStream_o7planning\\src\\stream";
        
        File dir = new File(pathFile);
        if(!dir.exists())   dir.mkdirs();
        
        try {
            OutputStream os = new FileOutputStream(pathFile+"\\test_outputStream.txt");   // Tạo một luồng nhị phân đầu ra với mục đích ghi thông tin vào file
            // Tạo một mảng byte ,ta sẽ ghi các byte này vào file nói trên .
            byte[] by = new byte[] { 'H', 'e', 'l', 'l', 'o', ' ', 31, 34, 92 };
            byte[] by2 = new byte[] { 'H', 'e', 'l', 'l', 'o', ' ', 'b', 'o', 'y' };
            
            // Ghi cả các byte trong mảng byte[] by vào luồng
            os.write(by);

            // Đẩy các byte hiện có trên luồng xuống file .
            os.flush();

            // Tiếp tục ghi các byte trong mảng thứ 2 vào luồng
            os.write(by2);

            // Đóng luồng vào công việc ghi thành công .
            os.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HelloOutputStream2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HelloOutputStream2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
