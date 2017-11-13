/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_structures;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author AnhTu
 */
public class VectorDemo {

    public static void main(String args[]) {
        // initial size is 3, increment is 2
        Vector v = new Vector(3, 2); //ko quan trọng lắm
        System.out.println("Initial size: " + v.size());
        System.out.println("Initial capacity: " + v.capacity());
        v.addElement(new Integer(1));
        v.addElement(new Integer(2));
        v.addElement(new Integer(3));
        v.addElement(new Integer(4));
        System.out.println("Capacity after four additions: " + v.capacity());
        v.addElement(new Double(5.45));
        System.out.println("Current capacity: " + v.capacity());
        v.addElement(new Double(6.08));
        v.addElement(new Integer(7));
        System.out.println("Current capacity: " + v.capacity());
        v.addElement(new Float(9.4));
        v.addElement(new Integer(10));
        System.out.println("Current capacity: " + v.capacity());
        v.addElement(new Integer(11));
        v.addElement(new Integer(12));
        
        System.out.println("First element: " + (Integer) v.firstElement());
        System.out.println("Last element: " + (Integer) v.lastElement());
        
        if (v.contains(new Integer(3))) {
            System.out.println("Vector contains 3");
        }
        
        // enumerate the elements in the vector. giống bài trước
        Enumeration vEnum = v.elements();
        System.out.println("\nElements in vector: sử dụng kiểu liệt kê để duyệt");
        while (vEnum.hasMoreElements()) {
            System.out.print(vEnum.nextElement() + " ");
        }
        System.out.println();
        
        System.out.println("\nSử dụng iterator để duyệt");
        Iterator iter=v.iterator();
        while(iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        
    }
}
