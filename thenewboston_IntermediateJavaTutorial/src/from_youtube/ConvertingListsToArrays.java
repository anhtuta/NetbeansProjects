/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package from_youtube;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author AnhTu
 */
public class ConvertingListsToArrays {
    public static void main(String[] args) {
        String [] things = {"apples", "noobs", "pwnge", "bacon", "goat"};
        System.out.println(things);
        LinkedList<String> list1 = new LinkedList<String>(Arrays.asList(things));
        System.out.println(list1);
        
        ArrayList<String> list2 = new ArrayList<String>(Arrays.asList(things));
        System.out.println(list2);
        
        list1.add("pumpkin");
        list1.addFirst("First_thing");
        System.out.println(list1);
        
        //convert string to array:
        things = list1.toArray(new String[list1.size()]);
        for(String s : things) System.out.print(s + " "); System.out.println();
        
        Object [] things2;
        things2 = list1.toArray();
        for(Object s : things2) System.out.print(s + " ");
    }
}
