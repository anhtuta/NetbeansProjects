/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree_set;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author AnhTu
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        Set<Person> linkedHS = new TreeSet<>();

        linkedHS.add(new Person(1, "nam"));
        linkedHS.add(new Person(3, "att"));
        linkedHS.add(new Person(7, "anhtu"));
        linkedHS.add(new Person(2, "huy"));
        linkedHS.add(new Person(5, "toan"));
        linkedHS.add(new Person(1, "nam"));
        linkedHS.add(new Person(3, "trung"));
        linkedHS.add(new Person(10, "nam"));
        linkedHS.add(new Person(17, "att"));
        linkedHS.add(new Person(3, "nam"));
        linkedHS.add(new Person(21, "nam"));
        linkedHS.add(new Person(15, "nam"));
        
        System.out.println("Chú ý rằng các đối tượng thêm vào TreeSet sẽ theo thứ tự đc sắp xếp theo chiều tăng dần, do đó class Person phải implements Comparable<Person> để biết được sự tăng dần đó dựa vào cái gì, hay nguyên lý tăng dần là gì");
        Iterator iter = linkedHS.iterator();
        while(iter.hasNext()) {
            Person p = (Person) iter.next(); 
            System.out.println(p.getInfo());
        }
    }
}
/*
Chú ý rằng các đối tượng thêm vào TreeSet sẽ theo thứ tự đc sắp xếp theo chiều tăng dần, do đó class Person phải implements Comparable<Person> để biết được sự tăng dần đó dựa vào cái gì, hay nguyên lý tăng dần là gì
1 - nam
2 - huy
3 - att
3 - nam
3 - trung
5 - toan
7 - anhtu
10 - nam
15 - nam
17 - att
21 - nam
*/