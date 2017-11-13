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
//chú ý: static void sort(List list): Xếp thứ tự các phần tử trong list như đã xác định bởi thứ tự tự nhiên
//chú ý: static void sort(List list, Comparator comp): Xếp thứ tự các phần tử trong list như đã xác định bởi comp

public class Dog implements Comparator<Dog>, Comparable<Dog> {

    String name;
    int age;
    
    Dog() {
    }

    Dog(String n, int a) {
        name = n;
        age = a;
    }

    public String getDogName() {
        return name;
    }

    public int getDogAge() {
        return age;
    }
    
    @Override //của Comparator
    public int compare(Dog t, Dog t1) {
        return t.getDogAge() - t1.getDogAge();
        //return String.valueOf(t.getDogAge()).compareTo(String.valueOf(t1.getDogAge())); viết ntnay thì nó chỉ so sánh các xâu tuổi, ví dụ: 1<10<11<2<20...
    }

    @Override //của Comparable
    public int compareTo(Dog t) {
        return (this.getDogName()).compareTo(t.getDogName());
    }
}

class Test {
    public static void main(String[] args) {
        // Takes a list o Dog objects
        List<Dog> list = new ArrayList<Dog>();
        list.add(new Dog("Shaggy", 3));
        list.add(new Dog("Lacy", 2));
        list.add(new Dog("Roger", 10));
        list.add(new Dog("Tommy", 4));
        list.add(new Dog("Tammy", 1));
        
        Collections.sort(list);// Sorts the array list
        for (Dog a : list) { //printing the sorted list of names
            System.out.print(a.getDogName() + ", ");
        }
// Sorts the array list using comparator
        Collections.sort(list, new Dog());
        System.out.println(" ");
        for (Dog a : list) { //printing the sorted list of ages
            System.out.print(a.getDogName() + " : " + a.getDogAge() + ", ");
        }
    }
}