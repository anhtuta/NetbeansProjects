/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_advanced;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author AnhTu
 */
public class Queue_LinkedList {
    public static void main(String[] args) {
        Queue<Student> linkedListQueue = new LinkedList<Student>();
        linkedListQueue.add(new Student(1, "nam"));
        linkedListQueue.add(new Student(3, "att"));
        linkedListQueue.add(new Student(7, "anhtu"));
        linkedListQueue.add(new Student(2, "huy"));
        linkedListQueue.add(new Student(5, "toan"));
        linkedListQueue.add(new Student(9, "nguyen"));
        linkedListQueue.add(new Student(13, "trung"));
        linkedListQueue.add(new Student(10, "nam"));
        linkedListQueue.add(new Student(17, "att"));
        linkedListQueue.add(new Student(11, "nam"));
        linkedListQueue.add(new Student(21, "nam"));
        linkedListQueue.add(new Student(15, "nam"));
        
        for(Student st : linkedListQueue) {
            System.out.println(st.printStudent());
        }
        
        linkedListQueue.remove();
        linkedListQueue.remove();
        linkedListQueue.remove();
        System.out.println("Queue after removing:");
        for(Student st : linkedListQueue) {
            System.out.println(st.printStudent());
        }
    }
}
