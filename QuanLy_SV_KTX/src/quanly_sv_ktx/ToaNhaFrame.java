/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanly_sv_ktx;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AnhTu
 */

public class ToaNhaFrame extends JFrame {
    private MyConnect myConnect = new MyConnect();
    private Connection conn = myConnect.connect();
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    
    private String [] columnName = {"Tên tòa nhà", "Số lượng chỗ", "Điện thoại Admin"};
    
    private JTable table;
    private JLabel lbTenCuaTable;
    
    public ToaNhaFrame() {
        add(panelChinhCuaFrame());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        showToaNha();
        setLocation(100, 100);
        setVisible(true);
        pack();
    }

    public JPanel panelChinhCuaFrame() {
        JPanel panel = new JPanel(new BorderLayout()); //cái panel chính
        
        JPanel panelLabel = new JPanel();
        lbTenCuaTable = new JLabel("DANH SÁCH CÁC TÒA NHÀ CỦA KÝ TÚC XÁ");
        lbTenCuaTable.setFont(new java.awt.Font("Tahoma", 1, 18));
        panelLabel.add(lbTenCuaTable);
        panel.add(panelLabel, BorderLayout.PAGE_START);
        
        JPanel panelTable = new JPanel();
        table = new JTable();
        panelTable.add(new JScrollPane(table));
        panel.add(panelTable);
        
        return panel;
    }
    
    public ResultSet getDataToaNha() {
        try {
            pst = conn.prepareStatement("SELECT * FROM toanha");
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(PhongTroFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public void showToaNha() {
        rs = getDataToaNha();
        
        DefaultTableModel model = new DefaultTableModel();
        
        ResultSetMetaData rsMD;
        try {
            rsMD = rs.getMetaData();
            int columnNumber = rsMD.getColumnCount(); //lấy số cột
            String [] arr = new String[columnNumber];
            for (int i = 0; i < columnNumber; i++) {
                arr[i] = columnName[i]; //tiêu đề các cột
            }
            model.setColumnIdentifiers(arr); //sau đó add các tên vào 1 model
            
            //thêm tất cả các hàng vào model
            rs.first(); //rs = cái hàng đầu tiên
            while(rs.next()) { //do đã lấy cái hàng đầu tiên rồi nên bảng này chỉ hiển thị từ các hàng thứ 2 trở đi
                //nghĩa là vòng lặp đầu tiên rs = cái hàng thứ 2 luôn
                for (int i = 0; i < columnNumber; i++) {
                    arr[i] = rs.getString(i+1);
                }
                model.addRow(arr);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ToaNhaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        table.setModel(model);
            
    }
    public static void main(String[] args) {
        ToaNhaFrame tnf = new ToaNhaFrame();
    }
}
