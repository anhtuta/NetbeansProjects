/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

/**
 *
 * @author AnhTu
 */
import java.io.BufferedReader;
import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/*
FilterReader là một luồng đọc ký tự, mà nó đọc một cách có chọn lựa các ký tự yêu cầu, chẳng hạn bạn muốn đọc một tài liệu text có các thẻ HTML, và loại bỏ các ký tự trong các thẻ. Bạn cần viết một class con của FilterReader và sau đó sử dụng class con đó, bạn không thể sử dụng trực tiếp FilterReader vì nó là một class là class trìu tượng (abstract class).
Ví dụ minh họa, một luồng đọc ký tự lọc, đọc dữ liệu HTML nhưng bỏ qua các ký tự trong thẻ. 
Ví dụ đầu vào "<h1>Hello</h1>" ==> đọc ra "Hello".
*/
public class RemoveHTMLReader extends FilterReader {

    // Sử dụng để nhớ khi đang duyệt tới ký tự trong 1 thẻ.
    boolean intag = false;

    public RemoveHTMLReader(Reader in) {
        super(in);
    }

    /**
     * Chúng ta ghi đè method này. Nguyên tắc sẽ làm là đọc luồng và bỏ qua các
     * ký tự trong các thẻ HTML.
     */
    @Override
    public int read(char[] buf, int from, int len) throws IOException {
        // Số lượng ký tự đã đọc
        int charCount = 0;

        while (charCount == 0) {
            // Đọc tối đa 'len' ký tự trong luồng và gán vào 'buf' từ vị trí
            // 'from' trở đi
            charCount = super.read(buf, from, len);
            if (charCount == -1) {
                // Kết thúc luồng đọc.
                return -1;
            }
            // Vị trí phần tử trên 'buf' được gán giá trị.
            int last = from;
            // Duyệt trên các ký tự vừa đọc được
            // Và lọc bỏ các ký tự trong thẻ HTML
            for (int i = from; i < from + charCount; i++) {
                // Nếu không trong thẻ HTML
                if (!intag) {
                    if (buf[i] == '<') {
                        // Bắt đầu vào các ký tự thẻ
                        intag = true;
                    } else {
                        // Không trong ký tự thẻ
                        // Gán ký tự vào vị trí 'last'
                        // Đồng thời tăng giá trị 'last'
                        buf[last++] = buf[i];
                    }
                } else if (buf[i] == '>') {
                    // Thoát ra khỏi thẻ
                    intag = false;
                }
            }
            // Số ký không trong thẻ vừa đọc được.
            // Nếu số ký tự này khác 0 nó sẽ thoát ra khỏi vòng while.
            charCount = last - from;
        }
        // Trả về số ký tự vừa đọc được này.
        return charCount;
    }

    /**
     * Cũng cần phải ghi đè lại method này, method này gọi tới method trên, để
     * đảm bảo rằng nó đọc ký tự tiếp theo trên luồng, nhưng ký tự đó phải nằm
     * ngoài thẻ.
     */
    @Override
    public int read() throws IOException {
        char[] buf = new char[1];
        int result = read(buf, 0, 1);
        if (result == -1) {
            return -1;
        } else {
            return (int) buf[0];
        }
    }
    
    public static void main(String[] args) throws IOException {
        // Một đối tượng Reader từ StringReader để đọc một đoạn text
        Reader in = new StringReader("<h1>Hello \n <b>World</b><h1>");

        RemoveHTMLReader filterReader = new RemoveHTMLReader(in);
        BufferedReader br = new BufferedReader(filterReader);

        String s = null;
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
        br.close();
   }
}
