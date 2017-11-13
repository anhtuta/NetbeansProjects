/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reader_writer;

/**
 *
 * @author AnhTu
 */
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import vl.Values;

//Reader là class trìu tượng, các luồng đọc ký tự đều mở rộng từ class này.

public class HelloReader {

    public static void main(String[] args) throws IOException {
        File folder = new File(Values.TEST_FOLDER);
        if(!folder.exists()) folder.mkdir();
        
        // Luồng ký tự, đọc một file.
        // FileReader đọc ký tự theo mã hóa mặc định của Java trên máy chạy code này.
        Reader r = new FileReader(Values.TEST_FOLDER+"\\test_reader.txt");
        int i=-1;
        
        // Đọc lần lượt từng ký tự trong luồng, mỗi lần chỉ đọc 1 ký tự
        while((i=r.read()) != -1) {
            //System.out.println(i+": "+(char)i);
            System.out.print((char)i);
        }
        r.close();
        
        
        //đọc nhiều(10) ký tự 1 trong 1 lần:
        System.out.println("\n");
        Reader r2 = new FileReader(Values.TEST_FOLDER+"\\test_utf8.txt");
        // Method read(char[]):
        // Đọc nhiều ký tự một lần, và gán lên các phần tử cho mảng.
        // Trả về số ký tự đọc được.
        // Khi không còn phần tử trên luồng, trả về -1
        char [] temp = new char[10];
        int c=-1;
        while((c=r2.read(temp)) != -1) {
            String s = new String(temp, 0, c);
            System.out.print(s);
        }
        r2.close();
        
    }

}
