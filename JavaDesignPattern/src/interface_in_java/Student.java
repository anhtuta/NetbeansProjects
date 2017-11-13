/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interface_in_java;

/**
 *
 * @author AnhTu
 */
public class Student {
    String name;
    University university;
    int point;

    public void displayInfo() {
        System.out.println(name + " - " + university.caculatePoint(point));
    }

    public Student(String name, University university, int point) {
        this.name = name;
        this.university = university;
        this.point = point;
    }
    
    public static void main(String[] args) {
        Student st1 = new Student("anhtu", new UniversityA(), 70);
        st1.displayInfo();
        
        Student st2 = new Student("nguyen", new UniversityB(), 65);
        st2.displayInfo();
        
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
    }
}
