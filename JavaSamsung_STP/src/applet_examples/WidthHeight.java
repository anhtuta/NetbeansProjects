/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applet_examples;

import javax.swing.JFrame;

/**
 *
 * @author AnhTu
 */
public class WidthHeight extends JFrame {
    public WidthHeight() {
        setSize(300, 500);
    }
    
    public static void main(String[] args) {
        WidthHeight wh = new WidthHeight();
        wh.setVisible(true);
        System.out.println(wh.getWidth());
        System.out.println(wh.getHeight());
    }
}
