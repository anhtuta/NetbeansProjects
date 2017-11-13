/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author AnhTu
 */
public class TreeMapDemo {
    public static void main(String[] args) {
        Map m1 = new HashMap();
        String key;
        
        m1.put("Zara", "8");
        m1.put("Mahnaz", "31");
        m1.put("Ayan", "12");
        m1.put("Daisy", "14");
        m1.put("anhtu", 1995);
        m1.put("2017", "21/2/2017");
        m1.put("today", "22/2/2017");
        m1.put("anhtu", "0511");
        
        TreeMap tm = new TreeMap(m1);
        tm.put("att", "bkhn");
        System.out.println("tm= "+tm);
        Set set =  tm.keySet();
        Iterator iter = set.iterator();
        System.out.println("\ntm = ");
        while(iter.hasNext()) {
            key=String.valueOf(iter.next());
            System.out.println(key +" - "+tm.get(key));
        }
        System.out.println("Tại sao thằng tm ko đc sắp xếp theo key của nó?");
    }
}
