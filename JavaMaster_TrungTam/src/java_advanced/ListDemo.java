/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_advanced;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author AnhTu
 */
//chú ý: linkedlist là danh sách liên kết, do đó phù hợp nếu thường xuyên THÊM, XÓA phần tử trong list
//còn ArrayList là 1 mảng, do đó phù hợp nếu thường xuyên TRUY CẬP, LẤY data các phần tử trong list
public class ListDemo {
    public static void main(String[] args) {
        List<Student> listStudent = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            listStudent.add(new Student(i, "student"+i));
        }
        
        for (int i = 0; i < listStudent.size(); i++) {
            System.out.println(listStudent.get(i).printStudent());
        }
        
        listStudent.remove(new Student(5, "student5")); //do ta đã override hàm equals trong class Student,
        //nên thằng new Student(5, "student5") ở lệnh này == thằng student có id=5 và name=student5 đã đc thêm váo list ở trên,
        //do đó nó bị xóa đi. Nếu ko override hàm equals thì ko thể remove thằng student có id = 5
        
        System.out.println("list after delele:");
        for (int i = 0; i < listStudent.size(); i++) {
            System.out.println(listStudent.get(i).printStudent());
        }
        
//        Set<Student> setSt = new TreeSet<Student>();
//        setSt.addAll(listStudent);
//        
//        Iterator iterator = setSt.iterator();

        List<Student> linkedListSt = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            linkedListSt.add(new Student(i, "linked_student"+i));
        }
        for (int i = 0; i < linkedListSt.size(); i++) {
            System.out.println(linkedListSt.get(i).printStudent());
        }
    }
}
