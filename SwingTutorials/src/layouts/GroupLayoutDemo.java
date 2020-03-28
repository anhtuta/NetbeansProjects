/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layouts;

/**
 *
 * @author VietJack.com
 */
//Lớp GroupLayout này có một contructor là GroupLayout(Container host) để tạo một GroupLayout cho container đã cho.
//
//Lớp này kế thừa các phương thức từ các lớp sau:
//java.lang.Object
//
//Lớp GroupLayout có các trường sau:
//static int DEFAULT_SIZE: Chỉ kích cỡ từ đó các thành phần hoặc khoảng cách gap nên được sử dụng cho một giá trị dãy cụ thể.
//static int PREFERRED_SIZE: Chỉ kích cỡ được ưu tiên từ đó các thành phần hoặc khoảng cách gap nên được sử dụng cho một giá trị dãy cụ thể.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GroupLayoutDemo {

    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    public GroupLayoutDemo() {
        prepareGUI();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Vi du Java Swing");
        mainFrame.setSize(400, 400);
        mainFrame.setLayout(new GridLayout(3, 1));

        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);

        statusLabel.setSize(350, 100);
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        //mainFrame.setVisible(true);
    }

    private void showGroupLayoutDemo() {
        headerLabel.setText("Layout in action: GroupLayout");

        JPanel panel = new JPanel();
        // panel.setBackground(Color.darkGray);
        panel.setSize(200, 200);
        GroupLayout layout = new GroupLayout(panel);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        JButton btn1 = new JButton("Button 1");
        JButton btn2 = new JButton("Button 2");
        JButton btn3 = new JButton("Button 3");

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addComponent(btn1)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(
                                GroupLayout.Alignment.LEADING)
                                .addComponent(btn2)
                                .addComponent(btn3)
                        )
                )
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(btn1)
                .addComponent(btn2)
                .addComponent(btn3)
        );
        panel.setLayout(layout);
        controlPanel.add(panel);

        mainFrame.setVisible(true);
    }
    
    
    public static void main(String[] args) {
        GroupLayoutDemo swingLayoutDemo = new GroupLayoutDemo();
        swingLayoutDemo.showGroupLayoutDemo();
    }

}
