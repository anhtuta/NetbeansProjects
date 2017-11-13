/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serialization;

import java.io.Serializable;

/**
 *
 * @author AnhTu
 */
public class Employee implements Serializable {
    public String name;
    public String address;
    public int SSN;
    public int number;

    public Employee(String name, String address, int SSN, int number) {
        this.name = name;
        this.address = address;
        this.SSN = SSN; //social security number: mã số quan trọng nhất ở Mỹ, có 9 chữ số
        this.number = number;
    }

    Employee() { }

    public void mailCheck() {
        System.out.println("Mailing a check to " + name + " " + address);
    }

    public String printInfo() {
        return this.name+" - "+this.address+" - "+this.SSN+" - "+this.number;
    }
}
