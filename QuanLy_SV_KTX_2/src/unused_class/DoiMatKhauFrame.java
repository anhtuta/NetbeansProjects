/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unused_class;

import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

/**
 *
 * @author AnhTu
 */
public class DoiMatKhauFrame extends JFrame {
    private JPanel panel;
    JLabel lbDoiMK, lbMKCu, lbMKMoi, lbNhapLaiMK;
    JTextField tfMKCu, tfMKMoi, tfNhapLaiMK;
    JButton btOK, btCancel;
    
    
    public DoiMatKhauFrame() {
        lbDoiMK = new JLabel("Đổi mật khẩu");
        lbDoiMK.setFont(new Font("Tahoma", 0, 18));
        lbMKCu = new JLabel("Mật khẩu cũ");
        lbMKMoi = new JLabel("Mật khẩu mới");
        lbNhapLaiMK = new JLabel("Nhập lại mật khẩu");
        
        tfMKCu = new JTextField();
        tfMKMoi = new JTextField();
        tfNhapLaiMK = new JTextField();
        
        
        btOK = new JButton("OK");
        btCancel = new JButton("Cancel");
        
        panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(lbDoiMK)
            )
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lbMKCu, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(lbMKMoi, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNhapLaiMK, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(tfMKCu, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfMKMoi, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNhapLaiMK, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                )
                
                .addContainerGap(82, Short.MAX_VALUE)
            )
            .addGroup(layout.createSequentialGroup()
                    .addGap(110, 110, 110)
                    .addComponent(btOK)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btCancel)
                )
        );
        
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addGap(55, 55, 55)
            .addComponent(lbDoiMK)
            .addGap(27, 27, 27)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(lbMKCu)
                .addComponent(tfMKCu)
            )
            .addGap(5, 5, 5)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(lbMKMoi)
                .addComponent(tfMKMoi)
            )
            .addGap(5, 5, 5)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(lbNhapLaiMK)
                .addComponent(tfNhapLaiMK)
            )
            .addGap(38, 38, 38)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(btOK)
                .addComponent(btCancel)
            )
            .addContainerGap(35, Short.MAX_VALUE)
            )
        );
        
        
        
        add(panel);
        setSize(400, 300);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        new DoiMatKhauFrame().setVisible(true);
    }
    
}
