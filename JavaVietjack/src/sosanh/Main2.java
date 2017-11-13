/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sosanh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author AnhTu
 */
//Bài này dùng comparator: nó có ưu điểm hơn comparable: ko cần đụng chạm thêm đến class Student,
//nghĩa là class student ko cần implements thêm j nữa, và class này cũng vậy

public class Main2 {
    public static void main(String[] args) {
        List<Student2> list=new ArrayList();
        
        list.add(new Student2(1, "Anhtu"));
        list.add(new Student2(3, "Nguyen"));
        list.add(new Student2(6, "nam"));
        list.add(new Student2(2, "trung"));
        list.add(new Student2(5, "Quan"));
        list.add(new Student2(7, "Linh"));
        list.add(new Student2(4, "Son"));
        
        System.out.println("After sorting:");
        Collections.sort(list, new Comparator<Student2>() {
            @Override
            public int compare(Student2 t1, Student2 t2) {
                //so sánh theo id:
                int b=0;
                if(t1.id > t2.id) b=1;
                else if(t1.id < t2.id) b=-1;
                else b=0;
                return b;
                
                //so sánh theo tên:
                //return t1.name.compareToIgnoreCase(t2.name);
            }
        });
        for(Student2 s:list) System.out.println(s.id+" - "+s.name);
        
    }
}
