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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

//chú ý: hàm paint() và repaint() cũng dùng cho Frame như Applet, vì bọn nó đều là java AWT mà!
/* Display the colour chosen by the user 
   (Adapted from Savitch) */
public class ButtonDemo extends Frame implements ActionListener {

    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;
    public static final int X = 20;
    public static final int Y = 20;

    private String theText = "Press a button…";
    
    public ButtonDemo() {
        setSize(WIDTH, HEIGHT);
        setLocation(X, Y);
        addWindowListener(new WindowDestroyer());
        setTitle("Button Demonstration");
        setBackground(Color.blue);

        setLayout(new FlowLayout());
        Button stopButton = new Button("Red");
        stopButton.addActionListener(this);
        add(stopButton);

        Button goButton = new Button("Green");
        goButton.addActionListener(this);
        add(goButton);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ButtonDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ButtonDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ButtonDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ButtonDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        ButtonDemo buttonGui = new ButtonDemo();
        buttonGui.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(theText, 75, 100);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Red":
                setBackground(Color.red);
                theText = "STOP";
                break;
            case "Green":
                setBackground(Color.green);
                theText = "GO";
                break;
            default:
                theText = "Error in button interface.";
                break;
        }
        repaint(); //force color and text change
    }
}
