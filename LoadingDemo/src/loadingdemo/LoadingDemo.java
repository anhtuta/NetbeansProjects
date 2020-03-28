/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loadingdemo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author AnhTu
 */
public class LoadingDemo extends JFrame {

    private LoadingScreen loadingScreen;
    private JButton btStart;
    
    public LoadingDemo() { //constructor
        setSize(500, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(300, 200);
        
        //////////edit layout
        setLayout(new BorderLayout());
        //insert stuffs into that borderlayout:
        loadingScreen = new LoadingScreen();
        add(loadingScreen, BorderLayout.CENTER);
        
        btStart = new JButton("Start");
        btStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                loadingScreen.startLoading();
                
            }
        });
        add(btStart, BorderLayout.SOUTH);
        //////////////////////
        
        setVisible(true);
        
    }
  
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(LoadingDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        new LoadingDemo();
        
    }
     
    
    private class LoadingScreen extends JPanel {
        LoadingThread loadingThread;
        int steps = 0;
        //int maxSteps = 10;
        int executingTime;
        
        @Override
        public void paint(Graphics g) {
            //g.fillRect(0, 0, this.getWidth(), this.getHeight()); //hàm this.getWidth(), this.getHeight()lấy độ rộng và độ cao tối đa của cái panel
            //khai báo như trên xong thì cái frame sẽ full hình chữ nhật vì hình này chiếm chọn cái frame
            //dù kéo cái frame HCN này cũng dãn theo, do dùng 2 hàm this.getWidth(), this.getHeight() 
            super.paint(g); //xóa cái nút bấm thừa
            g.setColor(Color.gray);
            g.fillRect(0, 20, this.getWidth(), 20);
            g.setColor(Color.red);
            g.fillRect(0, 20, (this.getWidth()/100)*steps, 20);
            
        }
        
        public void startLoading() {
            btStart.setEnabled(false);
            loadingThread = new LoadingThread(this);
            loadingThread.start();
        }
        public void stopLoading() {
            btStart.setEnabled(true);
            loadingThread.stop();
            loadingThread = null;
        }
        public void update() {
            steps++;
            System.out.println("Steps: "+steps);
            repaint();
            //nếu chỉ làm như trên thì hơi vô nghĩa vì mỗi 1 steps ta nên thực hiện việc j đó
            //chẳng hạn ví dụ này t chỉ set thời gian thực thi cho mỗi steps
//            switch(steps) {
//                case 0: executingTime = 400; break; //giả sử vậy thôi
//                case 1: executingTime = 400; break;
//                case 2: executingTime = 400; break;
//                case 3: executingTime = 400; break;
//                case 4: executingTime = 400; break;
//                case 5: executingTime = 400; break;
//                case 6: executingTime = 400; break;
//                case 7: executingTime = 400; break;
//                case 8: executingTime = 400; break;
//                case 9: executingTime = 400; break;
//                case 10: executingTime = 400; break;
//                default: steps = 0; stopLoading(); break;
//                
//            }
            if(steps > 120) {
                steps = 0;
                stopLoading();   
            }
        }
    }
    
    private class LoadingThread extends Thread { //tiến trình để vẽ cái loading
        private LoadingScreen loadingScreen;
        
        public LoadingThread(LoadingScreen ls) {
            loadingScreen = ls;
        }

        private LoadingThread() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
        public void run() { //override method run() of class Thread
            while(true) {
                loadingScreen.update();
                try {
                    //phải cho sleep nếu ko tiến trình cứ chạy mãi, rất hạy máy
                    sleep(50); //100 miniseconds, nghĩa là các tiến trình chạy cách nhau 100ms , chứ ko liên tục
                } catch (InterruptedException ex) {
                    Logger.getLogger(LoadingDemo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
