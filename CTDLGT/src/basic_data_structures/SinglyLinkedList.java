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
public class SinglyLinkedList {
    public Node head; //chú ý: head là Node đầu tiên của ds, chứ ko phải là thằng nào đó trỏ đến Node đầu tiên của ds
    int length;

    public SinglyLinkedList() {
        head = null;
        length = 0;
    }
    
    
    public void insertFirst(int value) {
        Node p=new Node(value);
        if(head==null) head=p;
        else {
            p.next=head;
            head=p;
        }
        length++;
    }
    
    public void insertLast(int value) {
        Node p=new Node(value);
        if(head==null) head=p;
        else { //sử dụng 1 con trỏ p1 duyệt tới phần tử cuối cùng của ds
            Node p1=head;
            while(p1.next != null) p1=p1.next;
            
            //sau lệnh while ở trên thì p1=phần tử cuối cùng của ds liên kết
            p1.next=p;
        }
        length++;
    }
    
    public void insertAt(int value, int position) { //ví dụ: ds= 1 3 6 2 5, insertTo(7,3), ds trở thành: 1 3 6 7 2 5
        if(position==0) {
            Node p1=new Node(value);
            p1.next=head.next;
            head=p1;
            return;
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
        p.next=p1;
        length++;
    }
    
    public void removeFirst() {
        if(head==null) {
            System.out.println("danh sách đang trống! ko thể remove");
            return;
        }
        else {
            head=head.next;
            length--;
        }
    }
    
    public void removeLast() {
        if(head==null) {
            System.out.println("danh sách đang trống! ko thể remove");
        }
        else {
            Node p=head;
            Node p_prev=head;
            
            while(p.next != null) {
                p_prev=p;
                p=p.next;
            }
            //sau lệnh while ở trên thì p_vrev=phần tử thứ 2 từ cuối của ds liên kết và p1=phần tử cuối cùng của ds liên kết
            p_prev.next=null;
            length--;
        }
    }
    
    public void remove(int v) {
        if(head.value==v) {
            head=head.next;
            length--;
            return;
        }
        Node p=head;
        Node p_prev=head;
        while(p!=null && p.value!=v) {
            p_prev=p;
            p=p.next;
        }
        
        //sau lệnh while ở trên thì p=phần tử của ds có value = v, và p_prev=phần tử đứng trước p
        if(p==null) System.out.println("Ko tìm thấy phần tử cần xóa");
        else {
            p_prev.next=p.next;
            p.next=null;    //Tại sao có dòng này vẫn đúng? Vì p.next = null nghĩa là các phần tử tiếp theo của list bị đứt khỏi list mà? Tại sao?
                            //Có lẽ vì lệnh này chỉ cho thuộc tính next của đối tượng p bằng null thôi, nghĩa là ko cho p trỏ tới phần tử nào nữa
            length--;
        }
    }
    
    public void removeAt(int position) { //ví dụ: ds= 1 3 6 7 2 5, removeAt(4), ds trở thành: 1 3 6 7 5
        if(position==0) {
            removeFirst();
            length--; return;
        }
        Node p=head, p_prev=head;
        int dem=0;
        while(dem!=position) {
            p_prev=p;
            p=p.next;
            dem++;
            if(p.next==null && dem<position) {
                System.out.println("Ko thể xóa! Vị trí phần tử cần xóa lớn hơn kích thước của danh sách");
                return;
            }
        }
        //sau lệnh while trên thì p_prev ở trước vị trí phần tử cần xóa, còn p=phần tử cần xóa
        p_prev.next=p.next;
        p.next=null;
        length--;
    }
    
    public  static SinglyLinkedList insection(SinglyLinkedList A, SinglyLinkedList B) {
        //Hàm này trả về 1 tập là giao của các phần tử trong 2 danh sách A và B, chú ý là 2 ds A,B phải 
        //có các phần tử đã đc sắp xếp tăng dần
        //cách gọi hàm này: Giả sử đã có 2 SinglyLinkedList A, B thỏa mãn yêu cầu các phần tử tăng dần
        //SinglyLinkedList C = new SinglyLinkedList();
        //C = SinglyLinkedList.insection(A, B);
        
        SinglyLinkedList C = new SinglyLinkedList();
        Node p1 = A.head, p2 = B.head;
        while(p1!=null && p2!=null) {
            if (p1.value == p2.value) {
                C.insertLast(p1.value);
                p1 = p1.next;
                p2 = p2.next;
            }
            else if (p1.value > p2.value) p2 = p2.next;
            else if (p1.value < p2.value) p1 = p1.next;
        }
        return C;
    }
    
    public static SinglyLinkedList insection(Node a, Node b) {
        //Hàm này trả về 1 tập là giao của các phần tử trong 2 danh sách A và B,
        //trong đó A.head = a, B.head = b. Chú ý là 2 ds A,B phải có các phần tử đã đc sắp xếp tăng dần
        //cách gọi hàm này: Giả sử đã có 2 SinglyLinkedList A, B thỏa mãn yêu cầu các phần tử tăng dần
        //SinglyLinkedList C = new SinglyLinkedList();
        //C = SinglyLinkedList.insection(A.head, B.head);
        
        SinglyLinkedList C = new SinglyLinkedList();
        Node p1 = a, p2 = b;
        while(p1!=null && p2!=null) {
            if (p1.value == p2.value) {
                C.insertLast(p1.value);
                p1 = p1.next;
                p2 = p2.next;
            }
            else if (p1.value > p2.value) p2 = p2.next;
            else if (p1.value < p2.value) p1 = p1.next;
        }
        return C;
    }
    
    public static Node insection2(Node a, Node b) {
        //cách gọi hàm này: Giả sử đã có 2 SinglyLinkedList A, B thỏa mãn yêu cầu các phần tử tăng dần
        //SinglyLinkedList C = new SinglyLinkedList();
        //C.head = SinglyLinkedList.insection2(A.head, B.head);
        
        SinglyLinkedList C = new SinglyLinkedList();
        Node p1 = a, p2 = b;
        while(p1!=null && p2!=null) {
            if (p1.value == p2.value) {
                C.insertLast(p1.value);
                p1 = p1.next;
                p2 = p2.next;
            }
            else if (p1.value > p2.value) p2 = p2.next;
            else if (p1.value < p2.value) p1 = p1.next;
        }
        return C.head;
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
//        SinglyLinkedList ll=new SinglyLinkedList();
//        ll.insertFirst(6);
//        ll.insertFirst(5);
//        ll.insertFirst(2);
//        ll.insertFirst(8);
//        ll.insertFirst(11);
//        ll.printList();
//        System.out.println("The list's size = "+ll.length);
//        
//        ll.insertLast(4);
//        ll.insertLast(3);
//        ll.insertLast(17);
//        ll.printList();
//        
//        ll.removeFirst();
//        ll.removeFirst();
//        ll.printList();
//        
//        ll.removeLast();
//        ll.printList();
//        
//        ll.remove(6);
//        ll.remove(0);
//        ll.remove(2);
//        ll.printList();
//        
//        ll.insertFirst(9);
//        ll.insertFirst(13);
//        ll.insertFirst(7);
//        ll.insertFirst(2);
//        ll.printList();
//        
//        ll.insertAt(1, 2);
//        ll.printList();
//        
//        ll.insertAt(12, 1);
//        ll.insertAt(15, 0);
//        ll.printList();
//        
//        
//        ll.insertFirst(5);
//        ll.insertFirst(5);
//        ll.insertFirst(3);
//        ll.printList();
//        
//        ll.removeAt(4);
//        ll.removeAt(10);
//        ll.removeAt(10);
//        ll.printList();
//        
//        System.out.println("The list's size = "+ll.length);
//        
        SinglyLinkedList A = new SinglyLinkedList();
        A.insertLast(2);
        A.insertLast(5);
        A.insertLast(6);
        A.insertLast(8);
        A.insertLast(11);
        A.insertLast(23);
        
        SinglyLinkedList B = new SinglyLinkedList();
        B.insertLast(2);
        B.insertLast(5);
        B.insertLast(7);
        B.insertLast(11);
        B.insertLast(12);
        B.insertLast(15);
        B.insertLast(19);
        B.insertLast(22);
        B.insertLast(23);
        B.insertLast(26);
        B.insertLast(31);

        System.out.print("A = ");   A.printList();
        System.out.print("B = ");   B.printList();
        
        SinglyLinkedList C = SinglyLinkedList.insection(A, B);
        System.out.print("C = ");   C.printList();
        
        SinglyLinkedList D = SinglyLinkedList.insection(A.head, B.head);
        System.out.print("D = ");   D.printList();
        
        SinglyLinkedList E = new SinglyLinkedList();
        E.head = SinglyLinkedList.insection2(A.head, B.head);
        System.out.print("E = ");   E.printList();
        
    }
    
    //using inner class: như vậy đỡ phải tốn thêm file Node.java, project sẽ dễ nhìn hơn
    private class Node {//để cho đơn giản thì mỗi node chỉ gồm data là 1 số nguyên, và có 1 con trỏ trỏ tới phần tử tiếp theo (và 1 con trỏ tới phần tử trước đó nếu là danh sách đôi)
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
}
