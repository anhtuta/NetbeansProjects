/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash_set_CHU_Y_static;

/**
 *
 * @author AnhTu
 */
public class Test2 {
    public static void main(String[] args) {
        System.out.println("listUser from Test1:");
        for(String s: Test1.listUser) {
            System.out.println(s);
        }
        
        System.out.println("check: "+Test1.checkWhetherExist("goku"));
    }
}
