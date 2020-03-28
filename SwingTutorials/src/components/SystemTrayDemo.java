/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author AnhTu
 */
public class SystemTrayDemo {
    public static void main(String[] args) {
        if(!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }
        SystemTray st = SystemTray.getSystemTray();
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image image = tk.getImage("D:/data.JPG");
        
        
        PopupMenu menu = new PopupMenu();
        
        MenuItem action = new MenuItem("Action");
        action.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(null, "Action menu item");
            }
        });
        menu.add(action);
        MenuItem close = new MenuItem("Close");
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        menu.add(close);
        
        TrayIcon ti = new TrayIcon(image, "SystemTray demo", menu);
        ti.setImageAutoSize(true);
        try {
            st.add(ti);
        } catch (AWTException ex) {
            Logger.getLogger(SystemTrayDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
