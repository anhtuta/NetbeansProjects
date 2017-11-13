/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_structures;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 *
 * @author AnhTu
 */
public class HashTableDemo {
    public static void main(String args[]) {
        // Create a hash map
        Hashtable balance = new Hashtable();
        Enumeration names;
        String key;
        
        balance.put("Zara", new Double(3434.34));
        balance.put("Mahnaz", 123.22);
        balance.put("Ayan", new Float(1378.00));
        balance.put("Daisy", 99);
        balance.put("Qadir", new Integer(19));
        
        System.out.println("balance = "+balance);
        // Show all balances in hash table.
        System.out.println("\nduyệt dùng kiểu liệt kê:");
        names = balance.keys(); //Trả về một bản liệt kê chứa các key được chứa trong hash table
        while (names.hasMoreElements()) {
            key = (String) names.nextElement();  //lấy key
            System.out.println(key + ": " + balance.get(key));
        }
        
        // Deposit 1,000 into Zara's account
        double bal = ((Double) balance.get("Zara")).doubleValue();
        balance.put("Zara", new Double(bal + 1000)); //thay đổi giá trị của khóa Zara
        System.out.println("\nZara's new balance: " + balance.get("Zara"));
    }
}
