/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author AnhTu
 */
/*
    CHÚ Ý: class Person implements Comparable<Person>, còn nếu dùng anonymous class bên trong hàm Collections.sort thì dùng Comparator<Person>
*/
public class Person_Comparable_Comparator {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person(3, "att"));
        list.add(new Person(7, "anhtu"));
        list.add(new Person(2, "huy"));
        list.add(new Person(5, "toan"));
        list.add(new Person(9, "nguyen"));
        list.add(new Person(13, "trung"));
        list.add(new Person(10, "nam"));
        list.add(new Person(17, "att"));
        list.add(new Person(11, "nam"));
        list.add(new Person(21, "nam"));
        list.add(new Person(15, "nam"));    //thứ tự của các phần tử trong list theo thứ tự add
        
        System.out.println("Before sorting:");
        for(Person p:list) {
            System.out.println(p.getInfo());
        }
        
        Collections.sort(list);     //CHÚ Ý: Do list này thuộc kiểu List<Person> nên để dùng đc hàm này
        //thì class Person phải có 1 trong 2 yêu cầu sau:
        //  - implements Comparable<Person> và override hàm: compareTo(Person p)
        //  - override hàm compareTo(Person p) ngay trong anonymous class như ví dụ dưới
        System.out.println("After sorting order by ID:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getInfo());
        }
        
        ///another way to sorting: using anonymous class instead of class Person having to implements Comparable<Person>:
        Collections.sort(list, new Comparator<Person>() {   //sắp xếp theo chiều tăng dần của name
            @Override
            public int compare(Person p1, Person p2) {      //chú ý hàm này có 2 tham số
                return p1.name.compareTo(p2.name);
            }
        });
        System.out.println("After sorting order by name:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getInfo());
        }
        
        Collections.shuffle(list);
        System.out.println("Before sorting order by ascending name and descending ID:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getInfo());
        }
        ///sắp xếp theo chiều tăng dần của name, nếu name trùng nhau thì sắp xếp theo chiều giảm dần của ID:
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                if(p1.name.compareTo(p2.name) > 0) return 1;
                else if(p1.name.compareTo(p2.name) < 0) return -1;
                else {
                    if(p1.id > p2.id) return -1;
                    else if(p1.id < p2.id) return 1;
                    else return 0;
                }
            }
        });
        System.out.println("After sorting order by ascending name and descending ID:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getInfo());
        }
    }
}
/*

Before sorting:
3 - att
7 - anhtu
2 - huy
5 - toan
9 - nguyen
13 - trung
10 - nam
17 - att
11 - nam
21 - nam
15 - nam
After sorting order by ID:
2 - huy
3 - att
5 - toan
7 - anhtu
9 - nguyen
10 - nam
11 - nam
13 - trung
15 - nam
17 - att
21 - nam
After sorting order by name:
7 - anhtu
3 - att
17 - att
2 - huy
10 - nam
11 - nam
15 - nam
21 - nam
9 - nguyen
5 - toan
13 - trung
Before sorting order by ascending name and descending ID:
21 - nam
3 - att
5 - toan
7 - anhtu
9 - nguyen
11 - nam
13 - trung
2 - huy
15 - nam
17 - att
10 - nam
After sorting order by ascending name and descending ID:
7 - anhtu
17 - att
3 - att
2 - huy
21 - nam
15 - nam
11 - nam
10 - nam
9 - nguyen
5 - toan
13 - trung
*/