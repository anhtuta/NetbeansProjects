/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package html_demo;

import java.applet.AppletContext;
import java.awt.BorderLayout;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author AnhTu
 */

//NOTE: YOU NEED TO UPLOAD .HTML AND .CLASS FILES TO RUN THIS PROJECT. I'M SO STUPID. I DONT KNOW HOW TO DO THIS!
public class AnhtusSites extends JApplet {
    private HashMap<String, URL> websiteInfo;
    private ArrayList<String> titles;
    private JList mainList;
    
    @Override
    public void init() {
        websiteInfo = new HashMap<String, URL>();
        titles = new ArrayList<>();
        
        grabHTMLInfo();
        add(new JLabel("What website do you want to visit?"), BorderLayout.NORTH);
        
        mainList = new JList(titles.toArray());
        
        mainList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                Object ob = mainList.getSelectedValue();
                URL newDocument = websiteInfo.get(ob);
                AppletContext browser = getAppletContext();
                browser.showDocument(newDocument);
                
            }
        });
    }
    
    public void grabHTMLInfo() {
        String title;
        String address;
        URL url;
        int counter = 0;
        title = getParameter("title"+counter); //ví dụ: title0, title1
        
        while(title != null) {
            address = getParameter("address"+counter);
            try {
                url = new URL(address);
                websiteInfo.put(title, url);
                titles.add(title);
            } catch (MalformedURLException ex) {
                Logger.getLogger(AnhtusSites.class.getName()).log(Level.SEVERE, null, ex);
            }
            ++counter;
            title = getParameter("title"+counter);
        }
        
    }
    
    
}
