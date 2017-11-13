/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example3_5;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author AnhTu
 */
public class RegistrationClient extends JApplet implements ActionListener { //nhận các thông tin đký của sv và gửi về server

    private static JTextArea taLog;
    JButton btRegister=new JButton("Register");
    boolean isStandalone=false;
    JTextField tfName=new JTextField(32);
    JTextField tfStreet=new JTextField(32);
    JTextField tfCity=new JTextField(20);
    Container container;
    JPanel p;

    @Override
    public void init() {
        makePanel();
        container=getContentPane();
        container.add(p, BorderLayout.CENTER);
        container.add(btRegister, BorderLayout.SOUTH);
        
        btRegister.addActionListener(this);
    }
    
    public void makePanel() {
        p=new JPanel(new BorderLayout());
        JPanel p1=new JPanel();
        p1.setLayout(new GridLayout(3, 1));
        p1.add(new JLabel("Name"));
        p1.add(new JLabel("Street"));
        p1.add(new JLabel("City"));
        
        JPanel p2=new JPanel();
        p2.setLayout(new GridLayout(3, 1));
        p2.add(tfName);
        p2.add(tfStreet);
        p2.add(tfCity);
        
        p.add(p1, BorderLayout.WEST);
        p.add(p2, BorderLayout.EAST);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==btRegister) {
            try {
                Socket connectToServer;
                if(isStandalone) connectToServer=new Socket("localhost", 8000);
                else connectToServer=new Socket(getCodeBase().getHost(), 8000);
                
                //lập dòng output để gửi cho server:
                PrintWriter pwToServer=new PrintWriter(connectToServer.getOutputStream(), true);
                
                //đọc thông tin từ các trường của client:
                Student st=new Student(tfName.getText().trim(), tfStreet.getText().trim(), tfCity.getText().trim());
                
                //gửi các thông tin đó cho server:
                pwToServer.println(st.getName());
                pwToServer.println(st.getStreet());
                pwToServer.println(st.getCity());
                
            } catch (IOException ex) {
                Logger.getLogger(RegistrationClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void main(String[] args) {
        JFrame frame=new JFrame("HỆ THỐNG ĐĂNG KÝ HỌC TẬP");
        RegistrationClient appletClient=new RegistrationClient();
        appletClient.isStandalone=true;
        
        frame.getContentPane().add(appletClient, BorderLayout.CENTER);
        appletClient.init();
        appletClient.start();
        
        frame.pack();
        frame.setVisible(true);
    }
    
}
