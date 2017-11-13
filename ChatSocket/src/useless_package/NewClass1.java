/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package useless_package;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author AnhTu
 */
public class NewClass1 extends JFrame {
    public NewClass1() {
        JPanel mainPn = new JPanel(new BorderLayout());
        
        JPanel panel = new JPanel();
        panel.add(new JButton("Demo button"));

        JPanel pn = new JPanel();
        pn.setBackground(new java.awt.Color(51, 153, 255));
        Graphics g = pn.getGraphics();      //java.lang.NullPointerException, phải hiển thị cái frame trước mới dùng đc hàm này, do đó hàm này có thể đặt trong sự kiện của 1 btn, khi ấn btn thì gọi hàm này
        g.fillOval(10, 10, 10, 10);
        
        mainPn.add(panel, BorderLayout.NORTH);
        mainPn.add(pn, BorderLayout.CENTER);
        
        this.add(mainPn);
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        new NewClass1().setVisible(true);
        try {
            InetAddress inet = InetAddress.getLocalHost();
            System.out.println("my IP = "+inet.getHostAddress());
        } catch (UnknownHostException ex) {
            Logger.getLogger(NewClass1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
