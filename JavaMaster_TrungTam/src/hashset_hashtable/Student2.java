/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashset_hashtable;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author AnhTu
 */
public class Student2 {
    int id;
    String name;

    public Student2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Student2) {
            if(this.id == ((Student2) obj).id && this.name.equals(((Student2) obj).name)) return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.id;
        hash = 13 * hash + Objects.hashCode(this.name);
        //System.out.println("hash = "+hash);
        return hash;
    }
    
    //Có thể chỉ cần retur id là đủ:
//    @Override
//    public int hashCode() {
//        return id;
//    }

    public static void main(String[] args) {
        Set<Student2> hsStudent = new HashSet();
        hsStudent.add(new Student2(1, "anhtu"));
        hsStudent.add(new Student2(1, "anhtu"));
        hsStudent.add(new Student2(1, "anhtu"));
        hsStudent.add(new Student2(1, "anhtu"));
        hsStudent.add(new Student2(1, "anhtu"));
        //CHÚ Ý: PHẢI override CẢ 2 HÀM equals và hashCode THÌ MỚI CÓ TÁC DỤNG, VÌ JAVA SO SÁNH 2 ĐỐI TƯỢNG NHỜ CẢ 2 HÀM ĐÓ
        
        for (Student2 s:hsStudent) {
            System.out.println(s.id+" - "+s.name);
        }
        
        Student2 s2 = new Student2(2, "att");
        System.out.println(Objects.hashCode(s2.name));
    }
}
/*
kq in ra màn hình:
1 - anhtu
96929

Rõ ràng chỉ có 1 đối tượng Student2 đc thêm vào hsStudent, vì 5 lần thêm 5 thằng giống nhau nên hsStudent chỉ nhận 1 thằng
*/