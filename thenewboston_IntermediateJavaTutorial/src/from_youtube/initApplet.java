/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package from_youtube;

import java.awt.Graphics;
import javax.swing.JApplet;
import javax.swing.JOptionPane;

/**
 *
 * @author AnhTu
 */
public class initApplet extends JApplet{
    private double sum;
    
    @Override
    public void init() {
        String firstNum = JOptionPane.showInputDialog("Enter first number: ");
        String secondNum = JOptionPane.showInputDialog("Enter first number: ");
        
        double n1 = Double.parseDouble(firstNum);
        double n2 = Double.parseDouble(secondNum);
        
        sum = n1 + n2;
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawString("The sum is " + sum, 25, 30);
    }
}
