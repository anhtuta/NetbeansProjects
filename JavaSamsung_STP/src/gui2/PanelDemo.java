/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui2;

/**
 *
 * @author AnhTu
 */
import java.awt.*;
import java.awt.event.*;

/* put buttons in a panel (Adapted from Savitch) */
public class PanelDemo extends Frame implements ActionListener {

    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;
    public static final int X = 20;
    public static final int Y = 20;

    private String theText = "Press a button …";

    public static void main(String[] args) {
        PanelDemo guiWithPanel = new PanelDemo();
        guiWithPanel.setVisible(true);
    }

    public PanelDemo() {
        setTitle("Panel Demonstration");
        setSize(WIDTH, HEIGHT);
        setLocation(X, Y);
        setBackground(Color.blue);
        addWindowListener(new WindowDestroyer());
        
        Panel buttonPanel = new Panel();
        buttonPanel.setBackground(Color.white);
        buttonPanel.setLayout(new FlowLayout());
        Button stopButton = new Button("Red");
        stopButton.setBackground(Color.red);
        stopButton.addActionListener(this);
        buttonPanel.add(stopButton);

        Button goButton = new Button("Green");
        goButton.setBackground(Color.green);
        goButton.addActionListener(this);
        buttonPanel.add(goButton);

        setLayout(new BorderLayout());
        add(buttonPanel, "South");
    }

    public void paint(Graphics g) {
        g.drawString(theText, 75, 100);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Red")) {
            setBackground(Color.red);
            theText = "STOP";
        } else if (e.getActionCommand().equals("Green")) {
            setBackground(Color.green);
            theText = "GO";
        } else {
            theText = "Error in button interface.";
        }

        repaint(); //force colour and text change
    }
}
