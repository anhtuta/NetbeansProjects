/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example3_5;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 *
 * @author AnhTu
 */
public class FixedLengthStringIO {//định nghĩa lớp đọc/ghi xâu theo kích thước cố định
    public static String readFixedLengthString(int size, DataInput in) throws IOException {
        char[]c=new char[size];
        for (int i = 0; i < size; i++) {
            c[i]=in.readChar();
        }
        
        return new String(c);
    }
    
    public static void writeFixedLengthString(String s, int size, DataOutput out) throws IOException {
        char[]cBuffer=new char[size];
        s.getChars(0, s.length(), cBuffer, 0);
        //các tham số của hàm trên:
//            srcBegin - index of the first character in the string to copy.
//            srcEnd - index after the last character in the string to copy.
//            dst - the destination array.
//            dstBegin - the start offset in the destination array.
        String newStr=new String(cBuffer);
        out.writeChars(newStr);
    }
}
