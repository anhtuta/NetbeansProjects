/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection_algorithms;

import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author AnhTu
 */
public class AlgorithmsDemo {

    public static void main(String[] args) {
        // Create and initialize linked list
        LinkedList l1 = new LinkedList();
        l1.add(-8);
        l1.add(20);
        l1.add(-20);
        l1.add(8);
        l1.add(11);
        l1.add(21);
        l1.add(15);
        l1.add(2);
        l1.add(3);
        
        System.out.println("List at the beginning:");
        System.out.println(l1);
        
        // Sort list by using the comparator
        Collections.sort(l1, Collections.reverseOrder());
        System.out.print("\nList sorted in reverse: "+l1);
        
        Collections.sort(l1);
        System.out.print("\nList sorted: "+l1);
        
        Collections.shuffle(l1);
        System.out.print("\nList shuffled: "+l1);
        
        System.out.println();
        System.out.println("Minimum: " + Collections.min(l1));
        System.out.println("Maximum: " + Collections.max(l1));
        
        List l2 = new LinkedList();
        for (int i = 0; i < l1.size(); i++) {
            l2.add(i); //làm ntn để size của l2 = size của l1, sau đó mới copy đc
        }
        
        System.out.println(l2);
        Collections.copy(l2, l1);
        System.out.println(l2);
        
        Enumeration en = Collections.enumeration(l2);
    }
}
