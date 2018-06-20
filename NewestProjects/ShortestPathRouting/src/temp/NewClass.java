/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temp;

import temp.Person;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author AnhTu
 */
public class NewClass {
    public static void main(String[] args) {
        Set<Integer> s = new HashSet<>();   // wrapper class Boolean, Character
        s.add(9);
        s.add(9);
        s.add(9);
        s.add(9);
        s.add(9);
        s.add(9);
        
        for(Integer i : s) {
            System.out.println(i);
        }
        
        Set<String> s2 = new TreeSet<>();
        s2.add("Toan");
        s2.add("Toan3");
        s2.add("Toan5");
        s2.add("Toan2");
        s2.add("Toan7");
        s2.add("Toan4");
        
        for(String str : s2) {
            System.out.println(str);
        }
        
        System.out.println();
        Set<Person> s3 = new HashSet<>();
        s3.add(new Person("Toan", 20));
        s3.add(new Person("Toan3", 20));
        s3.add(new Person("Toan2", 10));
        s3.add(new Person("Toan1", 30));
        s3.add(new Person("Toan2", 10));
        
        for(Person p : s3) {
            System.out.println(p.name + " - " + p.age);
        }
    }
}
