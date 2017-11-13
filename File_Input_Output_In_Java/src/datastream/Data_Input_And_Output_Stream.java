/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author AnhTu
 */
//Binary file accessing involves the following steps
//
//(1) Define a DataInputStream/DataOutputStream object for reading/writing
//(2) Use readChar(), readInt(), readFloat() ... to read from the binary file.
//(3) close the file
public class Data_Input_And_Output_Stream {

    public static void main(String[] args) throws IOException {
        final int N = 2;
        NewBorn nbList[] = new NewBorn[N];
        nbList[0] = new NewBorn(3.4F, 'F');
        nbList[1] = new NewBorn(4.2F, 'M');
        
        DataOutputStream out = new DataOutputStream(new FileOutputStream("myBinaryFile"));

        for (int i = 0; i < N; i++) {
            out.writeFloat(nbList[i].getWeight());
            out.writeChar(nbList[i].getGender());
        }

        out.close();
        DataInputStream in = new DataInputStream(new FileInputStream("myBinaryFile"));

        for (int i = 0; i < N; i++) {
            System.out.print(in.readFloat() + " " + in.readChar());
            System.out.println();
        }
    }

}
