/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constants;

/**
 *
 * @author AnhTu
 */
public class Byte_Char_Example {
    public static void main(String[] args) {
        String str = "bach khoa ha noi";
        byte[] bytes = str.getBytes();
        
        for (int i = 0; i < bytes.length; i++) {
            System.out.print(bytes[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < bytes.length; i++) {
            System.out.print((char)bytes[i]+" ");
        }
    }
}
