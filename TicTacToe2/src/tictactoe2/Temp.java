/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author AnhTu
 */
public class Temp extends JFrame {
    JButton btNew;
    Cell [][] cells = new Cell[3][3];
    
    public Temp() {
        JPanel panel = new JPanel(new BorderLayout());  //main panel
        JPanel cellPanel = new JPanel(new GridLayout(3, 3));  //main panel
        JPanel btnPanel = new JPanel();  //main panel
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cellPanel.add(cells[i][j] = new Cell());
            }
        }
        
        btNew = new JButton("New game");
        btNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(Temp.this, "Toàn noob, toàn gà vl :v", "Chú ý nè Toàn", JOptionPane.ERROR_MESSAGE);
            }
        });
        btnPanel.add(btNew);
        
        panel.add(cellPanel, BorderLayout.CENTER);
        panel.add(btnPanel, BorderLayout.SOUTH);
        
        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 430);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Tic tac toe");
    }
    
    public static void main(String[] args) {
        new Temp().setVisible(true);
    }
    
    
    
    ///=========inner class============
    class Cell extends JPanel {
        JLabel label;
        
        public Cell() {
            label = new JLabel();
            add(label);
            setBorder(new LineBorder(Color.GREEN, 2));
        }
    }

}
