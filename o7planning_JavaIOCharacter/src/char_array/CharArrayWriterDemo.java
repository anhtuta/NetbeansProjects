/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package char_array;

/**
 *
 * @author AnhTu
 */
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CharArrayWriterDemo {

    public static void main(String args[]) throws IOException {
        char c[] = {'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd', '!'};
        CharArrayWriter out = new CharArrayWriter();
        // Ghi dữ liệu vào luồng 'out'
        out.write(c);

        File dir = new File(vl.Values.TEST_FOLDER);
        if(!dir.exists()) dir.mkdirs();

        FileWriter f1 = new FileWriter(new File(dir+"/a.txt"));
        // Ghi dữ liệu từ CharArrayWriter vào FileWriter f1
        out.writeTo(f1);

        FileWriter f2 = new FileWriter(new File(dir+"/b.txt"));
        // Ghi dữ liệu từ CharArrayWriter vào FileWriter f2
        out.writeTo(f2);

        f1.close();
        f2.close();

        // Đóng luồng CharArrayWriter 'out'.
        out.close();

        FileWriter f3 = new FileWriter(new File(dir+"/c.txt"));
        // Với CharArrayWriter, sau khi đóng luồng
        // Không có ngoại lệ ném ra, nhưng writeTo(..) ko có tác dụng.
        out.writeTo(f3);

        System.out.println("Done");
    }
}
