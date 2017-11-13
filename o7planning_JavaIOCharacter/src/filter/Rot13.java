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
public class Rot13 {
     
    /**
     * <pre>
     *   a ==> n
     *   b ==> o
     *   c ==> p
     *   d ==> q
     *   e ==> r
     *   ...
     *   y ==> l
     *   z ==> m
     * </pre>
     * @param inChar
     * @return 
     */
    public static int rotate(int inChar) {
        int outChar;
         
        if (inChar >= (int) 'a' && inChar <= (int) 'z') {
            outChar = (((inChar - 'a') + 13) % 26) + 'a';
        } else if (inChar >= (int) 'A' && inChar <= (int) 'Z') {
            outChar = (((inChar - 'A') + 13) % 26) + 'A';
        } else {
            outChar = inChar;
        }
        
        return outChar;
    }
     
    // Test
    public static void main(String[] args)  {
        for(char ch='a'; ch<='z';ch++ ) {
            char m= (char)rotate(ch);
            System.out.println("ch="+ch+" ==> "+ m);    
        }       
         
    }
}