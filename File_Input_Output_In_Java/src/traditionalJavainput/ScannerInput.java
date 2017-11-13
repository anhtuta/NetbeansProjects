/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traditionalJavainput;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author AnhTu
 */

//Scanner là một lớp mới có(từ java 5 hay 6, những phiên bản 3 thì chưa có).
//Scanner hơn hẳn những lớp trước là vì nó phân loại đc dữ liệu mà người dùng nhập vào cho nó: có thể đọc kiểu int hay float, double,..

public class ScannerInput {

    public static void main(String[] args) {
        Scanner scanIn = new Scanner(System.in); // Tạo một đối tượng Scanner
        String name = ""; // Biến Tên
        int age; // Biến Tuổi
        System.out.println("Nhap Ten va Tuoi cua ban:");
        name = scanIn.nextLine();
        age = scanIn.nextInt();
        System.out.println("Name is " + name + "!");
        System.out.println("Age is " + age + "!");
    }

}
