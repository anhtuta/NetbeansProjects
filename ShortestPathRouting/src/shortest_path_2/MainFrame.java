/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortest_path_2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author AnhTu
 */
public class MainFrame extends JFrame {
    MainPanel panel;
    
    public MainFrame() {
        panel = new MainPanel();
        this.add(panel);
        
        JPanel btnPanel = new JPanel();
        JButton btFindPath = new JButton("Find shortest path");
        btnPanel.add(btFindPath);
        this.add(btnPanel, BorderLayout.SOUTH);
        btFindPath.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.paintShortestPath();
                System.out.println("painting");
            }
        });
        
        this.setName("Shortest path routing example");
        this.setSize(450, 450);
        this.setDefaultCloseOperation(3);
    }
    
    public static void main(String[] args) { 
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        mf.panel.printA();
    }
}
