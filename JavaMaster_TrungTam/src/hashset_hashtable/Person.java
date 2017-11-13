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
public class Person {
    int id;
    String name;

    public Person(int id, String name) {
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

    @Override
    public int hashCode() {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Person) && (this.id == ((Person) o).id) && this.name.equals(((Person) o).name);
    }
    //nếu muốn 2 đối tượng person có cả tên và id giống nhau thì chúng equals với nhau
    //thì phải override hàm hashCode như trên, vì HashSet so sách hashCode trước, nếu trùng nhau thì mới dùng hàm equals để so sánh
    //Nếu ko override cả 2 hàm thì khi dùng HashSet, Java sẽ tự lấy hàm hashCode của nó
    
    public static void main(String[] args) {

        System.out.println("Ví dụ với HashSet:");
        Set<Person> hs = new HashSet<Person>();
        hs.add(new Person(1, "nam"));
        hs.add(new Person(3, "att"));
        hs.add(new Person(7, "anhtu"));
        hs.add(new Person(2, "huy"));
        hs.add(new Person(25, "toan"));
        hs.add(new Person(29, "nguyen"));
        hs.add(new Person(13, "trung"));
        hs.add(new Person(10, "nam"));
        hs.add(new Person(17, "att"));
        hs.add(new Person(1, "nam"));
        hs.add(new Person(31, "nam"));
        hs.add(new Person(15, "nam"));
        
        Iterator<Person> iter = hs.iterator();
        Person p;
        while(iter.hasNext()) {
            p = iter.next();    //ko cần phải ép kiểu:  p = (Person) iter.next();   vì đã có Iterator<Person>
            System.out.println(p.getInfo());
        }
        
        System.out.println("\nVí dụ với LinkedHashSet:");
        Set<Person> linkedHS = new LinkedHashSet<>();

        linkedHS.add(new Person(1, "nam"));
        linkedHS.add(new Person(3, "att"));
        linkedHS.add(new Person(7, "anhtu"));
        linkedHS.add(new Person(2, "huy"));
        linkedHS.add(new Person(25, "toan"));
        linkedHS.add(new Person(29, "nguyen"));
        linkedHS.add(new Person(13, "trung"));
        linkedHS.add(new Person(10, "nam"));
        linkedHS.add(new Person(17, "att"));
        linkedHS.add(new Person(1, "nam"));
        linkedHS.add(new Person(31, "nam"));
        linkedHS.add(new Person(15, "nam"));
        
        iter = linkedHS.iterator();
        while(iter.hasNext()) {
            p = iter.next();
            System.out.println(p.getInfo());
        }
    }
}
/*
Ví dụ với HashSet:
1 - nam
17 - att
2 - huy
3 - att
7 - anhtu
25 - toan
10 - nam
29 - nguyen
13 - trung
31 - nam
15 - nam

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
31 - nam
15 - nam

//nhận xét: nếu chỉ override hàm equals mà ko override hàm hashCode thì 2 đối tượng p1 và p2 sau vẫn ko thể bằng nhau:
Person p1 = new Person(1, "nam");
Person p2 = new Person(1, "nam");
do đó linkedHS sẽ tồn tại 2 thằng có giá trị "1 - nam"
*/