/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 *
 * @author AnhTu
 */
public class IteratorDemo {

    public static void main(String args[]) {
// Create an array list
        ArrayList al = new ArrayList();
// add elements to the array list
        al.add("C");
        al.add("A");
        al.add("E");
        al.add("B");
        al.add("D");
        al.add("F");
// Use iterator to display contents of al
        System.out.print("Original contents of al: ");
        Iterator itr = al.iterator();
        while (itr.hasNext()) {
            Object element = itr.next();
            System.out.print(element + " ");
        }
        
// Modify objects being iterated
        ListIterator litr = al.listIterator();
        while (litr.hasNext()) {
            Object element = litr.next();
            litr.set(element + "+");
        }
        System.out.print("\nModified contents of al: ");
        itr = al.iterator();
        while (itr.hasNext()) {
            Object element = itr.next();
            System.out.print(element + " ");
        }
        
// Now, display the list backwards
        System.out.print("\nModified list backwards: ");
        while (litr.hasPrevious()) {
            Object element = litr.previous();
            System.out.print(element + " ");
        }
        
        
        /////////-_-///////////
        int a=0; //a= số các số chia hết cho 3
        int sum=0;
        for (int i = 1; i <= 25; i++) {
            if(i%3 == 0) {
                sum += i;
                a++;
            }
        }
        System.out.println(sum + " " +a);
        float tbCong = (float) sum/a;
        System.out.println("kết quả = "+tbCong);
        
        int x=8,y=5;
        double z=(double)x/y;
        System.out.println(z);
    }
}
