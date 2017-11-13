/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sosanh;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author AnhTu
 */
//chú ý: cần override 2 hàm equals và hashcode bên trong class Student3
public class Main3 {
    public static void main(String[] args) {
        Set<Student3> set=new LinkedHashSet<>();
        
        set.add(new Student3(5)); //(1)
        set.add(new Student3(11));
        set.add(new Student3(95));
        set.add(new Student3(5)); //(2)
        set.add(new Student3(13));
        set.add(new Student3(7));
        
        System.out.println("my set:");
        for (Student3 s: set) {
            System.out.print(s.getId()+" ");
        }
        //nhận xét: nếu ko override thì 2 đối tượng (1) và (2) là khác nhau, do đó set vẫn chứa đc cả 2
        
        set.remove(new Student3(5)); //nếu ko override hàm hashCode bên class Student3 thì việc xóa này ko có tác dụng
        System.out.println("\nAfter remove:");
        Iterator it=set.iterator();
        while(it.hasNext()) {
            Student3 s=(Student3) it.next();
            System.out.print(s.getId()+" ");
        }
    }
}
