/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file_in_java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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

//readLine()/println() can be used to read/write line by line in text file accessing.
//
//- readLine() is a method defined in the BufferedReader class.
//- println() is a method of the PrintWriter class.

public class FileReaderWriterTest_ReadOrWriteLine {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader in = new BufferedReader(new FileReader("source.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dest.txt")));

        String inputLine;

        inputLine = in.readLine();
        while(inputLine != null) {
            out.println(inputLine);  //hàm này hay, ko Notepad hiển thị được xuống dòng
            inputLine = in.readLine();
        }
        out.close();
    }
}
