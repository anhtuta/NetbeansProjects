/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ball3;

import javax.swing.JOptionPane;

/**
 *
 * @author AnhTu
 */
public class ShowMessageThread extends Thread {
    @Override
    public void run() {
        //JOptionPane.showMessageDialog(null, "Gotcha!", "Hey! you cool!", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("Bắt được bóng");
    }
}
