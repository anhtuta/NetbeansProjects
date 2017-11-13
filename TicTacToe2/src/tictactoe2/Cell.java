///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package tictactoe2;
//
//import java.awt.BasicStroke;
//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.border.Border;
//import javax.swing.border.LineBorder;
//
///**
// *
// * @author AnhTu
// */
//public class Cell extends JPanel {
//
//    public char value;
//    final int padding = 10;
//    boolean isClicked = false;
//    static boolean isXTurn = true;
//    static int clickedTime = 0;
//
//    public Cell() {
//        value = ' ';
//        isClicked = false;
//        setBorder(new LineBorder(Color.GREEN, 2));
//        
//        addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent me) {
//                super.mouseClicked(me); //To change body of generated methods, choose Tools | Templates.
//                
//                if (!isClicked) {  //nếu ô chưa đc click thì mới vẽ, nếu click rồi thì ko vẽ nữa
//                    clickedTime++;
//                    isClicked = true;
//                    Graphics2D g = (Graphics2D) getGraphics();
//                    g.setStroke(new BasicStroke(5.0f));
//                    if (isXTurn) {  //draw X
//                        value = 'x';
//                        System.out.println("x clicked");
//                        g.setColor(Color.BLUE);
//                        g.drawLine(padding, padding, getWidth() - padding, getHeight() - padding);
//                        g.drawLine(getWidth() - padding, padding, padding, getHeight() - padding);
//                    } else {  //draw O: if (value == 'o')
//                        value = 'o';
//                        System.out.println("o clicked");
//                        g.setColor(Color.RED);
//                        g.drawOval(padding, padding, getWidth() - 2 * padding, getHeight() - 2 * padding);
//                    }
//                    isXTurn = !isXTurn;
//                    
//                }
//            }
//        });
//    }
//    
//    
//    public void clear() {
//        repaint();
//        value = ' ';
//        isClicked = false;
//        clickedTime = 0;
//        isXTurn = true;
//    }
//}
