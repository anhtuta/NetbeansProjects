/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic_data_structures;

/**
 *
 * @author AnhTu
 */
public class QueueList {
    int size;
    private Node front = null;
    private Node back = null;
    
    public void insert(int v) {
        Node p = new Node(v);
        if(front == null) { //khi queue rỗng
            front = p;
            back = p;
        }
        else {
            p.next = front;
            front = p;
        }
        size++;
    }
    
    public int get() {
        if(front == null) {
            System.out.println("Queue is empty now, can't get!");
            return 0;
        }
        else {
            if(front.next == null) {
                int result = front.value;
                front = null;
                return result;
            }
            Node p = front;
            Node p_prev = front;
            while(p.next != null) {
                p_prev = p;
                p=p.next;
            }
            int result = p.value;
            p_prev.next = null;
            back = p_prev;
            if(size!=0) size--;
            return result;
        }
    }
    
    public boolean isEmpty() {
        return front==null;
    }
    
    public void printQueue() {
        if(front == null) {
            System.out.println("Queue is empty, can't print!");
        } else {
            Node p =front;
            while(p != null) {
                System.out.print(p.value+ " ");
                p=p.next;
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        QueueList ql = new QueueList();
        ql.insert(3);
        ql.insert(1);
        ql.insert(4);
        ql.insert(2);
        ql.insert(6);
        ql.insert(11);
        ql.insert(9);
        ql.printQueue();
        System.out.println("The size of stack = "+ql.size);    
        
        int re = ql.get();
        System.out.println("The result just get = "+re);
        ql.printQueue();
        ql.get();
        ql.get();
        ql.printQueue();
        System.out.println("The size of stack = "+ql.size);    
        ql.get();
        ql.get();
        ql.get();
        ql.get();
        ql.get();
        ql.get();
        ql.get();
        System.out.println("ql.get() = "+ql.get());
        ql.printQueue();
        System.out.println("The size of stack = "+ql.size);      
        
    }
    
    ///inner class Node:
    private class Node {  //để cho đơn giản thì mỗi node chỉ gồm data là 1 số nguyên, và có 1 con trỏ trỏ tới phần tử tiếp theo (và 1 con trỏ tới phần tử trước đó nếu là danh sách đôi)
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
}

//lay phan tu cuoi cung:
//Node p = top, p_prev = top;
//            while(p.next != null) {
//                p_prev = p;
//                p = p.next;
//            }
//            int result = p.value;
//            p_prev.next = null; //eliminate the final element
//            return result;
