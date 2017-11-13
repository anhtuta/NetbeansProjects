/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author AnhTu
 */
public class Comparable_Person implements Comparable<Comparable_Person>, Comparator {

    int id;
    String name;

    public Comparable_Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    
    @Override
    public int compareTo(Comparable_Person t) {
        int b=0;
        if(this.id > t.id) b=1;
        else if(this.id<t.id) b=-1;
        else b=0;
        
        return b;
    }
    
    public static void main(String[] args) {
        List<Comparable_Person> list=new ArrayList<>();
        list.add(new Comparable_Person(1, "A"));
        list.add(new Comparable_Person(3, "B"));
        list.add(new Comparable_Person(6, "C"));
        list.add(new Comparable_Person(2, "D"));
        list.add(new Comparable_Person(5, "E"));
        list.add(new Comparable_Person(7, "F"));
        list.add(new Comparable_Person(4, "G"));
        
        System.out.println("\nBefort sort:");
        for (Comparable_Person p:list) {
            System.out.println(p.id);
        }
        
        System.out.println("\nAfter sort:");
        Collections.sort(list);
        for (Comparable_Person p:list) {
            System.out.println(p.id);
        }
        
        System.out.println("\nAfter sort:");
        Collections.sort(list);
        for (Comparable_Person p:list) {
            System.out.println(p.id);
        }
    }

    @Override
    public int compare(Object t, Object t1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
