/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printwriter;

/**
 *
 * @author AnhTu
 */
import java.io.PrintWriter;
import java.io.StringWriter;
 
public class StackTraceToString {
 
   public static void main(String[] args) {
       try {
           // Làm một việc gì đó
           // Ngoại lệ khi chia cho 0, khối catch sẽ được chạy.
           int i = 1000 / 0;
       } catch (Exception e) {
           System.out.println("EXCEPTION ....");
           try {
               StringWriter sw = new StringWriter();
               // Tạo đối tượng PrintWriter bao lấy StringWriter sw
               // Như vậy dữ liệu ghi vào PrintWriter sẽ ghi vào StringWriter
               // sw.
               PrintWriter pw = new PrintWriter(sw);
               // Ghi thông tin lỗi vào pw
               e.printStackTrace(pw);
               StringBuffer sb = sw.getBuffer();
               String s = sb.toString();
               System.out.println("Exception String:");
               System.out.println(s);
           } catch (Exception e1) {
               System.out.println("Error:" + e);
           }
       }
 
   }
 
}