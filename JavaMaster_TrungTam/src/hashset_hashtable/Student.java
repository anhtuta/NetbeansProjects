/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashset_hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author AnhTu
 */
/*
Chỉ cẩn xem Person và Person2 là đủ, 2 file Student và Student2 chỉ viết lại để nhớ
*/
public class Student {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) {
        Set<Student> hsStudent = new HashSet();
        hsStudent.add(new Student(1, "anhtu"));
        hsStudent.add(new Student(1, "anhtu"));
        hsStudent.add(new Student(1, "anhtu"));
        hsStudent.add(new Student(1, "anhtu"));
        hsStudent.add(new Student(1, "anhtu"));
        
        for (Student s:hsStudent) {
            System.out.println(s.id+" - "+s.name);
        }
    }
}
/*
kq in ra màn hình:
1 - anhtu
1 - anhtu
1 - anhtu
1 - anhtu
1 - anhtu

do các khi tạo mới đối tượng bằng từ khóa new thì các đối tượng đó là khác nhau, nghĩa là 5 thằng student đc thêm vào là 5 thằng khác nhau trong bộ nhớ Heap
muốn nói cho java biết 5 thằng đó giống nhau thì phải ghi đè hàm equals() VÀ hàm hashCode()
-> xem class Student2
*/