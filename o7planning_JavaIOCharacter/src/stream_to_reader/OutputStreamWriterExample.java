/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stream_to_reader;

/**
 *
 * @author AnhTu
 */
//Ví dụ này ghi ra file chỉ định rõ mã hóa UTF-8
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class OutputStreamWriterExample {

    public static void main(String[] args) throws IOException {
        File dir = new File("C:/test");
        // Tạo thư mục C:/test nếu nó không tồn tại.
        dir.mkdirs();
        // Tạo một luồng nhị phân ghi ra file.
        OutputStream out = new FileOutputStream(vl.Values.TEST_FOLDER+"/test_write_utf8.txt");

        // Tạo một luồng ghi ký tự.
        // Mã hóa UTF-8
        Writer writer = new OutputStreamWriter(out, "UTF-8");

        String s = "JP日本-八洲";
        writer.write(s);
        writer.close();
    }

}
