/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buffered;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 *
 * @author AnhTu
 */
public class BufferedWriterrExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(vl.Values.TEST_FOLDER+"/test_buffered_writer.txt")));
        //Hoặc đơn giản hơn:
        //BufferedWriter bw = new BufferedWriter(new FileWriter(vl.Values.TEST_FOLDER+"/test_buffered_writer.txt"));
        bw.write("One Piece quá tuyệt vời");
        bw.newLine();
        bw.write("Hôm nay mát quá!");
        bw.close();
    }
}
