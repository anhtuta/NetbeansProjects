/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sosanh;

/**
 *
 * @author AnhTu
 */
public class Student1 implements Comparable<Student1> { //phải giới hạn kiểu thì mới override đc hàm compareTo(Student1 t)
                                                      //nếu ko phải override hàm compareTo(Object t), khi đó ko so sánh tên 2 sv đc, vì Object ko phải là kiểu Student1
    public int id;
    public String name;

    public Student1(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Student1 t) {//so sanh theo tên
        //so sánh theo tên:
        return this.name.compareToIgnoreCase(t.name);
        
        //so sánh theo id:
//        if(this.id > t.id) return 1;
//        else if(this.id < t.id) return -1;
//        else return 0;
    }
    
}
