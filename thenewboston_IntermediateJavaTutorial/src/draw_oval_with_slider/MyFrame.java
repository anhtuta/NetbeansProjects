/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package draw_oval_with_slider;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author AnhTu
 */
public class MyFrame extends JFrame {
    
    private JSlider slider;
    private MyPanel myPanel;
    
    public MyFrame() {
        super("The title");
        myPanel = new MyPanel();
        myPanel.setBackground(Color.ORANGE);
        
        slider = new JSlider(SwingConstants.HORIZONTAL, 0, 200, 10); //min = 0, max = 200
        slider.setMajorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                myPanel.setD(slider.getValue());
            }
        });
        
        add(myPanel, BorderLayout.NORTH);
        add(slider, BorderLayout.SOUTH);
    }
}
