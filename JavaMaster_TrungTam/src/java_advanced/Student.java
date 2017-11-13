/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_advanced;

/**
 *
 * @author AnhTu
 */
public class Student {
    
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Student) && (this.id == ((Student) o).id) && this.name.equals(((Student) o).name);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.id;
        return hash;
    }
    
    public String printStudent() {
        return this.id + " - "+this.name;
    }
    
    public static void main(String[] args) {
        Student st1 = new Student(1, "anhtu");
        Student st2 = new Student(1, "anhtu");
        Student st3 = new Student(1, "att");
        StudentExample st4 = new StudentExample(1, "anhtu");
        
        System.out.println(st1==st2);  //false
        //do biến st1 trỏ đến 1 đối tượng Student trong bộ nhớ heap,
        //và biến st12 cũng trỏ đến 1 đối tượng Student khác trong bộ nhớ heap, do đó 2 đối tượng st1 và st2 là hoàn toàn độc lập với nhau, do đó kq trả về của lệnh st1==st2 là false
        
        System.out.println(st1.equals(st2));  //true, vì ta đã override 2 hàm equals và hashCode
        //CHÚ Ý: PHẢI override CẢ 2 HÀM equals và hashCode THÌ MỚI CÓ TÁC DỤNG, VÌ JAVA SO SÁNH 2 ĐỐI TƯỢNG NHỜ CẢ 2 HÀM ĐÓ
        
        System.out.println(st1.equals(st3));  //false
        System.out.println(st1.equals(st4));  //false, because using equals() on incompatible types
    }
}
