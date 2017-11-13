/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doubly_linked_list;

import linked_list2.*;

/**
 *
 * @author AnhTu
 */
//class này dùng để tạo từng node cho cả danh sách
public class StudentNode extends Student {
    public StudentNode next;
    public StudentNode previous;
    
    public StudentNode(String name, int age) {
        super(name, age);
        next = null;
        previous = null;
    }
    
    public StudentNode(Student s) {
        super(s.getName(), s.getAge());
        next = null;
        previous = null;
    }

    
}
