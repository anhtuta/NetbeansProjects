/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layouts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author AnhTu
 */
public class BoxLayoutDemo extends JFrame {
    private JPanel mainPanel;
    private BoxLayout boxLayout;
    private boolean axis = true;
 
    public BoxLayoutDemo() {
        createJFrame();
    }
 
    private void createJFrame() {
        // create JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        // add content
        mainPanel = createMainPanel();
        add(mainPanel);
        // display
        setLocationRelativeTo(null);
        setVisible(true);
    }
 
    private JPanel createMainPanel() {
        // create panel with BoxLayout
        JPanel panel = new JPanel();
        boxLayout = new BoxLayout(panel, BoxLayout.X_AXIS);
        panel.setLayout(boxLayout);
        // add button change to main panel
        JButton btnChange = new JButton("Change");
        btnChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                change();
            }
        });
        panel.add(btnChange);
        // add list button to main panel
        for (int i = 0; i < 5; i++) {
            panel.add(new JButton("Button" + i));
        }
        return panel;
    }
 
    // change axis when click button change
    private void change() {
        int ax = axis ? BoxLayout.Y_AXIS : BoxLayout.X_AXIS;
        // reset boxLayout
        boxLayout = new BoxLayout(mainPanel, ax);
        // set boxLayout to mainPanel
        boxLayout.layoutContainer(mainPanel);
        axis = !axis;
    }
 
    public static void main(String[] args) {
        new BoxLayoutDemo();
    }
}
