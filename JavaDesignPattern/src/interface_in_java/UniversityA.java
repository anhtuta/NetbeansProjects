/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interface_in_java;

/**
 *
 * @author AnhTu
 */
public class UniversityA implements University {

    @Override
    public String caculatePoint(int p) {
        if(p > 85) return "A";
        else if(p>70) return "B";
        else if(p>55) return "C";
        else return "D";
    }
    
}
