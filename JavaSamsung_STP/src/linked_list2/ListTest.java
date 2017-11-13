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
public class ListTest {
    public static void main(String[] args) {
        StLinkedList myList = new StLinkedList();
        Student s1 = new Student("att1", 21);
        Student s2 = new Student("att2", 22);
        Student s3 = new Student("att3", 23);
        Student s4 = new Student("att4", 24);
        Student s5 = new Student("att5", 25);
        
        myList.insertAtFrontOfList(new Student("Anh tu", 22));
        myList.insertAtFrontOfList(s1);
        myList.insertAtFrontOfList(s2);
        myList.insertAtBottomOfList(s3);
        myList.insertAtBottomOfList(s4);
        myList.insertAtBottomOfList(s5);
        
        StudentNode sn4 = new StudentNode(s4);
        myList.insertAfter(sn4, new Student("after s4", 29));
        
        myList.printList();
        
        myList.removeNode("att3");
        System.out.println("\nlist after remove 1 element:");
        
        myList.printList();
        
    }
}
