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

/* End the program and close the Frame if the user click the close window button. */
public class WindowDestroyer extends WindowAdapter {

    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}
