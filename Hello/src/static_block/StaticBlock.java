/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package static_block;

/**
 *
 * @author AnhTu
    Static block is used for initializing the static variables.This block gets executed
    when the class is loaded in the memory. A class can have multiple Static blocks,
    which will execute in the same sequence in which they have been written into the program
 */
public class StaticBlock {
    static String name;
    static int age;
    
    public StaticBlock() {
        System.out.println("executing constructor");
    }
    
    
    //this is a static initializer. It's executed when the class is loaded and a good place to put initialization of static variables.
    static {
        System.out.println("executing static block 1");
        name = "Anhtu";
        age = 23;
        doCrap();
        System.out.println("Done static block 1!\n");
    }
    
    static void doCrap() {
        System.out.println("Do crap things");
    }
    
    static {
        System.out.println("executing static block 2");
        name = "Nam";
        age = 27;
        doCrap();
        System.out.println("Done static block 2!\n");
    }
    
    public static void main(String[] args) {
        StaticBlock sb = new StaticBlock();
        System.out.println("name = "+name);
        System.out.println("age = "+age);
        
        System.out.println("sb.name = "+sb.name);
        System.out.println("sb.age = "+sb.age);
        
        sb.name = "Nguyen";
        sb.age = 33;
        
        System.out.println("sb.name = "+sb.name);
        System.out.println("sb.age = "+sb.age);
        
    }
}
