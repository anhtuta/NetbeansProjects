/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked_list2;

/**
 *
 * @author AnhTu
 */
//class này dùng để tạo từng node cho cả danh sách
public class StudentNode extends Student {
    public StudentNode next;
    
    public StudentNode(String name, int age) {
        super(name, age);
        next = null;
    }
    
    //làm như sau là sai:
//    public StudentNode(String name, int age) {
//        this.name = name;
//        this.age = age;
//        this.next = null; //lúc mới khởi tạo: ko cho trỏ vào đâu cả
//    }

    public StudentNode(Student s) {
        super(s.getName(), s.getAge());
        next = null;
    }

    
}
