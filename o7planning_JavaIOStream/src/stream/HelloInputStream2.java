/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnhTu
 */
//đọc đồng  loạt nhiều byte, việc này làm tăng tốc việc xử lý.
public class HelloInputStream2 {
    public static void main(String[] args) {
        try {
            InputStream inputStream = new FileInputStream("data.txt");  // Tạo một luồng đầu vào bằng cách đọc một file
            
            // Mảng để mỗi lần đọc các byte từ luồng thì tạm thời để lên đó
            // Ta dùng mảng 10 byte:
            byte []temp = new byte[10];
            int i=-1;
            
            // Đọc các byte trong luồng và gán lên các phần tử của mảng, sau đó mới in cả mảng đó ra màn hình
            // Giá trị i là số đọc được của 1 lần. (i sẽ <= 10).
            // Khi không còn phần tử trong luồng i sẽ = -1
            while((i=inputStream.read(temp)) != -1) {
                String s = new String(temp, 0, i);
                System.out.print(s);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HelloInputStream2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HelloInputStream2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
