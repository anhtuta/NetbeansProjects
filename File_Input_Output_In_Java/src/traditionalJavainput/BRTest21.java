/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traditionalJavainput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnhTu
 */
//chú ý: hàm read() thì đọc 1 ký tự, trả về kiểu int là mã của ký tự đó,
//còn hàm readLine() đọc 1 dòng, trả về kiểu String
//nếu đã dùng read() rồi thì phải tạo 1 đối tượng BufferedReader mới thì mới dùng đc hàm read hoặc readLine lần nữa
public class BRTest21 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Nhap so nguyen a:");

        int a = br.read();
        System.out.println("a= " + a);
        System.out.println("a+1 = " + (a + 1));

        System.out.println("Nhận xét: br.read() chỉ đọc 1 ký tự, và trả về kiểu nguyên là mã ASCII của ký tự đó.\n"
                + "Nếu ta nhập số 1000 thì nó chỉ đọc số 1 và = 49 vì 49 là mã ASCII của số 1");

        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Nhập số nguyên b:");
        int b = Integer.valueOf(br2.readLine());
        System.out.println("b = " + b);
        System.out.println("b+1=" + (b + 1));

        System.out.println("Nhập số nguyên c:");
        int c = Integer.valueOf(br2.readLine());
        System.out.println("c = " + c);
        System.out.println("c+1=" + (c + 1));
    }
}
