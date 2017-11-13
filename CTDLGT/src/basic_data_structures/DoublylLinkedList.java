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
public class DoublylLinkedList {
    Node head=null;
    
    public void insertFirst(int value) {
        Node p=new Node(value);
        if(head==null) head=p;
        else {
            p.next=head;
            head.prev=p;
            head=p;
        }
    }
    
    public void insertLast(int value) {
        Node p=new Node(value);
        if(head==null) head=p;
        else { //sử dụng 1 con trỏ p1 duyệt tới phần tử cuối cùng của ds
            Node p1=head;
            while(p1.next != null) p1=p1.next;
            
            //sau lệnh while ở trên thì p1=phần tử cuối cùng của ds liên kết
            p1.next=p;
            p.prev=p1;
        }
    }
    
    public void insertAt(int value, int position) { //ví dụ: ds= 1 3 6 2 5, insertTo(7,3), ds trở thành: 1 3 6 7 2 5
        if(position==0) {
            insertFirst(value); return;
        }
        int dem=1;
        Node p=head;
        while(dem != position) {
            p=p.next;
            dem++;
        }
        
        //sau lệnh while trên thì p ở trước vị trí phần tử cần chèn, với ví dụ trên thì p=6, dem=3
        Node p1=new Node(value);
        
        p1.next=p.next;
        p1.prev=p;
        p.next.prev=p1;
        p.next=p1; //cách làm khác với bên Samsung STP
    }
    
    public void removeFirst() {
        if(head==null) {
            System.out.println("danh sách đang trống! ko thể remove");
            return;
        }
        else {
            if(head.next==null) head=null;
            else {
                head.next.prev = null;
                head = head.next;
            }
        }
    }
    
    public void removeLast() {
        if(head==null) {
            System.out.println("danh sách đang trống! ko thể remove");
            return;
        }
        else {
            Node p=head;
            
            while(p.next != null) p=p.next;
            //sau lệnh while ở trên thì p=phần tử cuối cùng của ds liên kết
            p.prev.next=null;
        }
    }
    
    public void remove(int v) {
        if(head.value==v) {
            head=head.next;
            return;
        }
        Node p=head;
        while(p!=null && p.value!=v) p=p.next;
        
        //sau lệnh while ở trên thì p=phần tử của ds có value = v
        if(p==null) System.out.println("Ko tìm thấy phần tử cần xóa");
        else {
            p.prev.next=p.next;
            p.next=null;
            p.prev=null;
        }
    }
    
    public void removeAt(int position) { //ví dụ: ds= 1 3 6 7 2 5, removeAt(4), ds trở thành: 1 3 6 7 5
        if(position==0) {
            removeFirst(); return;
        }
        Node p=head;
        int dem=0;
        while(dem!=position) {
            p=p.next;
            dem++;
            if(p.next==null && dem<position) {
                System.out.println("Ko thể xóa! Vị trí phần tử cần xóa lớn hơn kích thước của danh sách");
                return;
            }
        }
        //sau lệnh while trên thì p=phần tử cần xóa
        p.prev.next=p.next;
        p.next=null;
        p.prev=null;
    }
    
    public void printList() {
        Node p=head;
        while(p != null) {
            System.out.print(p.value+" ");
            p=p.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        DoublylLinkedList ll=new DoublylLinkedList();
        ll.insertFirst(6);
        ll.insertFirst(5);
        ll.insertFirst(2);
        ll.insertFirst(8);
        ll.insertFirst(11);
        ll.printList();
        
        ll.insertLast(4);
        ll.insertLast(3);
        ll.insertLast(17);
        ll.printList();
        
        ll.removeFirst();
        ll.removeFirst();
        ll.printList();
        
        ll.removeLast();
        ll.printList();
        
        ll.remove(6);
        ll.remove(0); //Nó sẽ in ra kq: Ko tìm thấy phần tử cần xóa
        ll.remove(2);
        ll.printList();
        
        ll.insertFirst(9);
        ll.insertFirst(13);
        ll.insertFirst(7);
        ll.insertFirst(2);
        ll.printList();
        
        ll.insertAt(1, 2);
        ll.printList();
        
        ll.insertAt(12, 1);
        ll.insertAt(15, 0);
        ll.printList();
        
        
        ll.insertFirst(5);
        ll.insertFirst(5);
        ll.insertFirst(3);
        ll.printList();
        
        ll.removeAt(4);
        ll.removeAt(0);
        ll.printList();
        
        ll.removeAt(15);
        ll.printList();
    }
    
    //inner class:
    private class Node {
        public int value;
        public Node next, prev;

        public Node(int value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }
}
