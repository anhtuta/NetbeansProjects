/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bounceball;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author AnhTu
 */
public class BounceFrame extends JFrame {
    JPanel panel;
    JPanel playPanel = new JPanel();
    JPanel btPanel = new JPanel();
        
    public BounceFrame() {
        panel = new JPanel(new BorderLayout());
        playPanel = new JPanel();
        btPanel = new JPanel();
        
        JButton btBlue = new JButton("Blue ball");
        JButton btRed = new JButton("Red ball");
        btBlue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for (int i = 0; i < 5; i++) {
                    Ball b = new Ball(playPanel, Color.blue);  //thiết lập panel chứa b là playPanel
                    b.setPriority(Thread.NORM_PRIORITY - 3);
                    b.start();
                }
            }
        });
        
        btRed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for (int i = 0; i < 5; i++) {
                    Ball b = new Ball(playPanel, Color.red);
                    b.setPriority(Thread.NORM_PRIORITY + 3);
                    b.start();
                }
            }
        });
        
        btPanel.add(btBlue);
        btPanel.add(btRed);
        
        panel.add(playPanel, BorderLayout.CENTER);
        panel.add(btPanel, BorderLayout.SOUTH);
        
        add(panel);
        setSize(300, 200);
        setTitle("Bong chuyen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        new BounceFrame().setVisible(true);
    }
    
}
