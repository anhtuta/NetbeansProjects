/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_structures;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author AnhTu
 */
public class EnumerationTester {
    public static void main(String[] args) {
        Enumeration days;
        Vector dayNames = new Vector();
        dayNames.add("Monday");
        dayNames.add("Tuesday");
        dayNames.add("Wednesday");
        dayNames.add("Thursday");
        dayNames.add("Friday");
        dayNames.add("Saturday");
        dayNames.add("Sunday");
        
        days=dayNames.elements();
        
        while(days.hasMoreElements()) {
            System.out.println(days.nextElement());
        }
    }
}
