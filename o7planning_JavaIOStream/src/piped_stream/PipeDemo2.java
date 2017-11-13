/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piped_stream;

/**
 *
 * @author AnhTu
 */
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

//    PipedInputStream class có khả năng đọc nội dụng của một pipe như là một luồng bytes. 
//    Cũng vậy, PipedOutputStream cung cấp khả năng viết tới một pipe như một luồng bytes.  
//    Sau đây là một ví dụ cơ bản để bạn hình dung được cách sử dụng nó. 

public class PipeDemo2 {

    public static void main(String[] args) {
        // create a new Piped input and Output Stream 
        PipedOutputStream out = new PipedOutputStream();
        PipedInputStream in = new PipedInputStream();
        try {
            // connect input and output
            in.connect(out);
            // write something
            out.write(100);
            out.write(110);
            out.write(new byte[] {'A', 'n', 'h','T','u'});
            // read what we wrote
            int c=-1;
            while((c=in.read()) != -1) {
                System.out.print((char)c+" ");
            }
            System.out.println("closed  ");
            try {
                //out.flush();
                out.close();
                in.close();
                System.out.println("closed");
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            
        }
        
    }
}
//- See more at: http://btit95.esy.es/pipe-trong-java-io-54.html#sthash.8PuwD7Rv.dpuf
