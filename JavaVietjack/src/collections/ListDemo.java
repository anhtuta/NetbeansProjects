/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author AnhTu
 */
//xem thêm project quản lý sv ktx
public class ListDemo {

    public static void main(String[] args) {
        List a1 = new ArrayList();
        a1.add("Zara");
        a1.add("Mahnaz");
        a1.add("Ayan");
        System.out.println(" ArrayList Elements");
        System.out.print("\t" + a1);
        
        List l1 = new LinkedList();
        l1.add("Zara");
        l1.add("Mahnaz");
        l1.add("Ayan");
        System.out.println();
        System.out.println(" LinkedList Elements");
        System.out.print("\t" + l1);
        
        List l2=new LinkedList(a1);
        l2.add("Anhu");
        l2.add("att");
        System.out.println("\n"+l2);
        
        System.out.println("\nAnother example about linkedlist:");
        // create a linked list
        LinkedList ll = new LinkedList();
// add elements to the linked list
        ll.add("F");
        ll.add("B");
        ll.add("D");
        ll.add("E");
        ll.add("C");
        ll.addLast("Z");
        ll.addFirst("A");
        ll.add(1, "A2");
        System.out.println("Original contents of ll: " + ll);
// remove elements from the linked list
        ll.remove("F");
        ll.remove(2);
        System.out.println("Contents of ll after deletion: " + ll);
// remove first and last elements
        ll.removeFirst();
        ll.removeLast();
        System.out.println("ll after deleting first and last: " + ll);
// get and set a value
        Object val = ll.get(2);
        ll.set(2, (String) val + " Changed");
        System.out.println("ll after change: " + ll);
        
        System.out.println("\nAnother example about arraylist:");
        // create an array list
        ArrayList al = new ArrayList();
        System.out.println("Initial size of al: " + al.size());
// add elements to the array list
        al.add("C");
        al.add("A");
        al.add("E");
        al.add("B");
        al.add("D");
        al.add("F");
        al.add(1, "A2");
        System.out.println("Size of al after additions: " + al.size());
// display the array list
        System.out.println("Contents of al: " + al);
// Remove elements from the array list
        al.remove("F");
        al.remove(2);
        System.out.println("Size of al after deletions: " + al.size());
        System.out.println("Contents of al: " + al);
        al.removeAll(ll); //những j có trong ll thì xóa tất cả trong al
        System.out.println("al.removeAll(ll): "+al);
        al.removeAll(al);
        System.out.println("al.removeAll(al): "+al);
        
        System.out.println(a1);
        Iterator it=a1.iterator();
        while(it.hasNext()) {
            String s=(String) it.next();
            if(s.equals("Mahnaz")) a1.remove(s);
        }
        System.out.println(a1);
    }
}
