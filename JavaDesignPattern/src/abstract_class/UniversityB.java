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
public class UniversityB extends University {

    @Override
    public String caculatePoint(int point) {
        return String.valueOf(point*1.0/10);
    }
    
}
