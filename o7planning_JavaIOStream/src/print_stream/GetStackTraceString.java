/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package print_stream;

/**
 *
 * @author AnhTu
 */
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


// PrintStream là class con trực tiếp của FilterOutputStream .
// Nó có thể bao bọc một luồng đầu ra nhị phân (OutputStream) , ..
// Constructor :
 
//   // Bao bọc một luồng nhị phân
//   public PrintStream(OutputStream out)
// 
//   public PrintStream(OutputStream out,boolean autoFlush)
//   // Ghi thông tin vào file ..
//   public PrintStream(String fileName)
//   // ...(Xem javadoc) .
// 
//// Một số method
//   public void println(String s)
//   public void print(char ch)
//   // Ghi một đối tượng vào luồng .
//   public void print(Object obj)
//   // Ghi một số tự nhiên 64 bit vào luồng .  
//   public void print(long n)
//   public PrintStream append(java.lang.CharSequence csq) .
//   // ... (chi tiết xem javadoc) .

public class GetStackTraceString {

    private static String getStackTraceString(Exception e) {
        // Tạo một đối tượng ByteArrayOutputStream.
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        // Những gì ghi vào 'printStream' sẽ được ghi sang 'baos'.
        PrintStream printStream = new PrintStream(baos);

        // Ghi thông tin lỗi sang 'printStream'
        e.printStackTrace(printStream);
        printStream.close();
        
        byte[] bytes = baos.toByteArray();
        String s = new String(bytes);
        return s;
    }

    public static void main(String[] args) {

        try {
            // Làm một điều gì đó trong khối try ...
            // Lỗi chia cho 0
            int i = 10 / 0;
        } // Có điều gì đó sai xót trong khi chạy khối try khối catch được chạy
        catch (Exception e) {
            // In ra lý do sai xót trong khi chạy
            System.out.println("Error on try..." + e.getMessage());
            // In ra thông tin quá trình chạy lỗi xuất hiện ở các vị trí nào ra
            // màn hình Console
            // Lấy được đoạn text "stack trace":
            String s = getStackTraceString(e);

            System.out.println("Stack Trace String: " + s);
        }
    }
}
