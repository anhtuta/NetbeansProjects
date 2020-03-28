/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;

import javax.swing.JFrame;

/**
 *
 * @author AnhTu
 */
public class HelloWorldFrame extends JFrame {
    public HelloWorldFrame() {
        add(new HelloWorldPanel());
        pack();
        
        setSize(300, 200);
        setDefaultCloseOperation(3);
    }
    
    public static void main(String[] args) {
        new HelloWorldFrame().setVisible(true);
    }
    
}
