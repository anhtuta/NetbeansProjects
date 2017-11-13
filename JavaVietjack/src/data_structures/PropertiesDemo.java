/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_structures;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 *
 * @author AnhTu
 */
public class PropertiesDemo {

    public static void main(String args[]) {
        Properties capitals = new Properties();
        Set setCapitals;
        String key;
        String entry;
        Enumeration enumCapitals;
        
        capitals.put("Illinois", "Springfield");
        capitals.put("Missouri", "Jefferson City");
        capitals.put("Washington", "Olympia");
        capitals.put("California", "Sacramento");
        capitals.put("Indiana", "Indianapolis");
        capitals.put("Nghệ An", "Vinh");
        capitals.put("Hà Nam", "Phủ lý");
        capitals.put("Lâm Đồng", "Đà Lạt");
        
        // Show all states and capitals in hashtable.
        System.out.println("capitals is: "+capitals);
        System.out.println("\nDùng thứ khác để duyệt Properties:");
        
        System.out.println("Cách 1: dùng Enumeration:");
        enumCapitals = capitals.propertyNames();
        while(enumCapitals.hasMoreElements()) {
            key = String.valueOf(enumCapitals.nextElement());
            System.out.println(key + " - " + capitals.getProperty(key));
        }
        
        System.out.println("\nCách 2: dùng iterator:");
        setCapitals=capitals.keySet(); //lấy tập các key từ capitals
        Iterator iter = setCapitals.iterator();
        while(iter.hasNext()) {
            key=String.valueOf(iter.next());
            System.out.println(key+" - "+capitals.getProperty(key));
        }
        
        System.out.println("\nCách 3: gần giống cách 2, nhưng dùng hàm entrySet:");
        Set entrySetCapitals = capitals.entrySet();
        iter = entrySetCapitals.iterator();
        while (iter.hasNext()) {
            entry = String.valueOf(iter.next());
            System.out.println(entry);
            //nó sẽ in ra tất cả các entry của capitals, vì chức năng này cũng giống như Map
            //các entry có dạng: key=value
        }

        System.out.println("\n Cách 4: gần giống cách 3, nhưng ta dùng thêm Map.entry");
        //Viết như sau là sai: Map.Entry me=(Map.Entry) capitals.entrySet();, lỗi: java.util.Collections$SynchronizedSet cannot be cast to java.util.Map$Entry
        setCapitals=capitals.entrySet(); //như cách 3
        iter=entrySetCapitals.iterator(); //như cách 3
        while(iter.hasNext()) {
            Map.Entry me=(Map.Entry) iter.next();
            //System.out.println(me); //thằng me gồm toàn entry thôi, nên nó có dạng key=value, muốn in ra key và value thì làm như sau:
            System.out.println(me.getKey()+" - "+me.getValue());
        }
        
        // look for state not in list -- specify default
        String str=capitals.getProperty("Florida");
        System.out.println("Capital of state Florida is: "+str);
        str=capitals.getProperty("Florida", "chưa nhập vào! đây là giá trị mặc định đc in ra thôi!");
        System.out.println("Capital of state Florida is: "+str);
        
    }
}
