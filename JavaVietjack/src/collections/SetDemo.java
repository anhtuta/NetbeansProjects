/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author AnhTu
 */
public class SetDemo {

    public static void main(String args[]) {
        int count[] = {34, 22, 10, 60, 30, 22};
        Set<Integer> set = new HashSet<>();
        try {
            for (int i = 0; i < 5; i++) {
                set.add(count[i]);
            }
            System.out.println(set);
            TreeSet sortedSet = new TreeSet<Integer>(set);
            System.out.println("The sorted list is:");
            System.out.println(sortedSet);
            System.out.println("The First element of the set is: " + (Integer) sortedSet.first());
            System.out.println("The last element of the set is: " + (Integer) sortedSet.last());
        } catch (Exception e) {
        }
        
        System.out.println("\nExample for HashSet:");
        // create a hash set
        HashSet hs = new HashSet();
// add elements to the hash set
        hs.add("B");
        hs.add("A");
        hs.add("D");
        hs.add("E");
        hs.add("C");
        hs.add("F");
        hs.add("A2");
        System.out.println("hs = "+hs);
        
        HashSet hs2=new HashSet();
        hs2.add(12);
        hs2.add(21);
        hs2.add(24);
        hs2.add(15);
        hs2.add(11);
        hs2.add(9);
        hs2.add(17);
        hs2.add(2);
        hs2.add(8);
        System.out.println("hs2 = "+hs2);
        
        HashSet hs3=new HashSet();
        hs3.add("12");
        hs3.add("21");
        hs3.add("24");
        hs3.add("15");
        hs3.add("11");
        hs3.add("9");
        hs3.add("17");
        hs3.add("2");
        hs3.add("8");
        System.out.println("hs3 = "+hs3);
        
        System.out.println("\nExample for LinkedHashSet:");
        // create a hash set
        LinkedHashSet lhs = new LinkedHashSet();
// add elements to the hash set
        lhs.add("B");
        lhs.add("A");
        lhs.add("D");
        lhs.add("E");
        lhs.add("C");
        lhs.add("F");
        System.out.println(lhs);
        
        
        System.out.println("\nExmaple for SortedSet:");
        TreeSet ts = new TreeSet();
        ts.add("12");
        ts.add("21");
        ts.add("24");
        ts.add("15");
        ts.add("11");
        ts.add("9");
        ts.add("17");
        ts.add("2");
        ts.add("8");
        System.out.println("ts = "+ts); //ts đã đc sắp xếp theo kiểu String
        
        TreeSet ts2=new TreeSet();
        ts2.add(12);
        ts2.add(21);
        ts2.add(24);
        ts2.add(15);
        ts2.add(11);
        ts2.add(9);
        ts2.add(17);
        ts2.add(2);
        ts2.add(8);
        System.out.println("ts2 = "+ts2); //ts đã đc sắp xếp theo kiểu int
        
        Object ts3=(TreeSet) ts2.clone();
        System.out.println("ts3 = "+ts3);
        TreeSet ts4=(TreeSet) ts2.clone();
        System.out.println("ts4 = "+ts4);
        
    }
}
