/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traditionalJavainput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author AnhTu
 */
public class BRTest {
    public static void main(String[] args) throws IOException {
        //example to read a string:
        InputStreamReader charReader = new InputStreamReader(System.in);
        BufferedReader stringReader = new BufferedReader(charReader);
        //cũng có thể gộp 2 lệnh trên làm 1:
        //BufferedReader stringReader = new BufferedReader(new InputStreamReader(System.in));
        String line1 = "", line2 = "";
        System.out.println("Enter two lines of text:");
        line1 = stringReader.readLine();
        line2 = stringReader.readLine();
        
        System.out.println("line1 is: "+line1);
        System.out.println("line2 is: "+line2);
        
        
        //example to read an integer:
        boolean enterNum = true;
        int a = 0,b = 0;
        do {
            System.out.println("Enter two integers:");
            line1 = stringReader.readLine();
            line2 = stringReader.readLine();
            enterNum = true;
            
            try {
                a = Integer.valueOf(line1);
                b = Integer.parseInt(line2); //what's the difference between a and b?
                System.out.println("a and b are: [" + a + ", " + b + "]");
            } catch (java.lang.NumberFormatException e) {
                enterNum = false;
                System.out.println("wrong format! plz enter two numbers!");
            }
        } while(enterNum==false);
        
    }
}
