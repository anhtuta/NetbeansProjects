/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasedemo_student_2;

/**
 *
 * @author AnhTu
 */
public class Student_2 {

    private String id;
    private String name;
    private String address; //địa chỉ
    private String gioitinh;
    private String email;
    
    public Student_2() {}

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public String getAddress() {
        return address;
    }

    public String getGioitinh() {
        return gioitinh;
    }


    public String getEmail() {
        return email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setAddress(String address) {
        this.address = address;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public Student_2(String id, String name, String address, String gioitinh, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.gioitinh = gioitinh;
        this.email = email;
    }  
}
