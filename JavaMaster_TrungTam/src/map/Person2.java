/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import collections.*;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author AnhTu
 */
public class Person2 {
    int id;
    String name;

    public Person2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getInfo() {
        return this.id+" - "+this.name;
    }
    
    public static void main(String[] args) {
        Map<MyKey, Person2> treeMap = new TreeMap<>();     //TreeMap: các phần tử sắp xếp theo chiều tăng của key
        //Do key thuộc kiểu MyKey nên class MyKey bắt buộc phải implements Comparable<MyKey>
        
        treeMap.put(new MyKey(3), new Person2(1, "anhtu"));
        treeMap.put(new MyKey(1), new Person2(10, "nam"));
        treeMap.put(new MyKey(7), new Person2(5, "trung"));
        treeMap.put(new MyKey(2), new Person2(9, "nguyen"));
        treeMap.put(new MyKey(6), new Person2(12, "toan"));
        treeMap.put(new MyKey(2), new Person2(3, "att"));
        treeMap.put(new MyKey(4), new Person2(6, "huy"));
        
        Iterator<MyKey> iter = treeMap.keySet().iterator();
        while(iter.hasNext()) {
            MyKey key = iter.next();
            System.out.println(key.data + ": " + treeMap.get(key).getInfo());
        }
    }
}
/*
1: 10 - nam
2: 3 - att
3: 1 - anhtu
4: 6 - huy
6: 12 - toan
7: 5 - trung
*/