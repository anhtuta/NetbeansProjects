/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked_list;

/**
 *
 * @author AnhTu
 */
public class StLinkedList {

    private StudentNode head = null;

    //CHÚ Ý: hàm sau insert vào danh sách các node và sắp xếp theo bảng chữ cái
    //ví dụ dùng lần lượt các lệnh sau 
    //    myList.insertInOrder("Laura", 73);
    //    myList.insertInOrder("Alice", 85);
    //    myList.insertInOrder("James", 56);
    //    myList.insertInOrder("Wendy", 91);
    //thì danh sách myList sẽ là:
    //    Alice: 85
    //    James: 56
    //    Laura: 73
    //    Wendy: 91
    
    public void insertInOrder(String _name, int _mark) {
        StudentNode temp = new StudentNode(_name, _mark);
        
        if (head == null) {
            head = temp;
        } else // NOTE: compareTo is a method of the String class.  It returns 
        // a positive int if the String is lexicographically greater than 
        // the parameter, a negative int if it’s smaller and 0 if they are equal
        {
            if ((head.name).compareTo(temp.name) > 0) { //this means: if(head.name != temp.name)
                temp.next = head;
                head = temp;
            } else {
                StudentNode p = head;
                while ((p.next != null) && (((p.next).name).compareTo(temp.name) < 0)) {
                    p = p.next;
                }
                temp.next = p.next;
                p.next = temp;
            }
        }
    }

    public void printList() {
        StudentNode p = head;
        
        while (p != null) {
            System.out.println(p.name + ": " + p.mark);
            p = p.next;
        }
    }

    public void remove(String _name) {
        if ((head.name).compareTo(_name) == 0) {
            head = head.next;
        } else {
            StudentNode p = head, previous = head;
            while ((p != null) && (_name.compareTo(p.name) != 0)) {
                previous = p;
                p = p.next;
            }

            if (p == null) {
                System.out.print("Node not found.Nothing removed");
            } else {
                previous.next = p.next;
            }
        }
    }
}
