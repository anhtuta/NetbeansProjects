/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author AnhTu
 */
public class IteratorDemo {
    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        al.add("anhtu");
        al.add(new String("HUST"));
        al.add(new Integer(5));
        al.add(11);
        al.add(new Float(8.2));
        
        Iterator it = al.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        
    }
}
