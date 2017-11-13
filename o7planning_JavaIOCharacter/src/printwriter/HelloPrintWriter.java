/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printwriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;

/**
 *
 * @author AnhTu
 */
/*
// Cấu tử :
// PrintWriter là class con trực tiếp của Writer .
// Nó có thể bao bọc một luồng đầu ra ký tự (Writer) hoặc luồng đầu ra nhị phân (OutputStream) , ..
public PrintWriter(Writer out) //Bao bọc một luồng ký tự
public PrintWriter(Writer out,boolean autoFlush)
public PrintWriter(OutputStream out) //Bao bọc một luồng nhị phân
public PrintWriter(OutputStream out,boolean autoFlush)
public PrintWriter(String fileName)
...
 
// Một số method
public void println(String s)
public void print(char ch)
 */
//CHÚ Ý: KO CÓ CLASS PrintReader
public class HelloPrintWriter {

    public static void main(String[] args) {
        try {
            // Làm một việc gì đó
            // Ngoại lệ khi chia cho 0, khối catch sẽ được chạy.
            int i = 10 / 0;
        } catch (Exception e) {
            System.out.println("EXCEPTION ....");
            try {
                File dir = new File(vl.Values.TEST_FOLDER);
                if(!dir.exists()) dir.mkdirs();
                
                // Tạo luồng ghi vào file.
                Writer w = new FileWriter(dir+"/stackTrace.txt");
                // Tạo đối tượng PrintWriter bao lấy Writer w
                // Như vậy dữ liệu ghi vào PrintWriter sẽ ghi vào FileWriter w.
                PrintWriter pw = new PrintWriter(w);
                // Ghi thông tin lỗi vào luồng 'pw'
                e.printStackTrace(pw);      //KẾT QUẢ KO GHI ĐC!
                
                System.out.println("Finish !");
                
                PrintWriter pw2 = new PrintWriter(new BufferedWriter(new FileWriter(dir+"/stackTrace.txt")));
                pw2.print(e.getMessage());
            } catch (Exception e1) {
                System.out.println("Error:" + e);
            }
        }
    }
}
