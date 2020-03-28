/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package from_youtube;

/**
 *
 * @author AnhTu
 */
import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IntroductionToCollections {

    public static void main(String[] args) {
        String[] things = {"banana", "potato", "peanut", "grape"};
        ArrayList<String> list1 = new ArrayList<String>();
        for (String s : things) {
            list1.add(s);
        }
        System.out.println(list1);

        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }
        System.out.println();

        String[] morethings = {"Java", "Android", "C++", "C"};
        ArrayList<String> list2 = new ArrayList<String>();
        for (String s2 : morethings) {
            list2.add(s2);
        }

        for (int i = 0; i < list2.size(); i++) {
            System.out.printf("%s\n", list2.get(i));
        }

        String[] things2 = {"potato", "grape"};
        ArrayList<String> list3 = new ArrayList<String>();
        for (String s3 : things2) {
            list3.add(s3);
        }
        System.out.println();

        editList(list1, list3);
        System.out.println("Now we print the list1. we have 3 ways to do this:");
        System.out.println(list1); //first way
        for(String s: list1) System.out.println(s); //second way
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));  //third way
        }
	System.out.println();
        
        list1.addAll(list2);
        System.out.println(list1);
    }
    
    private static void editList(Collection<String> l1, Collection<String> l2) {
        Iterator<String> iter = l1.iterator();
        while(iter.hasNext()) {
            if(l2.contains(iter.next())) iter.remove();
        }
    }
}

