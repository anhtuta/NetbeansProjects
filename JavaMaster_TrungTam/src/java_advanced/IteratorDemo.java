/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_advanced;

import collections.Person;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author AnhTu
 */
public class IteratorDemo {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person(1, "nam"));
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
        list.add(new Person(15, "nam"));
        
        ///dùng iterator duyệt có tác dụng tương tự như dùng với vòng lặp for
        Iterator iter = list.iterator();
        while(iter.hasNext()) {
            Person p = (Person) iter.next();
            System.out.println(p.getInfo());
        }
        
        //tuy nhiên nếu muốn xóa 1 phần tử khi duyệt thì phải làm như sau:
        System.out.println("\nExample of list2:");
        List<Person> list2 = list;
        int leng = list2.size();
        for (int i = 0; i < leng; i++) {
            Person p = list2.get(i);
            if(p.getName().equals("nam")) {
                list2.remove(p);
                leng--;     //do xóa 1 phần tử nên phải giảm leng đi
                i--;        //giữ nguyên i nếu gặp ai tên là nam, nghĩa là giả sử i=5 thì p.name = nam, giảm i đi để vòng lặp tiếp theo i vẫn = 5
            }
            else System.out.println(p.getInfo());
        }
        
        //nếu ko muốn lằng nhằng như trên thì dùng iterator dễ dàng hơn:
        System.out.println("\nExample of list3:");
        List<Person> list3 = list;
        iter = list3.iterator();
        while(iter.hasNext()) {
            Person p = (Person) iter.next();
            if(p.getName().equals("nam")) iter.remove();
            else System.out.println(p.getInfo());
        }
    }
}
