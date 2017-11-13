/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author AnhTu
 */
public class LinkedHashMapDemo {

    public static void main(String[] args) {
        // Create a hash map
        LinkedHashMap lhm = new LinkedHashMap();
// Put elements to the map
        lhm.put("Zara", new Double(3434.34));
        lhm.put("Mahnaz", new Double(123.22));
        lhm.put("Ayan", new Double(1378.00));
        lhm.put("Daisy", new Double(99.22));
        lhm.put("Qadir", new Double(-19.08));
// Get a set of the entries
        Set set = lhm.entrySet();
// Get an iterator
        Iterator i = set.iterator();
// Display elements
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
        System.out.println();
// Deposit 1000 into Zara's account
        double balance = ((Double) lhm.get("Zara")).doubleValue();
        lhm.put("Zara", new Double(balance + 1000));
        System.out.println("Zara's new balance: "
                + lhm.get("Zara"));
    }
}
