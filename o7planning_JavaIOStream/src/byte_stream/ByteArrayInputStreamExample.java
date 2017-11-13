/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byte_stream;

/**
 *
 * @author AnhTu
 */
import java.io.ByteArrayInputStream;
import java.io.IOException;

//ByteArrayInputStream bao bọc một mảng các byte (byte[] buf) và thông qua ByteArrayInputStream truy cập phần tử mảng .. 
//ByteArrayOutputStream là một luồng các byte, bên trong đối tượng này chứa một mảng các byte (byte[] buf) có khả 
//năng tự tăng kích cỡ khi số byte của luồng tăng lên.Mỗi khi luồng được ghi vào các byte thì chính là gán tiếp byte đó vào các vị trí mảng chưa được gán ..
// Khi mảng đầy phần tử thì chương trình tạo mảng mới có độ dài lớn hơn và copy các phần tử của mảng cũ vào ...
//(Đó là cách tự lớn lên của mảng ký tự như đã nói trên)

//Vài method của ByteArrayOutputStream: 
////// Mảng các byte chứa các byte của luồng ..
//  - byte[] toByteArray();
// 
//// Chuyển về một String mô tả dẫy các byte trong luồng.
//  - String toString() ;
// 
//// Trả về số vị trí được gán của mảng byte[] buf .
//  - int size();
public class ByteArrayInputStreamExample {

    public static void main(String args[]) throws IOException {

        // Một mảng byte.
        byte[] bytes = new byte[]{'H', 'e', 'l', 'l', 'o', ' ', 'I', 'O'};

        // Sử dụng ByteArrayInputStream để đọc dữ liệu mảng trên.
        ByteArrayInputStream bInput = new ByteArrayInputStream(bytes);
        
        System.out.println("Converting characters to Upper case ");
        int c = 0;

        // Đọc lần lượt các byte trong luồng.
        // Con trỏ sẽ di chuyển từ đầu mảng tới cuối mảng.
        // Mỗi lần đọc một byte con trỏ sẽ tiến 1 bước về cuối.
        while((c=bInput.read()) != -1) {
            char ch = Character.toUpperCase((char)c);
            System.out.print(ch);
        }
        
        // Kiểm tra xem stream này có hỗ trợ đánh dấu (mark) không.
        boolean markSupport = bInput.markSupported();

        System.out.println("\nMark Support? " + markSupport);

        // Đưa con trỏ về vị trí mặc định
        // Trong ví dụ này nó sẽ đưa về vị trí 0.
        bInput.reset();

        char ch = (char) bInput.read();
        System.out.println("byte đầu tiên: "+ch);

        // Đọc byte kế tiếp
        ch = (char) bInput.read();
        System.out.println("byte tiếp theo: "+ch);

        System.out.println("Skip 4");
        // Nhẩy qua 4 vị trí
        bInput.skip(4);
        ch = (char) bInput.read();
        System.out.println(ch);

    }
}
