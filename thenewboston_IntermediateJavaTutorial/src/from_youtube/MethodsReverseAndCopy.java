/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package from_youtube;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author AnhTu
 */
public class MethodsReverseAndCopy {
    public static void main(String[] args) {
        Character [] ray = {'a', 'n', 'h', 't', 'u'};
        List<Character> list = Arrays.asList(ray);
        //we can't use these things: 
        //LinkedList<Character> l = Arrays.asList(ray);
        //ArrayList<Character> l = Arrays.asList(ray);
        System.out.println("list is: "+ list);
        Collections.reverse(list);
        System.out.println("list after reverse is: "+ list);
        
        //using copy method:
        Character [] ray2 = new Character[5];
        List<Character> listCopy = Arrays.asList(ray2); //có thể thay ray2 = new Character[5]
        Collections.copy(listCopy, list);
        System.out.println("Copy of list is: "+listCopy);
        
        Collections.fill(list, 'X');
        System.out.println("list after fill is: "+list);
        
    }
}
