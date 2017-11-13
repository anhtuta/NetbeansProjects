/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piped_stream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 *
 * @author AnhTu
 */

//    Đặt ra một tình huống bạn có 2 luồng một luồng đầu vào và một luồng đầu ra ...
//    Chẳng hạn luồng đầu vào dữ liệu A đọc một file , lấy thông tin từ luồng này ghi vào luồng dữ liệu B đầu ra là một file khác .. 
//    Hai luồng A và B trong tình huống này là tách riêng nhau... Vì vậy trong ứng dụng bạn phải có 3 thao tác:
//    1. Tạo luồng dữ liệu đọc A
//    2. Tạo luồng ghi dữ liệu B
//    3. Đọc từ A ghi vào B ...
//    Hai thao tác đầu phải có, nhưng bạn muốn bỏ đi thao tác thứ 3 ...
//    nghĩa là có một cái gì đó liên hệ ngầm với nhau giữa 2 luồng (vào-ra) ,để sao cho những byte xuất hiện trên luồng đầu đọc A lập tức được ghi tự động vào B....
//    Đó được gọi là liên hệ đường ngầm giữa 2 luồng vào và ra ..

//    Pipe (hay còn gọi là ống dẫn) cung cấp cho bạn khả năng trong đổi giữa hai thread đang chạy trong cùng một JVM (hay cùng một máy). 
//    Khái niệm pipe trong Java khác với Unix/Linux, nơi mà hai thread đang chạy trong một không gian địa chỉ khác nhau có thể giao tiếp với nhau thông qua pipe. 
//    Trong java các thành phần muốn giao tiếp với nhau phải được chạy trên cùng một process và các thread khác nhau.
//    
//    Tạo pipe thông qua Java IO:
//    Việc tạo pipe sử dụng java IO được thực hiện thông qua PipeInputStream và PipeOutputStream class. 
//    Một PipeInputStream nên được kết nối tới một PipeOutputStream, dữ liệu được viết tới PipeOutputStream băng một thread có thể được đọc từ một PipeInputStream đã kết nối ở một thread khác.

//    Lưu ý Khi kết nối 2 pipe stream, một stream được truyền qua một thread và các stream khác được truyền tới thread khác. 
//    Phương thức read() và write() được gọi trong streams là blocking, nghĩa là bạn sử dụng một thread để vừa đọc và vừa viết 
//    thì kết quả là thread này sẽ bị deadlocking. Có nhiều cách khác có thể dùng để trao đổi thông tin giữa các thread trong cùng một JVM. 
//    Trong thực tế, thread thường trao đổi dữ liệu đối tượng hoàn chỉnh chứ không phải là byte dữ liệu thô, nhưng nếu bạn cần trao đổi dạng byte thô thì java IO pipe là hoàn toàn có thể được áp dụng. 


public class PipeDemo {
    public static void main(String[] args) { 
        try { 
            PipedOutputStream output = new PipedOutputStream(); 
            PipedInputStream input = new PipedInputStream(output); 
            Thread thread1 = new Thread(new Runnable() { 
                @Override 
                public void run() { 
                    try { 
                        output.write("Hello world, pipe!".getBytes());
                        output.write("ta anh tu".getBytes());
                    } catch (IOException e) { 
                        e.printStackTrace(); 
                    } 
                } 
            }); 
            Thread thread2 = new Thread(new Runnable() { 
                @Override 
                public void run() { 
                    try {
                        int data = input.read(); 
                        while(data != -1) { 
                            System.out.print((char) data); 
                            data = input.read(); 
                        } 
                    } catch (IOException e) { 
                        try { 
                            input.close(); 
                        } catch (IOException e1) { 
                            e1.printStackTrace(); 
                        } 
                    } 
                } 
            }); 
            thread1.start(); 
            thread2.start(); 
            
//            input.close();
//            output.close();
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
        
    } 
//- See more at: http://btit95.esy.es/pipe-trong-java-io-54.html#sthash.F0rED1en.dpuf
}
