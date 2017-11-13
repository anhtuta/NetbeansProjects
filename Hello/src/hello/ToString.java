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
public class ToString {
    public static void main(String[] args) {
        ToString at = new ToString();  //chú ý ToString là tên class
        System.out.println(at);
        System.out.println(at.toString());
        
        StringBuilder b = new StringBuilder("Anh tu");
        System.out.println(b.toString());
    }
    
    @Override
    public String toString() {   //override hàm toString()
        return "this is an toString example";
    }
}
