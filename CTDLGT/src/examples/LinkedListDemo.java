/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

/**
 *
 * @author AnhTu
 */
//quy uoc trong cac method, ta đặt các biến phụ như sau: p=head, p1=new Node(data)
public class LinkedListDemo {
    public Node head;
    public int length;

    public LinkedListDemo() {
        this.head = null;
        this.length = 0;
    }
    
    public void insertFirst(int d) {
        Node p1 = new Node(d);
        if(head == null) head = p1;
        else {
            p1.next = head;
            head = p1;
        }
        length++;
    }
    
    public void insertLast(int d) {
        Node p1 = new Node(d);
        if(head == null) head = p1;
        else {
            Node p = head;
            while(p.next!=null) p=p.next;
            p.next = p1;
        }
        length++;
    }
    
    public void remove(int d) {     //xóa phần tử đầu tiên có data=d
        if(head.data == d) {
            head = head.next;
            length--;
        } else {
            //Tim phan tu co data=d:
            Node p=head, prev = head;
            while(p != null) {
                prev = p;
                p=p.next;
                if(p.data == d) break;
            }
            if(p == null) {
                System.out.println("Couldn't find the node to remove");
            } else {
                //remove p:
                prev.next = p.next;
                length--;
                p = null;
            }
        }
    }
    
    public void removeFirst() {
        if(head == null)  {
            System.out.println("Can't remove an element from empty list!");
        } else {
            head = head.next;
            length--;
        }
    }
    
    public void removeLast() {
        if(head == null)  {
            System.out.println("Can't remove an element from empty list!");
        } else {
            Node p = head, prev = head;
            while(p.next != null) {
                prev = p;
                p=p.next;
            }
            prev.next = null;
            length--;
        }
    }
    
    public static LinkedListDemo intersection(LinkedListDemo list1, LinkedListDemo list2) {   //Hàm này trả về 1 tập là giao của các phần tử trong 2 danh sách A và B, chú ý là 2 ds A,B phải có các phần tử đã đc sắp xếp tăng dần
        LinkedListDemo list = new LinkedListDemo();     //result list
        Node a = list1.head;
        Node b = list2.head;
        while(a!=null && b!=null) {
            if(a.data == b.data) {
                list.insertLast(a.data);a = a.next;
                b = b.next;
            } 
            else if(a.data > b.data) b = b.next;
            else if(a.data < b.data) a = a.next;
        }
        
        return list;
    }
    
    public void printList() {
        Node p = head;
        if(p == null) System.out.println("Can't print an empty list!");
        else {
            while(p!=null) {
                System.out.print(p.data+" ");
                p=p.next;
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        LinkedListDemo ll = new LinkedListDemo();
        ll.insertFirst(4);
        ll.insertLast(5);
        ll.insertLast(3);
        ll.insertLast(6);
        ll.insertLast(1);
        ll.insertLast(11);
        ll.remove(3);
        ll.printList();
        System.out.println("ll.length = "+ll.length);
        
        LinkedListDemo ll1 = new LinkedListDemo();
        ll1.insertLast(1);
        ll1.insertLast(2);
        ll1.insertLast(4);
        ll1.insertLast(7);
        ll1.insertLast(11);
        ll1.insertLast(12);
        
        LinkedListDemo ll2 = new LinkedListDemo();
        ll2.insertLast(3);
        ll2.insertLast(4);
        ll2.insertLast(5);
        ll2.insertLast(7);
        ll2.insertLast(12);
        ll2.insertLast(14);
        ll2.insertLast(34);
        
        LinkedListDemo ll3 = LinkedListDemo.intersection(ll1, ll2);
        System.out.print("ll3 = ");
        ll3.printList();
        System.out.println("ll3.length = "+ll3.length);
    }
    
    
    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
}
