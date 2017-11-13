/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock_group;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Clock;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author AnhTu
 */
public class ClockPanel extends JPanel implements ActionListener {

    JLabel lbT;
    protected Clock clock = null;
    JButton btResume, btSus;
    
    public ClockPanel() {
        JPanel bt = new JPanel();
        bt.add(btResume = new JButton("Resume"));
        bt.add(btSus = new JButton("Suspend"));
        
        setLayout(new BorderLayout());
        //add(clock = new Clock());
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
