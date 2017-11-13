/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashset_hashtable;

import java.util.Hashtable;
import java.util.Iterator;

/**
 *
 * @author AnhTu
 */
public class Person3 {
    int id;
    String name;

    public Person3(int id, String name) {
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
        Hashtable<String, Person3> ht = new Hashtable<>();
        ht.put("1", new Person3(1001, "att"));
        ht.put("p2", new Person3(1212, "nam"));
        ht.put("per", new Person3(3423, "huy"));
        ht.put("stupid", new Person3(1311, "trung"));
        ht.put("ngu", new Person3(8865, "feaf fea"));
        
        Iterator<String> iter = ht.keySet().iterator();
        Person3 p;
        String key;
        
        while(iter.hasNext()) {
            key = iter.next();
            p = ht.get(key);
            System.out.println("(" + key + ") " + p.getInfo());
        }
        
        System.out.println("\nAfter changing value of key \"ngu\":");
        ht.put("ngu", new Person3(5555, "Myt Tokyo"));
        iter = ht.keySet().iterator();
        while(iter.hasNext()) {
            key = iter.next();
            p = ht.get(key);
            System.out.println("(" + key + ") " + p.getInfo());
        }
    }
}
/*
(ngu) 8865 - feaf fea
(per) 3423 - huy
(stupid) 1311 - trung
(1) 1001 - att
(p2) 1212 - nam

After changing value of key "ngu":
(ngu) 5555 - Myt Tokyo
(per) 3423 - huy
(stupid) 1311 - trung
(1) 1001 - att
(p2) 1212 - nam
*/