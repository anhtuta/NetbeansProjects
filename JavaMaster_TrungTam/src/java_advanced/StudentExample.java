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
public class StudentExample {

    int id;
    String name;

    public StudentExample(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof StudentExample) {
            return true;
        } else return false;
    }

    @Override
    public int hashCode() {
        return this.id;
    }
    
    public static void main(String[] args) {
        StudentExample st1 = new StudentExample(101, "anthu");
        StudentExample st2 = new StudentExample(103, "att");
        
        System.out.println("st1.equals(st2)? "+st1.equals(st2));    //true
        System.out.println("st1.hashCode = "+st1.hashCode());   //101
    }
    
}
