package threaddemostp;

import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
 
/** Illustrate Unresponsive UI problem caused by "busy" Event-Dispatching Thread */
public class UnresponsiveUI extends JFrame {
   private boolean stop = false;  // start or stop the counter
   private JTextField tfCount;
   private int count = 1;
 
   /** Constructor to setup the GUI components */
   public UnresponsiveUI() {
      Container cp = this.getContentPane();
      cp.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
      cp.add(new JLabel("Counter"));
      tfCount = new JTextField(count + "", 10);
      tfCount.setEditable(false);
      cp.add(tfCount);
 
      JButton btnStart = new JButton("Start Counting");
      cp.add(btnStart);
      btnStart.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
            stop = false;
            
            //tạo 1 thread để thực hiện đếm
            Thread t = new Thread() {
                public void run() {
                    for (int i = 0; i < 100000; ++i) {
                        if (stop) break; 
                        tfCount.setText(count + "");
                        ++count;
                        try {
                            sleep(10);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(UnresponsiveUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            };
            t.start(); //gọi hàm để chạy thread
         }
      });
      
      JButton btnStop = new JButton("Stop Counting");
      cp.add(btnStop);
      btnStop.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
            stop = true;  // set the stop flag
         }
      });
 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setTitle("Counter");
      setSize(300, 120);
      setVisible(true);
   }
 
   /** The entry main method */
   public static void main(String[] args) {
      // Run GUI codes in Event-Dispatching thread for thread safety
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            new UnresponsiveUI();  // Let the constructor do the job
         }
      });
   }
}