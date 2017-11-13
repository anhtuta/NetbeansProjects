/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author AnhTu
 */
public class ArrayListAndVectorDemo {
    public static void main(String[] args) {
        System.out.println("vi du ve arraylist:");
        ArrayList al = new ArrayList();
        
        al.add("anhtu");
        al.add(new String("HUST"));
        al.add(new Integer(5));
        al.add(11);
        al.add(new Float(8.2));
        
        for (int i = 0; i < al.size(); i++) {
            System.out.println(al.get(i));
        }
        
        Object[] array= al.toArray();
        System.out.println("array's length is: "+array.length);
        System.out.println("al size is: "+al.size());
        
        
        System.out.println("vi du ve vector:");
        Vector vt = new Vector();
        vt.add("ta anh tu");
        vt.add("bkhn");
        vt.add(new Float(2.67));
        
        for (int i = 0; i < vt.size(); i++) {
            System.out.println(vt.get(i));
        }
        
        Object [] arr2 = vt.toArray();
        System.out.println("arr2 is: ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
        
    }
    
}
