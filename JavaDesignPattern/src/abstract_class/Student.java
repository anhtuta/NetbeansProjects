/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstract_class;

import interface_in_java.*;

/**
 *
 * @author AnhTu
 */
public class Student {
    String name;
    University university;
    int point;

    public Student() {
    }

    public void setUniversity(abstract_class.University university) {
        this.university = university;
    }
    
    public void displayInfo() {
        System.out.println(name + " - " + university.caculatePoint(point));
    }

    public Student(String name, University university, int point) {
        this.name = name;
        this.university = university;
        this.point = point;
    }
    
    public static void main(String[] args) {
//        Student st1 = new Student("anhtu", new UniversityA(), 70);
//        st1.displayInfo();
//        ko thể dùng như trên đc, phải setUniversity() cho nó
        Student st3 = new Student("att", new University() {
            @Override
            public String caculatePoint(int point) {
                if(point>95) return "Perfect";
                else if(point>80) return "Good";
                else if(point>65) return "OK";
                else return "Bad";
            }
        }, 92);
        st3.displayInfo();
        st3.university.displayNote();
        
        Student st4 = new Student();
        st4.name = "att2";
        st4.point = 89;
        st4.setUniversity(new UniversityA());
        st4.displayInfo();
        st4.university.displayNote();
    }
}
