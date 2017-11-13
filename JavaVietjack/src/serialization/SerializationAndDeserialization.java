/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author AnhTu
 */
public class SerializationAndDeserialization {
    public static void main(String[] args) {
        /////////////store data////////////////
        Employee e = new Employee();
        e.name = "Reyan Ali";
        e.address = "Phokka Kuan, Ambehta Peer";
        e.SSN = 11122333;
        e.number = 101;
        Employee e2=new Employee("Anhtu", "Hanoi", 5111995, 4509);
        
        ArrayList<Employee> list=new ArrayList<>();
        list.add(e);
        list.add(e2);
        
        try {
            FileOutputStream fileOut = new FileOutputStream("res/employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            
            out.writeObject(list);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in res/employee.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
        
        /////////////read data////////////////
        System.out.println("\nDeserializing Employee...");
        ArrayList<Employee> list2=new ArrayList();
        try {
            FileInputStream fileIn = new FileInputStream("res/employee.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            list2 = (ArrayList<Employee>) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Read done!");
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
        }
        //kết luận: chỉ lưu đc 1 đối tượng vào file thôi!
        
        System.out.println("\nHere is our data:");
        for (int i = 0; i < list2.size(); i++) {
            System.out.println(list2.get(i).printInfo());
        }
    }
}
