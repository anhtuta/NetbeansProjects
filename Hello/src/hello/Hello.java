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
public class Hello {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //numOfPeople = 0; ko thể dùng biến numOfPeople ở hàm main
        People p1 = new People("Ta anh tu",21,"Ha Noi");
        p1.display();    
        People p2 = new People("Captain America",25,"New York");
        p2.display();
        People p3 = new People("Hulk",27,"Ho Cho Minh City");
        p3.display();
        People p4 = new People("Tony Stark",26,"Da Nang");
        p4.display();
        //System.out.println("Co tat ca "+ numOfPeople +" nguoi");  // ko dùng đc biến numOfPeople
        
        System.out.println("Co tat ca "+ People.getNumOfPeople() +" nguoi"); 
        System.out.println("Chao cac ban!");
    }
    
}
