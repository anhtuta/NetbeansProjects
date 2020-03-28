/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package from_youtube;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author AnhTu
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        String [] things = {"apples", "noobs", "pwnge", "bacon", "goATS"};
        LinkedList<String> list1 = new LinkedList<String>();
        for(String s : things) list1.add(s);
        
        String [] things2 = {"sausage", "bacon", "goats", "harrypotter"};
        LinkedList<String> list2 = new LinkedList<String>();
        for(String s : things2) list2.add(s);
        
        list1.addAll(list2);
        System.out.println(list1);
        System.out.println(list2);  System.out.println();
        
        list2 = null;
        System.out.println(list2);  System.out.println();
        
        removeStuff(list1, 2, 4); //note : this is the static method, so it effects directly on our instance: list1, which means this method will change the value of list1
        System.out.println("list1 after remove stuff is: " + list1);  System.out.println();
        
        System.out.println("list1 after reverse is:");
        reverseMe(list1); System.out.println();  //this method doesn't reverse list1, it just prints the list1 in the reverse way
        System.out.println("list1 before reverse is:" + list1); System.out.println();   //so the list1 doesn't change
        
        ArrayList<String> list3 = new ArrayList<String>();
        for(String s : things) list3.add(s);
        System.out.println("list3 is:" + list3);
        list3 = reverseMe_arraylist(list3);
        System.out.println("list3 after reverse is:" + list3); System.out.println();
        
        //============
        String [] things3 = {"house", "tree", "river", "road", "city"};
        LinkedList<String> list4 = new LinkedList<String>();
        for(String s : things3) list4.add(s);
        reverseMe_linkedlist(list4);
        System.out.println("list4 is: " + list4);
        
    }

    private static void removeStuff(LinkedList<String> list, int fromIndex, int toIndex) {
        list.subList(fromIndex, toIndex).clear(); // remove everything from index 2 to index 3, NOT remove thing at index 4
    }

    private static void reverseMe(LinkedList<String> list) {
        ListIterator<String> anhtu = list.listIterator(list.size()); //bắt đầu duyệt từ phần tử cuối cùng của list
        //System.out.println(anhtu.toString()); //kq: java.util.LinkedList$ListItr@15db9742
        while(anhtu.hasPrevious()) {
            System.out.print(anhtu.previous() + " ");
        }
    }
    
    private static void reverseMe_linkedlist(LinkedList<String> list) {
        ListIterator<String> anhtu = list.listIterator(list.size());
        LinkedList<String> listTemp = new LinkedList<String>();
        while(anhtu.hasPrevious()) {
            listTemp.add(anhtu.previous());
        }
        list = listTemp;
    }
    
    private static ArrayList<String> reverseMe_arraylist(ArrayList<String> list) {
        ListIterator<String> anhtu = list.listIterator(list.size()); //bắt đầu duyệt từ phần tử cuối cùng của list
        //System.out.println(anhtu.toString()); //kq: java.util.LinkedList$ListItr@15db9742
        ArrayList<String> listTemp = new ArrayList<String>();
        while(anhtu.hasPrevious()) {
            listTemp.add(anhtu.previous());
        }
        list = listTemp;
        return list;
    }
}
