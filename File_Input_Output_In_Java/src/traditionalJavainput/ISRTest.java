/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traditionalJavainput;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author AnhTu
 */

// An InputStreamReader reads one character at a time:
//InputStreamReader charReader = new InputStreamReader(System.in);

// To read a string of characters at once we
//need a different type of object again: an
//instance of the BufferedReader class
// We can create a BufferedReader object from
//an InputStreamReader object:
//BufferedReader stringReader = new BufferedReader(charReader);


public class ISRTest { //InputStreamReader Test

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        System.out.println("Enter a line of text:");
        String input = "";
        char temp = (char) isr.read(); //temp thuộc kiểu char, nếu nó là số nguyên thì nó chứa mã ASCII của ký tự tương ứng
        while (temp != '\n') {
            input += temp;  //ví dụ nếu temp = 67 thì input = C
            temp = (char) isr.read();
        }
        System.out.println("You entered: \"" + input + "\"");
        
        
        
        ///1 số ví dụ khác ko liên quan tới InputStreamReader:
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a line of text:");
        String input2;
        input2 = sc.nextLine();
        System.out.println("You entered: \"" + input2 + "\"");
        if(input.endsWith(input2)) System.out.println("You entered two times the same String");
        

        //so sanh cac kq sau:
        int c=67;
        String str6 = "";
        str6 = str6 + c;
        System.out.println("str6 is: "+str6);
        
        char a=67;
        String str4 = "";
        str4 = str4 + a;
        System.out.println("str4 is: "+str4);
        
        char b=67;
        String str5 = null;
        str5 = str5 + b;
        System.out.println("str5 is: "+str5);
        
    }
}
