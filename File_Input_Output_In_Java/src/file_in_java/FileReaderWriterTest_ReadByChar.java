/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file_in_java;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnhTu
 */
//Text file accessing involves the following steps:
//(1) Define a FileReader/FileWriter object for reading/writing
//Example
//FileReader in = new FileReader ("source.txt");
//FileWriter out = new FileWriter ("dest.txt");

//(2) Use read()/write() method to read/write a character.
//Example
//char c = (char) in.read();
//out.write(c);

//(3) Close the file when writing is completed.: out.close();
//Note:
//read() reads char by char and returns the unicode of each character (which is an integer).
//Type cast is needed to convert the returned value to a char.
//read() returns –1 when it reaches the end of the file

public class FileReaderWriterTest_ReadByChar {
    public static void main(String[] args) {
        int content;
        try {
            FileReader fileInput = new FileReader("source.txt");
            FileWriter fileOutput = new FileWriter("dest.txt");
            content = fileInput.read();
            while(content != -1) {
                fileOutput.write((char) content); //nếu ko ép kiểu thành kiểu char thì nó sẽ in ra kiểu int, tức là mã ASCII của kí tự
                content = fileInput.read();
            }
            
            fileOutput.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileReaderWriterTest_ReadByChar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileReaderWriterTest_ReadByChar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
}
