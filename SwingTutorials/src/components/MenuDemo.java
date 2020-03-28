/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_F;
import static java.awt.event.KeyEvent.VK_N;
import static java.awt.event.KeyEvent.VK_O;
import static java.awt.event.KeyEvent.VK_S;
import static java.awt.event.KeyEvent.VK_X;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author AnhTu
 */
public class MenuDemo implements ActionListener {
    private JMenuItem mninew,mniopen,mnisave,mniexit;
    public MenuDemo() {
        ////////tạo 1 frame mới
        JFrame frame = new JFrame("Menu Demo");              
        frame.setSize(300, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ////////tạo 1 menu mới
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        
        //thêm các thuộc tính vào menu ====================
        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);  //tạo phím tắt alt+f để mở menu file
        menubar.add(file);
        
        ///thêm item vào menu bar file////////////
        mninew = new JMenuItem("New");  //mninew = MenuItem new
        mninew.setMnemonic(VK_N);
        mninew.addActionListener(this);
        file.add(mninew);
        
        mniopen = new JMenuItem("Open");
        mniopen.setMnemonic(VK_O);
        mniopen.addActionListener(this);
        file.add(mniopen);
        
        mnisave = new JMenuItem("Save");
        mnisave.setMnemonic(VK_S);
        mnisave.addActionListener(this);
        file.add(mnisave);
        
        file.addSeparator(); //thêm 1 đường kẻ ngang sau đó mới thêm item exit 
        mniexit = new JMenuItem("Exit");
        mniexit.setMnemonic(VK_X);
        mniexit.addActionListener(this);
        file.add(mniexit);
        /////////////////////////////////////////////
        
        
        JMenu edit = new JMenu("Edit");
        edit.setMnemonic(KeyEvent.VK_E);
        menubar.add(edit);
        
        JMenu find = new JMenu("Find");
        find.setMnemonic(VK_F);
        edit.add(find);
        
        JMenuItem mniup = new JMenuItem("Up");
        find.add(mniup);
        JMenuItem mnidown = new JMenuItem("Down");
        find.add(mnidown);  //mnidown = menu item down
        //=====================================
 
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //JMenuItem item = (JMenuItem)ae.getSource(); ko cần nữa, gộp luôn 
        if((JMenuItem)ae.getSource() == mninew) JOptionPane.showMessageDialog(null, "New is clicked");
        else if((JMenuItem)ae.getSource() ==mniopen) JOptionPane.showMessageDialog(null, "Open is clickek");
        else if((JMenuItem)ae.getSource() ==mniexit) System.exit(0);
    }
    
    public static void main(String[] args) {
        new MenuDemo();
    }

}
