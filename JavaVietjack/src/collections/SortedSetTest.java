/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author AnhTu
 */
public class SortedSetTest {

    public static void main(String[] args) {
// Create the sorted set
        SortedSet set = new TreeSet();
// Add elements to the set
        set.add("b");
        set.add("c");
        set.add("a");
        set.add("anhtu");
        set.add("dtvt");
        set.add("bkhn");
        set.add("sôngoku");
        set.add("picollo");
        
// Iterating over the elements in the set
        Iterator it = set.iterator();
        while (it.hasNext()) {
// Get element
            Object element = it.next();
            System.out.println(element.toString());
        }
    }
}
