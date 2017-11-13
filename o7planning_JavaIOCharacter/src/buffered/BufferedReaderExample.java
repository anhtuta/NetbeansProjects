/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buffered;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author AnhTu
 */
/*
// Nếu bạn muốn đọc file, đọc lần lượt từng dòng. BufferedReader là sự lựa chọn tốt.
// Là một class con trực tiếp của Reader .
// Constructor thông dụng:
public BufferedReader(Reader in);
 
// Vậy là khởi tạo đối tượng BufferedBuffer bằng cách bao quanh một đối tượng Reader.
// Method tiện lợi có được từ BufferedReader :
// Đọc một dòng dữ liệu
public String readLine();
 
// Đoạn code ví dụ :
// Tạo một luồng đầu vào bằng cách đọc file có sẵn:
Reader r=new FileReader("C:/test.txt");
BufferedReader br=new BufferedReader(r);
 
// Đoạn code ví dụ:
InputStream in = new FileInputStream("C:/test.txt");
Reader r = new InputStreamReader(in, "UTF-8");
BufferReader br = new BufferedReader(r);
*/
public class BufferedReaderExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(vl.Values.TEST_FOLDER+"/test_multi_lines.txt")));
        //Hoac chi tiet hon:
//        InputStream in = new FileInputStream("test_multi_lines.txt");
//        Reader reader = new InputStreamReader(in, "UTF-8");
//        BufferedReader br = new BufferedReader(reader);
        String s;
        // Đọc từng dòng dữ liệu
        // Khi đọc 1 dòng trả về null nghĩa là kết thúc luồng:
        while((s=br.readLine()) != null) {
            System.out.println(s);
        }
        br.close();
        
    }
}
