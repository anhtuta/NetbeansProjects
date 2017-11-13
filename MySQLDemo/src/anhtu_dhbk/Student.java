/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhtu_dhbk;

/**
 *
 * @author AnhTu
 */
public class Student {
    int id;
    String name;
    String phone;

    public Student(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    void displayStudentInfo() {
        System.out.println(this.id + "\n" + this.name + "\n"+this.phone);
    }
    
}
