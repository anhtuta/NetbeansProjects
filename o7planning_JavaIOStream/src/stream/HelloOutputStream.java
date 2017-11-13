/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stream;

/**
 *
 * @author AnhTu
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

// ghi từng byte
public class HelloOutputStream {

    public static void main(String[] args) {
        String pathFile = "D:\\Documents\\NetBeansProjects\\JavaIOStream_o7planning\\src\\stream";
        try {
            File dir = new File(pathFile);
            if(!dir.exists())   dir.mkdirs();
            
            // Tạo một luồng ký tự đầu ra với mục đích ghi thông tin vào file
            OutputStream w = new FileOutputStream(pathFile+"\\test_outputStream.txt");

            // Tạo một mảng byte ,ta sẽ ghi các byte này vào file nói trên .
            byte[] by = new byte[]{'H', 'e', 'l', 'l', 'o',' ','w','o','r','l','d'};

            // Ghi lần lượt các ký tự vào luồng, do đầu ra của luồng là file ở trên nên điều này cũng có nghĩa là ghi lần lượt các ký tự vào file
            for (int i = 0; i < by.length; i++) {
                // Ghi ký tự vào luồng
                w.write(by[i]);
            }
            // Đóng luồng đầu ra lại việc ghi xuống file hoàn tất.
            w.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
