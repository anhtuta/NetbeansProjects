/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe2;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author AnhTu
 */
public class TicTacToe2 extends JFrame {

    JButton btNew;
    Cell [][] cells = new Cell[3][3];
    static boolean isDraw = true;
    static char winner = ' ';
    
    static boolean isXTurn = true;
    static int clickedTime = 0;
    
    public TicTacToe2() {
        JPanel panel = new JPanel(new BorderLayout());
        
        JPanel cellPanel = new JPanel();
        cellPanel.setLayout(new GridLayout(3, 3));
        int i,j;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                cellPanel.add(cells[i][j] = new Cell());
            }
        }
        
        JPanel btnPanel = new JPanel();
        btNew = new JButton("Start new game");
        btNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                resetGame();
                
            }
        });
        btnPanel.add(btNew);
        
        panel.add(cellPanel, BorderLayout.CENTER);
        panel.add(btnPanel, BorderLayout.SOUTH);
        
        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 430);
        setTitle("Tic tac toe");
        
    }

    public char checkWhoWin() {
//        try {
//            Thread.sleep(20);  //TẠI SAO PHẢI CÓ LỆNH SLEEP, HOẶC 1 LỆNH System.out.println(""); THÌ CHẠY MỚI KO BỊ LỖI?
//        } catch (InterruptedException ex) {
//            Logger.getLogger(TicTacToe.class.getName()).log(Level.SEVERE, null, ex);
//        }
        System.out.println("checking...");
        for (int i = 0; i < 3; i++) {  ///check xem 3 hàng dọc hoặc 3 hàng ngang có toàn x hoặc o hay ko, nếu có thì người đó thắng
            if (cells[i][0].value != ' ') {  //check 3 hàng
                if ((cells[i][0].value == cells[i][1].value) && (cells[i][0].value == cells[i][2].value)) {
                    return cells[i][0].value;
                }
            }
            if(cells[0][i].value != ' ') {  //check 3 cột
                if((cells[0][i].value == cells[1][i].value) && (cells[0][i].value == cells[2][i].value)) return cells[0][i].value;
            }
        }
        
        //check 2 đường chéo:
        if(cells[1][1].value != ' ') {
            if ((cells[0][0].value == cells[1][1].value) && (cells[0][0].value == cells[2][2].value)) {
                System.out.println("00 == 11 == 22");
                return cells[0][0].value;
            }
            if ((cells[0][2].value == cells[1][1].value) && (cells[0][2].value == cells[2][0].value)) {
                return cells[2][0].value;
            }
        }
        return ' ';
    }
    
    public void resetGame() {
        int i,j;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                //cells[i][j] = new Cell();
                cells[i][j].clear();
            }
        }
    }
    
    
    public static void main(String[] args) {
        TicTacToe2 ticTacToe = new TicTacToe2();
        ticTacToe.setVisible(true);
    }
    
    
    ///inner class:
    class Cell extends JPanel {
        JLabel label;
        public char value;
        final int padding = 10;
        boolean isClicked = false;
        //boolean isXTurn = true;  nếu cho biến isXTurn ở class này thì ko đc, vì nó ko phải là static, thêm nữa vì ta có 9 ô(9 cell)
        //nên mỗi cell sẽ có 1 biến isXTurn riêng, do đó khi click vào 1 ô thì isXTurn của ô đó luôn = true, sau đó = false
        //vì isXTurn ko phải là static mà! ở đây ta muốn khi click vào 1 ô thì biến isXTurn phải lấy giá trị trước đó, nghĩa là isXTurn phải là biến static
        //nhưng khai báo biến static ở class này ko đc, vì đây là inner class

        public Cell() {
            label = new JLabel();
            add(label);
            
            value = ' ';
            isClicked = false;
            setBorder(new LineBorder(Color.GREEN, 2));

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent me) {
                    if (!isClicked) {  //nếu ô chưa đc click thì mới vẽ, nếu click rồi thì ko vẽ nữa
                        clickedTime++;
                        isClicked = true;
                        Graphics2D g = (Graphics2D) getGraphics();
                        g.setStroke(new BasicStroke(5.0f));
                        if (isXTurn) {  //draw X
                            value = 'x';
                            label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/x_icon100.png")));
                        } else {  //draw O: if (value == 'o')
                            value = 'o';
                            label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/o_icon100.png")));
                        }
                        isXTurn = !isXTurn;

                        ///check xem đã có người thắng chưa:
                        winner = checkWhoWin();
                        if (winner == 'x') {
                            isDraw = false;
                            JOptionPane.showMessageDialog(TicTacToe2.this, "winner is x");
                        } else if (winner == 'o') {
                            isDraw = false;
                            JOptionPane.showMessageDialog(TicTacToe2.this, "winner is o");
                        }

                        if (clickedTime == 9) {  //đã điển đủ 9 ô, game kết thúc
                            if (TicTacToe2.isDraw) {
                                JOptionPane.showMessageDialog(TicTacToe2.this, "draw");
                            }
                        }
                        //System.out.println("clickedTime = "+clickedTime);
                    }
                }
            });
        }


        public void clear() {
            repaint();
            value = ' ';
            isClicked = false;
            clickedTime = 0;
            isXTurn = true;
            label.setIcon(null);
            isDraw = true;
        }
    }  //end inner class

} //end main class
