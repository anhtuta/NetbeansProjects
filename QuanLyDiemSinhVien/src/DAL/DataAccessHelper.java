package DAL;

import MeThodShow.MyMethod;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DataAccessHelper {

    protected Connection cnn;
    //netstat -a -P TCP
    String Hostname = "localhost";
    String port = "1433";
    String DBName = "QuanLyDiemSinhVien";
    String User = "sa";
    String Password = "Doanhnhan";
    String Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String URL = "jdbc:sqlserver://" + Hostname + ":" + port + ";database=" + DBName;

    MyMethod temp = new MyMethod();

    public void getConnect() {
        try {
            Class.forName(Driver);
            cnn = DriverManager.getConnection(URL, User, Password);
        } catch (ClassNotFoundException ex) {
            temp.showMessegaWa("Error in Connect : " + ex.toString());
        } catch (SQLException ex) {
            temp.showMessegaWa("Error in Connect : " + ex.toString());
        }
    }

    public void getClose() {
        try {
            cnn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
