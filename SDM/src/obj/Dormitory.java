/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obj;

/**
 *
 * @author tungt
 */
public class Dormitory {
    public Dormitory(String name, int capacity){
        this.Dormitory_name = name;
        this.Dormitory_capacity = capacity;
    }
    String Dormitory_name;
    int Dormitory_capacity;

    public String getDormitory_name() {
        return Dormitory_name;
    }

    public int getDormitory_capacity() {
        return Dormitory_capacity;
    }
}
