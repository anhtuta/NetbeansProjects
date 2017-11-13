/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashset_hashtable;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

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

        System.out.println("Ví dụ với HashSet:");
        Set<Person2> hs = new HashSet<Person2>();
        hs.add(new Person2(1, "nam"));
        hs.add(new Person2(3, "att"));
        hs.add(new Person2(7, "anhtu"));
        hs.add(new Person2(2, "huy"));
        hs.add(new Person2(25, "toan"));
        hs.add(new Person2(29, "nguyen"));
        hs.add(new Person2(13, "trung"));
        hs.add(new Person2(10, "nam"));
        hs.add(new Person2(17, "att"));
        hs.add(new Person2(1, "nam"));
        hs.add(new Person2(31, "nam"));
        hs.add(new Person2(15, "nam"));
        
        Iterator<Person2> iter = hs.iterator();
        Person2 p;
        while(iter.hasNext()) {
            p = iter.next();    //ko cần phải ép kiểu:  p = (Person) iter.next();   vì đã có Iterator<Person>
            System.out.println(p.getInfo());
        }
        
        System.out.println("\nVí dụ với LinkedHashSet:");
        Set<Person2> linkedHS = new LinkedHashSet<>();

        linkedHS.add(new Person2(1, "nam"));
        linkedHS.add(new Person2(3, "att"));
        linkedHS.add(new Person2(7, "anhtu"));
        linkedHS.add(new Person2(2, "huy"));
        linkedHS.add(new Person2(25, "toan"));
        linkedHS.add(new Person2(29, "nguyen"));
        linkedHS.add(new Person2(13, "trung"));
        linkedHS.add(new Person2(10, "nam"));
        linkedHS.add(new Person2(17, "att"));
        linkedHS.add(new Person2(1, "nam"));
        linkedHS.add(new Person2(31, "nam"));
        linkedHS.add(new Person2(15, "nam"));
        
        iter = linkedHS.iterator();
        while(iter.hasNext()) {
            p = iter.next();
            System.out.println(p.getInfo());
        }
    }
}
/*
Ví dụ với HashSet:
7 - anhtu
29 - nguyen
13 - trung
25 - toan
15 - nam
1 - nam
17 - att
1 - nam
3 - att
2 - huy
31 - nam
10 - nam

Ví dụ với LinkedHashSet:
1 - nam
3 - att
7 - anhtu
2 - huy
25 - toan
29 - nguyen
13 - trung
10 - nam
17 - att
1 - nam         //do ko override hàm equals và hashCode nên tồn tại 2 thằng "1 - nam"
31 - nam
15 - nam
*/