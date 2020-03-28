/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package create_a_simple_web_browser;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/**
 *
 * @author AnhTu
 */
public class ReadFile extends JFrame {
    private JTextField addressBar;
    private JEditorPane display;
    
    public ReadFile() {
        super("Anhtu's Browser");
        addressBar = new JTextField("enter a URL host...");
        addressBar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                loadCrap(ae.getActionCommand()); //read an HTML file and display on the screen
            }
        });
        addressBar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                addressBar.setText("http://");
            }
        });
        
        add(addressBar, BorderLayout.NORTH);
        
        display=new JEditorPane();
        display.setEditable(false);
        display.addHyperlinkListener(new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent he) {
                if(he.getEventType() == HyperlinkEvent.EventType.ACTIVATED) { //if click to a link
                    loadCrap(he.getURL().toString());
                }
            }
        });
        add(new JScrollPane(display), BorderLayout.CENTER);
        setSize(500, 300);
        setVisible(true);
    }
    
    
    private void loadCrap(String userText) { //userText = URL which website you wanna go to
        
        try {
            display.setPage(userText); //lấy URL và hiển thị nó lên window
            addressBar.setText(userText);
        } catch (IOException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
