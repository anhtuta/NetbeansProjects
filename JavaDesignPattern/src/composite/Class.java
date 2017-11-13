/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composite;

import java.util.ArrayList;

/**
 *
 * @author AnhTu
 */
//composite
public class Class implements Education {
    ArrayList<Student> studentList = new ArrayList<>();

    public Class() {
        for (int i = 0; i < 20; i++) {
            studentList.add(new Student(i*2/3, i*10/7));
        }
    }
    
    @Override
    public float caculatePoint() {
        float sum=0;
        for(Student s:studentList) {
            sum += s.caculatePoint();
        }
        return sum/studentList.size();
    }
}
