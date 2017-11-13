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
/*
Class InputStream là một class trìu tượng vì vậy bạn không thể khởi tạo đối tượng InputStream thông qua chính class InputStream. 
Tuy nhiên class này rẽ ra nhiều nhánh thông qua các class con thừa kế nó.Tùy vào các tình huống bạn có thể tạo 
đối tượng InputStream từ các cấu tử của các class con.
Class OutputStream là một class trìu tượng vì vậy bạn không thể khởi tạo đối tượng OutputStream thông qua chính class OutputStream.
Tuy nhiên class này rẽ ra nhiều nhánh thông qua các class con thừa kế nó và quan trọng .Tùy vào các tình 
huống bạn có thể tạo đối tượng InputStream từ cấu tử của các class con.

// java.io.InputStream là một class trìu tượng (abstract class)
// Không thể khởi tạo trực tiếp đối tượng InputStream thông qua class InputStream
// Nên khởi tạo đối tượng InputStream thông qua các class con của nó ..
VD:
InputStream fileStream =new FileInputStream("C:/test.txt");
// Luồng đầu vào từ bàn phím..
InputStream is = System.in;

// java.io.OutputStream là một class trìu tượng (abstract class)
// Không thể khởi tạo trực tiếp đối tượng OutputStream thông qua class OutputStream
// Nên khởi tạo đối tượng OutputStream thông qua các class con của nó ..
 
// Luồng ghi dữ liệu vào file
OutputStream os=new FileOutputStream("D:/outData.txt");
// Luồng ghi ra màn hình Console.
OutputStream w=System.out;
*/


import java.io.FileInputStream;
import java.io.InputStream;

// đọc từng byte
public class HelloInputStream {

    public static void main(String[] args) {
        try {

            // Tạo một đối tượng InputStream theo class con của nó.
            // Đây là luồng đọc một file.
            InputStream is = new FileInputStream("data.txt");

            int i = -1;

            // Đọc lần lượt các byte trong luồng.
            // Mỗi lần đọc ra 8bit, chuyển nó thành số int và gán vào biến i.
            // Khi đọc ra giá trị -1 nghĩa là kết thúc luồng.
            // Do đầu vào của luồng là file trên nên điều này cũng có nghĩa là ta đọc lần lượt từng byte từ file đó
            while ((i = is.read()) != -1) {
                System.out.println(i + "  " + (char) i);
            }
            System.out.println("============");
            InputStream is2 = new FileInputStream("data.txt");;

            i = -1;
            while ((i = is2.read()) != -1) {
                System.out.print((char) i);
            }
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
