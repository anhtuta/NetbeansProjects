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
//viết lại ví dụ này, sử dụng thêm: inner class, kế thừa

//class này để tạo cả danh sách, với mỗi node thuộc kiểu StudentNode
//CHÚ Ý: con trỏ head: có kiểu StudentNode, nghĩa là nó có kiểu giống với kiểu của các node khác trong danh sách
//con trỏ next: cũng có kiểu StudentNode
//nhưng có điểm khác nhau: con trỏ head dùng cho class StLinkedList, còn con trỏ next dùng cho class StudentNode

//head = node đầu tiên trong danh sách, chứ ko phải là 1 con trỏ trỏ tới phần tử đầu tiên. Nhắc lại: nó là 1 node
//next cũng là 1 node thôi
public class StLinkedList {
    private StudentNode head;
    
    //để đơn giản ta chèn node theo thứ tự nhập vào, chứ ko phải theo thứ tự bảng chữ cái
    public void insertAtFrontOfList(Student s) {
        StudentNode temp = new StudentNode(s.getName(), s.getAge());
        if(head == null) head = temp;
        else {
            temp.next = head;
            head = temp;
        }
    }
    
    public void insertAtBottomOfList(Student st) {
        StudentNode temp = new StudentNode(st);
        if(head==null) head = temp;
        else {
            //chèn vào cuối danh sách:
            StudentNode p = head; //node p là node tạm thời để duyệt cả danh sách. duyệt tới node cuối cùng thì cho node cuối cùng đó = p
            while(p.next != null) p = p.next;
            
            //chèn st vào sau node p:
            p.next = temp;
            //temp.next = null; //ko cần nữa vì lúc khởi tạo temp thì temp.next = null rồi
        }
    }
    
    public void insertAfter(StudentNode sn, Student st) {
        StudentNode temp = new StudentNode(st);
        if(head!=null) {
            StudentNode p = head; //thực ra p= this.head
            while( (p!=null) && (p.getName().compareTo(sn.getName()) != 0) ) p = p.next; //nếu  vẫn còn p.next và p.name khác sn.name thì thực hiện vòng while
            //sau vòng while ở trên thì p = sn, nghĩa là p đang ở vị trí có name là sn.name
            //bây giờ chèn st sau p:
            temp.next = p.next;
            p.next = temp;
        }
    }
    
    public void printList() {
        StudentNode p = head;
        while(p != null)  {
            System.out.println(p.getName() + ", " + p.getAge());
            p = p.next;
        }
    }
    
    public void removeNode(String name) {
        StudentNode p = head, previous = head;
        if(head.getName().compareTo(name) == 0) head = head.next;
        else {
            while ((p != null) && (p.getName().compareTo(name)) != 0) {
                previous = p;
                p = p.next;
            } //sau vòng while thì p = node có tên là name, previous là node trước p
            
            if(p == null) System.out.println("Not found any node. Nothing removed!");
            else {
                previous.next = p.next;
                p.next = null;
            }
        }
    }
    
    public void insertBeforeNode(String name) {
        StudentNode p = head, previous_p = head, previous_previous_p = head;
        while((p.next != null) && (p.getName().compareTo(name) != 0)) {
            //KO THỂ LÀM ĐC, PHẢI SỬ DỤNG DANH SÁCH 2 CHIỀU: CÓ NODE NEXT VÀ PREVIOUS
            p = p.next;
        }
    }
    
    
    /////Inner class :
//    public class StudentNode extends Student {
//
//        public StudentNode next;
//
//        public StudentNode(String name, int age) {
//            super(name, age);
//            next = null;
//        }
//
//        //làm như sau là sai:
////    public StudentNode(String name, int age) {
////        this.name = name;
////        this.age = age;
////        this.next = null; //lúc mới khởi tạo: ko cho trỏ vào đâu cả
////    }
//        public StudentNode(Student s) {
//            super(s.getName(), s.getAge());
//            next = null;
//        }
//    }
}
