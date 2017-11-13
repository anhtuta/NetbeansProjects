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
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import constants.Values;

//việc ghi là lần lượt, sau này khi đọc ra bạn cũng phải nhớ thứ tự đã ghi trước đó để đọc cho đúng.
public class ObjectOutputStreamExample {

    public static void main(String[] args) throws IOException {
        File dir = new File(Values.WORKING_DIR+"\\Test_folder");
        // Tao thu muc
        dir.mkdirs();

        // Tao mot luong ghi vào file ...
        FileOutputStream fos = new FileOutputStream(dir+"/testObjectStream.txt");

        // Tạo đối tượng ObjectOutputStream bao lấy 'fos'.
        // Những gì ghi vào luồng này sẽ được đẩy xuống 'fos'.
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        // Ghi một String vào luồng.
        oos.writeUTF("This is student, pupil profiles");
        
        //ghi 1 String nữa: CHÚ Ý LÀ GHI VÀO LUỒNG:
        oos.writeUTF("I'm Ta anh tu");

        // Chú ý: Các đối tượng ghi được vào luồng phải
        // là kiểu Serializable.
        // Ghi một đối tượng Date vào luồng.
        oos.writeObject(new Date());

        Student student1 = new Student("Thanh", "Phan");
        Student student2 = new Student("Ngan", "Tran");
        Student st3 = new Student("Anhtu", "Ta");
        Pupil pupil1 = new Pupil("Nguyen Van Ba");
        
        
        oos.writeObject(student1);
        oos.writeObject(pupil1);
        oos.writeObject(student2);
        oos.writeObject(st3);

        oos.close();
        System.out.println("Write successful");
    }

}
