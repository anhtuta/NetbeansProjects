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
public class ListTest {

    public static void main(String[] args) {

        StLinkedList myList = new StLinkedList();
        myList.insertInOrder("Laura", 73);
        myList.insertInOrder("Alice", 85);
        myList.insertInOrder("James", 56);
        myList.insertInOrder("Wendy", 91);
        myList.printList();
        System.out.println();
        myList.remove("Laura");
        myList.printList();
    }
}
