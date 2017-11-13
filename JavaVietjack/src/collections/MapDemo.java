/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author AnhTu
 */
public class MapDemo {
    //Map gồm: Map, HashMap, TreeMap (1 kiểu của SortedMap)
    //Chú ý: Entry là 1 interface tĩnh trong thân của interface Map
    
    public static void main(String[] args) {
        Map<String, String> m1 = new HashMap();
        String key;
        
        m1.put("Zara", "8");
        m1.put("Mahnaz", "31");
        m1.put("Ayan", "12");
        m1.put("Daisy", "14");
        m1.put("anhtu", "1995");
        m1.put("2017", "21/2/2017");
        
        Map m2=m1;
        System.out.println("Map Elements: "+m1);
        System.out.println("Map's size: "+m1.size());
        System.out.println("Map's hashcode: "+m1.hashCode());
        System.out.println("Map's empty?: "+m1.isEmpty());
        System.out.println("get(3)= "+m1.get(3));
        System.out.println("get(anhtu)= "+m1.get("anhtu"));
        System.out.println("get(2017)= "+m1.get(2017));
        System.out.println("m1.equals(m2)?: "+m1.equals(m2));
        m1.put("today", "22/2/2017");
        m2.put("bkhn", "2017");
        m1.put("anhtu", "0511");  //giá trị của key anhtu bị ghi đè từ 1995 thành 0511
        System.out.println("\nm1 = "+m1);
        System.out.println("m1.equals(m2)?: "+m1.equals(m2));
        System.out.println("Map's size: "+m1.size());
        System.out.println("countain value att: "+m1.containsValue("att"));
        System.out.println("countain key att: "+m1.containsKey("att"));
        
        System.out.println("\nDùng keySet:");
        Set set=m1.keySet();
        System.out.println("keySet = "+set);  //chỉ toàn là key, ko in ra đc value của từng key, muốn in phải dùng iterator
        Iterator iter=set.iterator();
        while(iter.hasNext()) {
            key=String.valueOf(iter.next());
            System.out.println(key + " - " + m1.get(key));
        }
        
        System.out.println("\nDùng entrySet:");
        Set entrySet = m1.entrySet();  //lấy 1 tập gồm tất cả các entry
        System.out.println(entrySet);
        iter=entrySet.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
        
        System.out.println("\nDùng Map.entry:");
        Map.Entry me2;
        iter=entrySet.iterator();
        while(iter.hasNext()) {
            me2=(Map.Entry) iter.next();
            System.out.println(me2.getKey()+ " - "+me2.getValue());
        }
        
        //////////////////////////TreeMap://///////////////////
        System.out.println("\nExample of SortedMap:");
        // Create a hash map
        TreeMap<String, Double> tm = new TreeMap();
        
        tm.put("Zara", new Double(3434.34));
        tm.put("Mahnaz", new Double(123.22));
        tm.put("Ayan", new Double(1378.00));
        tm.put("Daisy", new Double(99.22));
        tm.put("Qadir", new Double(-19.08));
        
        System.out.println("dùng iterator để duyệt set");
        set = tm.entrySet();
        Iterator i = set.iterator();  //dùng iterator để duyệt set
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            System.out.println(me.getKey() + ": " +me.getValue());
        }
        
        //dùng for để duyệt:
        System.out.println("dùng for để duyệt:");
        for(Entry entrys : tm.entrySet()) {
            System.out.println(entrys.getKey()+" - "+entrys.getValue());
        }
        // Deposit 1000 into Zara's account
        double balance = ((Double) tm.get("Zara")).doubleValue();
        tm.put("Zara", new Double(balance + 1000));
        System.out.println("\nZara's new balance: " + tm.get("Zara"));
        
        TreeMap tm2 = new TreeMap(m1);
        tm2.put("att", "bkhn");
        System.out.println("tm2= "+tm2);
        set =  tm2.keySet();
        i = set.iterator();
        while(i.hasNext()) {
            key=String.valueOf(i.next());
            System.out.println(key +" - "+tm2.get(key));
        }
    }
}
