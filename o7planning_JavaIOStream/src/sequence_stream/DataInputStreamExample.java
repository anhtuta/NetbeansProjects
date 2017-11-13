/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sequence_stream;

/**
 *
 * @author AnhTu
 */
import data_stream.*;
import constants.Values;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.SequenceInputStream;

//Vẫn phải chú ý rằng thứ tự đọc giống hệt thứ tự ghi
//Thông thường bạn đã quen thuộc với việc đọc một file nào đó và thu được một luồng đầu vào.
//Nhưng trong thực tế đôi khi bạn cần đọc từ nhiều file và lấy các dữ liệu đó ghép với nhau để ghi 
//thành 1 file khác chẳng hạn .Vậy là ý tưởng ghép nhiều luồng đầu vào với nhau để thành một luồng lớn hơn nối đuôi nhau . 
//Chúng ta đang nói đến class java.io.SequenceInputStream. Khái niệm này KHÔNG có tương ứng cho luồng đầu ra ...

//VD:
//    // Một luồng nhị phân đầu vào đọc từ một file File1.txt .
//    InputStream is1=new FileInputStream("File1.txt");
//    // Luồng mới đọc từ file File2.txt  
//    InputStream is2=new FileInputStream("File2.txt");
//    // Nối luồng is2 nối tiếp với luồng is1 thành một luồng nhị phân mới .
//    SequenceInputStream sis=new SequenceInputStream(is1,is2);
//    // Thao tác trên luồng đầu vào nhị phân SequenceInputStream sis như bình thường ...

public class DataInputStreamExample {

    public static void main(String[] args) throws IOException {

        DataInputStream dis1 = new DataInputStream(new FileInputStream(Values.WORKING_DIR+"/Test_folder/file1.txt"));
        DataInputStream dis2 = new DataInputStream(new FileInputStream(Values.WORKING_DIR+"/Test_folder/file2.txt"));
        
        SequenceInputStream sis = new SequenceInputStream(dis1, dis2);
        
        int c=-1;
        while((c = sis.read()) != -1) {
            char ch = (char) c;
            System.out.print(ch);
            //System.out.print(c+" ");
        }
        
        sis.close();
        dis1.close();
        dis2.close();
    }
}
