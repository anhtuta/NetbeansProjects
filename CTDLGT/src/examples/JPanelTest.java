/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

/**
 *
 * @author AnhTu
 */

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JPanelTest extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        // Draw Tree Here
        g.drawOval(5, 5, 25, 25);
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.add(new JPanelTest());
        jFrame.setSize(500, 500);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}