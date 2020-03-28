/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 *
 * @author AnhTu
 */
public class ProgressBarDemo extends JFrame {
    JProgressBar pb;
    JButton bt;
    
    public ProgressBarDemo() {
        super("Example for JProgressBar");
        
        JPanel p = new JPanel();
        pb = new JProgressBar(0, 100);
        bt = new JButton("Run ProgressBar");
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                btActionPerformed(ae);  //làm ntnay thì giống phần kéo thả, và t ko phải implements
            }
        });
        
        p.add(pb);
        p.add(bt);
        
        add(p);
        setSize(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public void btActionPerformed(ActionEvent ae) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) { //do ta khởi tạo pb = new JProgressBar(0, 100); thì phải cho nó chạy từ 0 đến 100 mới hết thanh progress bar đc
                    pb.setValue(i);
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ProgressBarDemo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if(pb.getValue() == 100) {
                        JOptionPane.showMessageDialog(null, "Đã xong!");
                    }
                }
            }
        });
        
        thread.start();
    }
    
    public static void main(String[] args) {
        new ProgressBarDemo().setVisible(true);
    }
}
