/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

/**
 *
 * @author AnhTu
 */
import java.io.FilterWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
 
public class RotateWriter extends FilterWriter {
 
    public RotateWriter(Writer out) {
        super(out);
    }
 
    // Ghi đè một hoặc nhiều method để thực hiện lọc
    @Override
    public void write(int outChar) throws IOException {
        super.write(Rot13.rotate(outChar));
    }
 
    @Override
    public void write(char[] cbuf, int offset, int length) throws IOException {
        char[] tempbuf = new char[length];
        for (int i = 0; i < length; i++) {
            tempbuf[i] = (char) Rot13.rotate(cbuf[offset + i]);
        }
        super.write(tempbuf, 0, length);
    }
 
    public static void main(String[] args) throws IOException  {
        String s="abcdef";
         
        Writer writer= new StringWriter();
         
        RotateWriter rw= new RotateWriter(writer);
        rw.write(s.toCharArray(),0,s.length());
         
        rw.close();
         
        String rotateString = writer.toString();
        System.out.println("rotateString="+ rotateString);
    }
}