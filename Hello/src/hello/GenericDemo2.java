/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.util.Vector;

/**
 *
 * @author AnhTu
 */
public class GenericDemo2 {
    public static void main(String[] args) {
        Vector<C> vt = new Vector<C>(); //Generic kiểu nó là kiểu C
        vt.add(new C());
        vt.add(new D());
        
    }
}

class C {
    
}

class D extends C {
    
}