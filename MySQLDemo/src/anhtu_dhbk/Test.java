/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhtu_dhbk;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author AnhTu
 */
public class Test {
    public static void main(String[] args) {
        DatabaseManagement dm = new DatabaseManagement();
        Connection conn = dm.connect();
        ResultSet rs = dm.getData();
        dm.insertRecord(new Student(1005, "anhtu", "03i2ii32"));
        dm.showData(rs);
        
    }
}
