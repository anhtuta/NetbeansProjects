/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pushback;

/**
 *
 * @author AnhTu
 */
//Lớp PushbackReader cho phép một hoặc nhiều ký tự để được trả lại cho dòng đầu vào. 
//Điều này cho phép bạn nhìn về phía trước trong các luồng đầu vào.
//Dưới đây là hai cấu trúc tử của nó:
//public PushbackReader(Reader inputStream)
//public PushbackReader(Reader inputStream, int bufSize)
// Trả lại ký tự về luồng, đồng nghĩa với việc lùi con trỏ lại một ký tự.
//public void unread(int c) throws IOException
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.PushbackReader;

class PushbackReaderDemo {

    public static void main(String args[]) throws IOException {
        String s = "if (a == 4) a = 0;\\n";
        char buf[] = new char[s.length()];
        s.getChars(0, s.length(), buf, 0);
        CharArrayReader in = new CharArrayReader(buf);
        PushbackReader f = new PushbackReader(in);
        int c;
        while ((c = f.read()) != -1) {
            switch (c) {
                // Tìm thấy ký tự '='
                case '=':
                    // Đọc tiếp một ký tự nữa (Sau khi đã tìm thấy ký tự '=' trước đó):
                    if ((c = f.read()) == '=') {
                        System.out.print(".eq.");
                    }
                    else { // Nếu ký tự tiếp theo khác '='
                        System.out.print("<-");
                        // Trả lại ký tự này về luồng.
                        // Nghĩa là lùi con trỏ trở lại 1 đơn vị
                        f.unread(c);
                    }
                    break;
                default:
                    System.out.print((char) c);
                    break;
            }
        }
    }

}
