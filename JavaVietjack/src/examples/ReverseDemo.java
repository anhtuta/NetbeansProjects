/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author AnhTu
 */
public class ReverseDemo {
    public static void main(String[] args) {
        String[] coins = { "A", "B", "C", "D", "E"};
        List l = new ArrayList();
        for (int i = 0; i < coins.length; i++) {
            l.add(coins[i]);
        }
        ListIterator liter = l.listIterator();
        System.out.println("Before reversal");
        while (liter.hasNext()) {
            System.out.println(liter.next());
        }
        
        Collections.reverse(l);
        liter = l.listIterator();
        System.out.println("After reversal");
        while (liter.hasNext()) {
            System.out.println(liter.next());
        }
        
   }
}
