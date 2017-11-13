/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package static_block;

/**
 *
 * @author AnhTu
 */
public class StaticBlock2 {
    static {
        doCraps();
    }
    
    private static void doCraps() {
        System.out.println("This is crap, being executed in a static block!");
    }
    
    public static void printDay() {
        System.out.println("Today is: "+new java.util.Date());
    }
}
