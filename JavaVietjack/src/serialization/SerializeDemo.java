/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author AnhTu
 */
//xem thêm java stp, ở project File_Input...
public class SerializeDemo {

    public static void main(String[] args) {
        Employee e = new Employee();
        e.name = "Reyan Ali";
        e.address = "Phokka Kuan, Ambehta Peer";
        e.SSN = 11122333;
        e.number = 101;
        
        Employee e2=new Employee("Anhtu", "Hanoi", 5111995, 4509);
        try {
            FileOutputStream fileOut = new FileOutputStream("res/employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            //Hoặc: ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("res/employee.ser"));
            //out.writeObject(e);
            out.writeObject(e2);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in res/employee.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
