/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grouplayoutdemo;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

/**
 *
 * @author AnhTu
 */

//nếu setHorizontalGroup: nếu createParallelGroup thì các phần tử sẽ đặt song song nhau theo chiều ngang, nghĩa là xếp các phần tử từ trên xuống. 
//                        còn nếu createSequentialGroup thì các phần tử đặt lần lượt theo chiều ngang
//nếu setVerticalGroup:   nếu createParallelGroup thì các phần tử sẽ đặt song song nhau theo chiều dọc, nghĩa là xếp các phần tử từ trái qua phải.
//                        còn nếu createSequentialGroup thì các phần tử đặt lần lượt từ trên xuống

//thường thì createParallelGroup(GroupLayout.Alignment.LEADING)  //sẽ có thêm Alignment là LEADING
//còn createSequentialGroup() //ko cần Alignment
public class Example3 extends JFrame {
    JPanel panel;
    JTextField tf;
    JButton bt1, bt2;
    JCheckBox chb1, chb2, chb3, chb4;
    JLabel lb;
    
    public Example3() {
        tf = new JTextField();
        lb = new JLabel("Find what:");
        bt1 = new JButton("Find");
        bt2 = new JButton("Cancel");
        chb1 = new JCheckBox("Check box 1");
        chb2 = new JCheckBox("Check box 2");
        chb3 = new JCheckBox("Check box 3");
        chb4 = new JCheckBox("Check box 4");
        
        panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        
        //Horizontal layout:
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lb)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)  //group này chứa (tf) và (4 check box). do nó là ParallelGroup và đây đang thiết lập horizontal nên tf và 4 check box xếp song song theo chiều ngang
                    .addComponent(tf)
                    .addGroup(layout.createSequentialGroup() //chứa (4 check box)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING) //group này chứa chb1 và chb3
                            .addComponent(chb1)
                            .addComponent(chb3)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(chb2)
                            .addComponent(chb4)
                        )
                    )
                )
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)  //group cuối cùng, có 2 button
                    .addComponent(bt1, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(bt2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE) //dài = 81, theo thằng bt1
                )
                .addContainerGap(15, Short.MAX_VALUE)
            )
        );
        
        //Vertical layout:
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lb)
                    .addGroup(layout.createSequentialGroup() //group này gồn tf và 4 check box
                        .addComponent(tf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING) //group này gồn chb1 và chb2
                            .addComponent(chb1)
                            .addComponent(chb2)
                        )
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED) //hoặc thử cái này xem: .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING) //group này gồn chb3 và chb4
                            .addComponent(chb3)
                            .addComponent(chb4)
                        )
                    )
                    .addGroup(layout.createSequentialGroup() //group này gồm 2 button
                        .addComponent(bt1, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt2, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                        .addGap(200, 200, 200) //nếu ko có thì nhóm button sẽ phồng to ra  (1)
                            //đây là group cuối cùng nên phải addGap cho nó với cái panel
                    )
                )
            //.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE) //có thể có hoặc ko vì ta đã thiết lập kích thước frame rồi (2)
            //thử bỏ cả dòng (1) và (2) đi sẽ thú vị đấy!
            )
        );
        
        add(panel);
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 200);
    }
    
    public static void main(String[] args) {
        new Example3().setVisible(true);
    }
}
