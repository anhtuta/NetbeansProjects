/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filedirectory;

/**
 *
 * @author AnhTu
 */
//Lớp java.io.File cung cấp cho bạn vài phương thức để liệt kê các thư mục và 
//các tập tin là "con trực tiếp" của thư mục hiện tại
//Ví dụ dưới đây sử dụng đệ quy để liệt kê toàn bộ các thư mục hậu duệ (con,cháu,..) 
//và các tập tin hậu duệ của một thư mục.

import java.io.File;

public class RecursiveFileExample {

    private void fetchChild(File file) {
        System.out.println(file.getAbsolutePath());
        
        if (file.isDirectory()) {
            File[] children = file.listFiles();
            for (File child : children) {
                // Đệ quy
                this.fetchChild(child);
            }
        }
    }

    public static void main(String[] args) {

        RecursiveFileExample example = new RecursiveFileExample();

        File dir = new File(System.getProperty("user.dir"));

        example.fetchChild(dir);

    }

}
