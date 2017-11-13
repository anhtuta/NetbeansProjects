/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stream_to_reader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 *
 * @author AnhTu
 */
//Làm thế nào để chuyển một luồng nhị phân thành luồng ký tự?
//Bạn có một luồng nhị phân. Và bạn muốn chuyển nó thành luồng ký tự?
//dùng: InputStreamReader
public class InputStreamReaderExample {
    public static void main(String[] args) throws IOException {
        // Tạo một luồng nhị phân, đọc file.
        InputStream in = new FileInputStream(vl.Values.TEST_FOLDER+"/test_utf8.txt");

        // Tạo một luồng ký tự từ luồng nhị phân.
        // Mã hóa đọc UTF-8
        Reader reader = new InputStreamReader(in, "UTF-8");

        int i = 0;
        // Đọc lần lượt từng ký tự, CHÚ Ý LÀ ĐỌC TỪNG KÝ TỰ CHỨ KO PHẢI TỪNG BYTE, DO ĐÓ c CÓ GIÁ TRỊ KIỂU INT CỦA KÝ TỰ ĐỌC ĐC
        while ((i = reader.read()) != -1) {
            // Ép kiểu về ký tự và in ra màn hình
            System.out.println((char) i + " " + i);
        }
        reader.close();
        
        
        
        ////Viết gọn lại thì như sau:
        InputStreamReader is2 = new InputStreamReader(new FileInputStream(vl.Values.TEST_FOLDER+"/test_utf8.txt"), "UTF-8");
        int c=-1;
        while((c=is2.read()) != -1) {
            System.out.println(c+": "+(char)c);
        }
        is2.close();
    }
}
