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
//Class Writer là một class trìu tượng, tất cả các luồng ghi ký tự đều mở rộng từ class này.
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import vl.Values;

public class HelloWriter {

    public static void main(String[] args) throws IOException {
        File dir = new File(Values.TEST_FOLDER);
        // Tạo thư mục nếu nó chưa tồn tại.
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // Tạo một luồng ghi ký tự vào file
        // Mã hóa là mã hóa mặc định của Hệ thống Java.
        // Bạn có thể thay đổi mã hóa mặc định của hệ thống.
        Writer w = new FileWriter(Values.TEST_FOLDER + "/test_writer.txt");

        // Mảng các ký tự.
        char[] chars = new char[]{'H', 'e', 'l', 'l', 'o', ' ', 'w', 'r', 'i', 't', 'e', 'r'};

        // Ghi lần lượt các ký tự vào luồng:
        for (int i = 0; i < chars.length; i++) {
            w.write((int) chars[i]);
            //Hoặc: w.write(chars[i]); cũng đc vì lệnh write có hỗ trợ tham số kiểu char và int
        }
        // Đóng luồng, việc ghi hoàn thành.
        w.close();

        //ghi nhiều ký tự vào luồng cùng một lúc:
        Writer w2 = new FileWriter(Values.TEST_FOLDER + "/test_writer2.txt");
        w2.write(chars);    // Ghi các ký tự trong mảng vào luồng.

        // Thông thường Java sử dụng bộ đệm để lưu dữ liệu
        // khi đầy bộ đệm nó mới đẩy xuống file
        // Bạn có thể chủ động đẩy dữ liệu xuống file:
        w2.flush();
        // Ghi ký tự xuống dòng vào luồng:
        w2.write('\n');

        String s = "FileWriter";
        // Ghi một chuỗi vào luồng:
        w2.write(s);
        w2.close();

    }
}
