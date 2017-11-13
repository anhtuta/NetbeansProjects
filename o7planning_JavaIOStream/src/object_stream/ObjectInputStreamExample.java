/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object_stream;

/**
 *
 * @author AnhTu
 */
//ObjectInputStream, ObjectOutputStream cho phép bạn đọc hoặc ghi một Object vào luồng. 
//Các Object này phải là kiểu Serializable (Nghĩa là có thể sắp hàng).

import constants.Values;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Date;

//CHÚ Ý: GHI THEO THỨ TỰ NTN THÌ ĐỌC THEO THỨ TỰ ĐÓ, DO ĐÓ PHẢI CHẠY FILE ObjectOutputStreamExample.java TRƯỚC
public class ObjectInputStreamExample {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Tạo một luồng đọc file..
//        FileInputStream fis = new FileInputStream(Values.WORKING_DIR+"/testObjectStream.txt");
//        // Tạo đối tượng ObjectInputStream bao lấy 'fis'.
//        ObjectInputStream ois = new ObjectInputStream(fis);

        //Hoặc viết ngắn gọn hơn:
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Values.WORKING_DIR+"/Test_folder/testObjectStream.txt"));
        
        
        String s = ois.readUTF();
        System.out.println(s);
        
        String s2 = ois.readUTF();
        System.out.println(s2);

        // Đọc ra đối tượng Date.
        Date date = (Date) ois.readObject();
        System.out.println("Date = " + date);

        Student student1 = (Student) ois.readObject();
        System.out.println("Student: " + student1.getFirstName());

        Pupil pupil = (Pupil) ois.readObject();
        System.out.println("Pupil: " + pupil.getFullName());

        Student student2 = (Student) ois.readObject();
        System.out.println("Student: " + student2.getFirstName());

        Student st3 = (Student) ois.readObject();
        System.out.println("Student: "+st3.getFirstName());
        ois.close();
    }
}
