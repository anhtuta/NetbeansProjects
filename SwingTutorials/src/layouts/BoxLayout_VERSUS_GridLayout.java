/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layouts;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author AnhTu
 */
public class BoxLayout_VERSUS_GridLayout extends JFrame {
    JButton []btn;
    public BoxLayout_VERSUS_GridLayout() {
        JPanel p = new JPanel(new BorderLayout()); //main panel
        btn = new JButton[15];
        
        ///now we create 2 sub-panel, 1 for boxlayout and 1 for gridlayout to compare
        JPanel panelBox = new JPanel();
        BoxLayout boxlayout = new BoxLayout(panelBox, BoxLayout.Y_AXIS);  //(2)
        panelBox.setLayout(boxlayout);
        
        for (int i = 0; i < 15; i++) {
            btn[i] = new JButton("Button "+i);
            panelBox.add(btn[i]);
        }
        
        JPanel panelGrid = new JPanel(new GridLayout(15, 1, 0, 0));
        for (int i = 0; i < 15; i++) {
            btn[i] = new JButton("Button "+i);
            panelGrid.add(btn[i]);
        }
        
        p.add(panelBox, BorderLayout.WEST);
        p.add(panelGrid, BorderLayout.EAST);
        
        JLabel lb = new JLabel("Which one is better? BoxLayout or GridLayout?");
        p.add(lb, BorderLayout.CENTER);
        
        add(p);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        new BoxLayout_VERSUS_GridLayout().setVisible(true);
    }
}
