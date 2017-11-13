/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obj;

import java.sql.Blob;


/**
 *
 * @author tungt
 */
public class Student {
    public Student(String code, String name, Blob image, int k, 
            String school, String birthday, String gentl, String home,
            String phone, int room, String dormi){
        this.Student_code = code;
        this.Student_name = name;
        this.Student_image = image;
        this.Student_k = k;
        this.Student_school = school;
        this.Student_birth = birthday;
        this.Student_gentl = gentl;
        this.Student_homeLand = home;
        this.Student_phone = phone;
        this.Room_id = room;
        this.Dormitory_name = dormi;
    }
    String Student_code;
    String Student_name;
    Blob Student_image;
    int Student_k;
    String Student_school;
    String Student_birth;
    String Student_gentl;
    String Student_homeLand;
    String Student_phone;
    int Room_id;
    String Dormitory_name;

    public String getStudent_code() {
        return Student_code;
    }

    public String getStudent_name() {
        return Student_name;
    }

    public Blob getStudent_image() {
        return Student_image;
    }

    public int getStudent_k() {
        return Student_k;
    }

    public String getStudent_school() {
        return Student_school;
    }

    public String getStudent_birth() {
        return Student_birth;
    }

    public String getStudent_gentl() {
        return Student_gentl;
    }

    public String getStudent_homeLand() {
        return Student_homeLand;
    }

    public String getStudent_phone() {
        return Student_phone;
    }

    public int getRoom_id() {
        return Room_id;
    }

    public String getDormitory_name() {
        return Dormitory_name;
    }
}
