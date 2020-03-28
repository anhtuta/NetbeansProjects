/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author AnhTu
 */

//chú ý: chỉ số của combobox cũng bắt đầu = 0

public class Clock extends JFrame implements ActionListener { //lớp Clock thừa kế từ lớp JFrame và thừa kế từ giao diện ActionListener
    private JTextField tfTime;
    private JButton btStart, btStop;
    private long beginTime;
    private TimerThread thread;
    private JComboBox cbTime;
    private long timeChoice[] = {10000,60000,300000,600000,900000,1200000,1800000}; // lan luot la:  10 giây, 1',5',10',15',20',30'
    private long remindTime;
    
    //////////////////getter and setter//////////////////////////////////////////////////////
    public long getTfTime() { //lấy giá trị trong text field tfTime, giá trị này là số mili giây
        return Long.valueOf(tfTime.getText());
    }  
    public void setTfTime(long time) { //đặt giá trị cho tfTime
        tfTime.setText(String.valueOf(time));
    }
    ////////////////////////////////////////////////////////////////////////
    
    public Clock() {
        super("Clock"); //chỉ là đặt tên cho jframe
        setSize(300, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initGUI(); //tạo frame
        remindTime = 60000; //mặc định là 1 phút
        
    }
    
    private void initGUI() {    //tạo 1 frame   
        //thêm 1 textfield, 2 button
        tfTime = new JTextField(14); //độ rộng của textfield là 20 kí tự
        tfTime.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        tfTime.setFocusable(false);
        tfTime.setFont(tfTime.getFont().deriveFont(30.0f)); //kích thươc font chữ
        tfTime.setBackground(Color.yellow);
        add(tfTime);
        
        btStart = new JButton("Start");
        btStart.addActionListener(this);
        add(btStart);
        
        btStop = new JButton("Stop");
        btStop.addActionListener(this);
        add(btStop);
        
        //tạo 1 combobox để chọn time để chạy
        cbTime = new JComboBox();
        cbTime.addItem("10 giây");
        cbTime.addItem("1 minute");
        cbTime.addItem("5 minutes");
        cbTime.addItem("10 minutes");
        cbTime.addItem("15 minutes");
        cbTime.addItem("20 minutes");
        cbTime.addItem("30 minutes");
        cbTime.addActionListener(this);
        add(cbTime);
        
        
        //set bố cục cho jframe: có các cách khác nhau như: flowlayout, borderlayout, null,...
        setLayout(new FlowLayout());
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btStart) {
            startThread();
        }
        if(e.getSource() == btStop) {
            stopThread();
        }
        if(e.getSource() == cbTime) {
            int choice = cbTime.getSelectedIndex();
            remindTime = timeChoice[choice]; //giả sử chọn item thứ 2 trong combobox thì remindTime = timeChoice[2] = 5 phút
        }
    
    }
    
    private void startThread() {
        if(thread != null) stopThread();
        thread = new TimerThread();
        thread.start(); //nó sẽ gọi hàm run() trong class TimerThread
    }
    
    private void stopThread() {
        if(thread != null) { //chỉ khi nào khác null mới xóa đc, nếu ko sẽ có lỗi
            thread.stop();
            thread = null;
            printTimeToScreen(0);
        }
    }
   private void printTimeToScreen(long time) { //time có kiểu số nguyên, đơn vị mini giây, ta phải chuyển nó sang giờ. chú ý mỗi giây có 1000 mini giây
       int hour, minute, second;
       hour = (int) (time/(1000*3600)); //1 giờ có 3600 giây
       minute = (int) (time%(1000*3600)/(60*1000));
       second = (int) (time%(1000*60)/1000);
       
       String text = (hour>9 ? hour:("0"+hour)) + ":" + (minute>9? minute:"0"+minute) + ":" + (second>9? second:"0"+second);
       tfTime.setText(text);
   } 
    
    
    public static void main(String[] args) {
        Clock f = new Clock();
        f.setVisible(true);
    }
    
    private class TimerThread extends Thread {
        public void run() {
            beginTime = System.currentTimeMillis();
            while (true) {
                long deltaTime = System.currentTimeMillis() - beginTime;
                //tfTime.setText(String.valueOf(deltaTime)); //hiển thị thời gian lên tfTime
                printTimeToScreen(deltaTime);
                if(deltaTime > remindTime) {
                    JOptionPane.showMessageDialog(null, "Hết cmn giờ roài!", "Chú ý!", JOptionPane.YES_NO_OPTION);
                    stopThread();
                }
                try {
                    sleep(20); //nếu ko có hàm này thì java sẽ chạy liên tục, có khi chiếm hết CPU, do đó tiêu tốn tài nguyên, do đó cần có time để ngủ
                } catch (InterruptedException ex) {
                    Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
}

}