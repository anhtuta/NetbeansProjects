/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traditionalJavainput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnhTu
 */
public class StringTokenizerDemo {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a line text:");
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(StringTokenizerDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        StringTokenizer st = new StringTokenizer(str);
        System.out.println("the tokens is: "+st.countTokens());
        st.nextToken(); //bị giảm 1 token
        System.out.println("the tokens is: "+st.countTokens()); 
        while(st.hasMoreElements()) {
            String temp = st.nextToken();
            System.out.println(temp);
        }
        System.out.println(str);
        System.out.println("the tokens is: "+st.countTokens()); //ewa ew ewar rea9 r392932 rar03 ar
    }
}
