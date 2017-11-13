/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstract_class;

import interface_in_java.*;

/**
 *
 * @author AnhTu
 */
public abstract class University {
    public void displayNote() {
        System.out.println("This student is studying at an university");
    }
    public abstract String caculatePoint(int point);
}
