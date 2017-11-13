/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue_list;

/**
 *
 * @author AnhTu
 */
public class QueueList {
    QueueNode front = null, back = null;
    
    public void insert(Object new_data) {
        QueueNode temp = new QueueNode(new_data);
        if(front==null) {
            front = temp;
            back = temp;
        }
        else {
            temp.next = front;
            front = temp;
        }
    }
    
    public Object get() {
        if(front == null) {
            System.out.println("queue is null now");
            return null;
        }
        else {
            QueueNode p = front, p_prev = front; //p dùng để duyệt đến tới danh sách, mục đính để tới đc thằng back
            while (p.next != null) {
                p_prev = p;
                p = p.next;
            }
            Object temp = p.data;
            p_prev.next = null; //xóa phần tử cuối cùng của hàng đợi đi
            back = p_prev;
            if(p == p_prev) front = back = null;
            return temp;
        }
    }
    
    public boolean isEmpty() {
        if(front == null) return true;
        else return false;
    }
    
    public void printQueue() {
        if(front == null) System.out.println("queue is empty now!");
        else {
            QueueNode temp = front;
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }
    
    public static void main(String[] args) {
        QueueList sq = new QueueList();
        
        sq.insert("Anh tu");
        sq.insert(22);
        sq.insert("DHBK HN");
        sq.insert("DTVT is shit!");
        sq.insert("I love BK");
        
        sq.printQueue();
        System.out.println("\nIs stack empty?: "+sq.isEmpty());
        
        sq.get();
        sq.get();
        System.out.println("\nstack after get somethings:");
        sq.printQueue();
        
        sq.get();
        sq.get();
        sq.get();
        sq.get();
        sq.get();
        sq.get();
        System.out.println("\nstack after get somethings:");
        sq.printQueue();
        sq.get();
        sq.get();
        sq.get();
        sq.get();
    }
}
