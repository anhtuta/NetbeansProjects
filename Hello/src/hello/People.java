/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

/**
 *
 * @author AnhTu
 */
public class People {

    public int age;
    public String name;
    public String addr; //địa chỉ
    public static int numOfPeople = 0;  //biến static
    
    public static int getNumOfPeople() {
        return numOfPeople;
    }
    
    People(String ten, int tuoi, String diachi) {  //hàm khởi tạo
        numOfPeople++;
        age = tuoi;
        name = ten;
        addr = diachi;
    }
    
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Tuoi: " + age);
        System.out.println("Address: " + addr + '\n');
    }
}
