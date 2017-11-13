/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_advanced;

import collections.Person;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author AnhTu
 */
public class SetDemo {
    public static void main(String[] args) {
        Set<Person> setPerson = new HashSet<>();

        setPerson.add(new Person(1, "nam"));
        setPerson.add(new Person(3, "att"));
        setPerson.add(new Person(7, "anhtu"));
        setPerson.add(new Person(2, "huy"));
        setPerson.add(new Person(5, "toan"));
        setPerson.add(new Person(9, "nguyen"));
        setPerson.add(new Person(13, "trung"));
        setPerson.add(new Person(10, "nam"));
        setPerson.add(new Person(17, "att"));
        setPerson.add(new Person(11, "nam"));
        setPerson.add(new Person(21, "nam"));
        setPerson.add(new Person(15, "nam"));
        
        System.out.println("Chú ý rằng các đối tượng thêm vào HashSet sẽ ko theo đúng thứ tự");     //ví dụ thêm thằng 1-nam đầu tiên mà nó lại ở vị trí số 8 trong hashSet
        System.out.println("\nDùng iterator:");
        Iterator iter = setPerson.iterator();
        while(iter.hasNext()) {
            Person p = (Person) iter.next(); 
            System.out.println(p.getInfo());
        }
        
        System.out.println("\nDùng for:");
        for(Person p : setPerson) {
            System.out.println(p.getInfo());
        }
        
        System.out.println("\nLinkedHashSet: các đối tượng thêm vào sẽ theo đúng thứ tự");
        Set<Person> linkedHashSetPerson = new LinkedHashSet<>();
        linkedHashSetPerson.add(new Person(1, "nam"));
        linkedHashSetPerson.add(new Person(3, "att"));
        linkedHashSetPerson.add(new Person(7, "anhtu"));
        linkedHashSetPerson.add(new Person(2, "huy"));
        linkedHashSetPerson.add(new Person(5, "toan"));
        linkedHashSetPerson.add(new Person(9, "nguyen"));
        linkedHashSetPerson.add(new Person(13, "trung"));
        linkedHashSetPerson.add(new Person(10, "nam"));
        linkedHashSetPerson.add(new Person(17, "att"));
        linkedHashSetPerson.add(new Person(11, "nam"));
        linkedHashSetPerson.add(new Person(21, "nam"));
        linkedHashSetPerson.add(new Person(15, "nam"));
        iter = linkedHashSetPerson.iterator();
        while(iter.hasNext()) {
            Person p = (Person) iter.next(); 
            System.out.println(p.getInfo());
        }
    }
    
}
