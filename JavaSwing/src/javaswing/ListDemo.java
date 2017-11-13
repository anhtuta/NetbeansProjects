/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaswing;

/**
 *
 * @author AnhTu
 */
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class ListDemo {
    
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;

   public ListDemo(){
      prepareGUI();
   }

   public static void main(String[] args){
      ListDemo  swingControlDemo = new ListDemo();      
      swingControlDemo.showListDemo();
   }

   private void prepareGUI(){
      mainFrame = new JFrame("Vi du Java Swing");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(3, 1));
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      headerLabel = new JLabel("", JLabel.CENTER);        
      statusLabel = new JLabel("",JLabel.CENTER);    

      statusLabel.setSize(350,100);

      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }

   private void showListDemo(){                                       

      headerLabel.setText("Control in action: JList"); 

      final DefaultListModel fruitsName = new DefaultListModel();

      fruitsName.addElement("Apple");
      fruitsName.addElement("Grapes");
      fruitsName.addElement("Mango");
      fruitsName.addElement("Peer");

      final JList fruitList = new JList(fruitsName);
      fruitList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      fruitList.setSelectedIndex(0);
      fruitList.setVisibleRowCount(3);        

      JScrollPane fruitListScrollPane = new JScrollPane(fruitList);    

      final DefaultListModel vegName = new DefaultListModel();

      vegName.addElement("Lady Finger");
      vegName.addElement("Onion");
      vegName.addElement("Potato");
      vegName.addElement("Tomato");

      final JList vegList = new JList(vegName);
      vegList.setSelectionMode(
         ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
      vegList.setSelectedIndex(0);
      vegList.setVisibleRowCount(3);        

      JScrollPane vegListScrollPane = new JScrollPane(vegList);       

      JButton showButton = new JButton("Show");

      showButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) { 
            String data = "";
            if (fruitList.getSelectedIndex() != -1) {                     
               data = "Fruits Selected: " + fruitList.getSelectedValue(); 
               statusLabel.setText(data);
            }
            if(vegList.getSelectedIndex() != -1){
               data += " Vegetables selected: ";
               for(Object vegetable:vegList.getSelectedValues()){
                  data += vegetable + " ";
               }
            }
            statusLabel.setText(data);
         }
      }); 

      controlPanel.add(fruitListScrollPane);    
      controlPanel.add(vegListScrollPane);    
      controlPanel.add(showButton);    
	  
      mainFrame.setVisible(true);             
   }
}