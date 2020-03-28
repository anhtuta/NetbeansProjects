/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package from_youtube;

/**
 *
 * @author AnhTu
 */

///Cái này giống template trong C++

public class GenericMethods {
    public static void main(String[] args) {
        Integer [] iray = {1,2,3,4};
        Character [] cray = {'a', 'n', 'h', 't', 'u'};
        
        printMe(iray);
        printMe(cray);
    }

    private static <T> void printMe(T[] iray) {
        for(T x: iray) System.out.println(x);
        System.out.println();
    }
}
