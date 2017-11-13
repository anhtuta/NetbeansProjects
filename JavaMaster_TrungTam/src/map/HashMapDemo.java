/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author AnhTu
 */
public class HashMapDemo {
    public static void main(String[] args) {
        Map<Integer, Person> hashMap = new HashMap<>();     //HashMap; các phần tử sắp xếp ko theo thứ tự
        hashMap.put(1, new Person(1, "anhtu"));
        hashMap.put(2, new Person(10, "nam"));
        hashMap.put(5, new Person(5, "trung"));
        hashMap.put(9, new Person(9, "nguyen"));
        hashMap.put(12, new Person(12, "toan"));
        hashMap.put(13, new Person(3, "att"));
        hashMap.put(16, new Person(6, "huy"));
        
        ///duyệt map để lấy value:
        //có 3 cách:
        //  lấy toàn bộ key
        //  lấy toàn bộ value
        //  lấy toàn bộ entry (gồm cả key và value)
        
        System.out.println("Cách 1: Lấy toàn bộ key: dùng hàm keySet()");
        System.out.println("\n1. Dùng For-Each loop:");
        for(Integer key : hashMap.keySet()) {
            System.out.println(key+", "+hashMap.get(key).getInfo());
        }
        System.out.println("\n2. Dùng iterator:");
        Set<Integer> keySet = hashMap.keySet();
        Iterator iter = keySet.iterator();
        while(iter.hasNext()) {
            System.out.println(hashMap.get(iter.next()).getInfo());
        }
        
        System.out.println("\nCách 2: Lấy toàn bộ value: dùng hàm values()");
        System.out.println("\n1. Dùng For-Each loop:");
        for(Person p : hashMap.values()) {
            System.out.println(p.getInfo());
        }
        System.out.println("\n2. Dùng iterator:");
        Iterator<Person> iter2 = hashMap.values().iterator();
        while(iter2.hasNext()) {
            System.out.println(iter2.next().getInfo());
        }
        
        System.out.println("\nCách 3: Lấy toàn bộ entry: dùng hàm entrySet()");
        System.out.println("\n1. Dùng For-Each loop:");
        for(Map.Entry<Integer, Person> entry : hashMap.entrySet()) {
            System.out.println(entry.getValue().getInfo());
        }
        System.out.println("\n2. Dùng iterator:");
        Iterator<Map.Entry<Integer, Person>> iter3 = hashMap.entrySet().iterator();
        while(iter3.hasNext()) {
            System.out.println(iter3.next().getValue().getInfo());
        }
    }
}

/*
Cách 1: Lấy toàn bộ key: dùng hàm keySet()

1. Dùng For-Each loop:
16, 6 - huy
1, 1 - anhtu
2, 10 - nam
5, 5 - trung
9, 9 - nguyen
12, 12 - toan
13, 3 - att

2. Dùng iterator:
6 - huy
1 - anhtu
10 - nam
5 - trung
9 - nguyen
12 - toan
3 - att

Cách 2: Lấy toàn bộ value: dùng hàm values()

1. Dùng For-Each loop:
6 - huy
1 - anhtu
10 - nam
5 - trung
9 - nguyen
12 - toan
3 - att

2. Dùng iterator:
6 - huy
1 - anhtu
10 - nam
5 - trung
9 - nguyen
12 - toan
3 - att

Cách 3: Lấy toàn bộ entry: dùng hàm entrySet()

1. Dùng For-Each loop:
6 - huy
1 - anhtu
10 - nam
5 - trung
9 - nguyen
12 - toan
3 - att

2. Dùng iterator:
6 - huy
1 - anhtu
10 - nam
5 - trung
9 - nguyen
12 - toan
3 - att
*/