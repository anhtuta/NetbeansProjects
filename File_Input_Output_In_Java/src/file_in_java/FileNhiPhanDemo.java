/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file_in_java;

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
public class FileNhiPhanDemo {
    public static void main(String[] args) {
        String source = "Tao là Tú Toc Xu đây\nNick cũ của tao dài quá nên tao đổi lại thôi";
        byte [] buf = source.getBytes();
        
        try {
            OutputStream f1 = new FileOutputStream("E:\\Java\\testjava2.txt");
            for (int i = 0; i < buf.length; i++) {
                f1.write(buf[i]);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileNhiPhanDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileNhiPhanDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
