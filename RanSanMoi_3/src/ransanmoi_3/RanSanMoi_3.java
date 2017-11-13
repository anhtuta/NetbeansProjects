/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ransanmoi_3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author AnhTu
 */
public class RanSanMoi_3 extends JFrame {
    JPanel mainPanel;
    GameScreen gs;
    static JComboBox cbLevel, cbMap;
    JButton btNewGame;
    JButton btHighScore;
    Map m = new Map();
    
    public RanSanMoi_3() {
        mainPanel = new JPanel(new BorderLayout());
        gs = new GameScreen();
        new FrameLevel().setVisible(true);
        
        mainPanel.add(gs, BorderLayout.CENTER);
        
        add(mainPanel);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                mainPanelKeyPressed(ke);
            }
        });
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 570);
    }
    
    private void mainPanelKeyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_SPACE) {
            if(GameScreen.isGameOver && !GameScreen.isReadyForNewGameAfterGameOver) {
                System.out.println("th1");
                GameScreen.diem = 0;
                GameScreen.currLevel = 1;
                gs.cr.resetGame();
                GameScreen.isReadyForNewGameAfterGameOver = true;
                cbLevel.setEnabled(true);
                cbMap.setEnabled(true);
                //gs.repaint();
            }
            
            if(!GameScreen.isGameOver)  {
                GameScreen.isPlaying = !GameScreen.isPlaying;
                cbLevel.setEnabled(false);
                cbMap.setEnabled(false);
                System.out.println("th2");
            }
            
            if(GameScreen.isGameOver && GameScreen.isReadyForNewGameAfterGameOver) {
                GameScreen.isGameOver = false;
                cbLevel.setEnabled(true);
                cbMap.setEnabled(true);
                System.out.println("th3");
                gs.cr.daNhapTen = false;
            }
            //CHÚ Ý: KO ĐC ĐỔI THỨ TỰ 3 LỆNH IF TRÊN
        }
        
        if (ke.getKeyCode() == KeyEvent.VK_UP) gs.cr.setVector(1);
        if (ke.getKeyCode() == KeyEvent.VK_DOWN) gs.cr.setVector(-1);
        if (ke.getKeyCode() == KeyEvent.VK_LEFT) gs.cr.setVector(2);
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) gs.cr.setVector(-2);
    }
    
    
    
    //////////////////main method://////////////////////////
    public static void main(String[] args) {
        RanSanMoi_3 f = new RanSanMoi_3();
        f.setVisible(true);
    }
    
    class FrameLevel extends JFrame implements ActionListener {
        
        public FrameLevel() {
            JPanel optionPanel = new JPanel(new BorderLayout());  //optionPanel là cái panel chính của Frame này
            JPanel levelPanel = new JPanel();
            
            JPanel lbPanel = new JPanel(new GridLayout(2, 1));
            
            lbPanel.add(new JLabel("Choose level:"));
            lbPanel.add(new JLabel("Choose map:  "));
            
            JPanel cbPanel = new JPanel(new GridLayout(2, 1));
            cbLevel = new JComboBox();
            cbLevel.addItem("1");
            cbLevel.addItem("2");
            cbLevel.addItem("3");
            cbLevel.addItem("4");
            cbLevel.addItem("5");
            cbLevel.setPreferredSize(new Dimension(60, 25));
            cbLevel.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent ie) {
                    cbLevelItemStateChanged(ie);
                }
            });
            
            cbPanel.add(cbLevel);
            
            cbMap = new JComboBox();
            cbMap.addItem("Ko map");
            cbMap.addItem("Map 1");
            cbMap.addItem("Map 2");
            cbMap.addItem("Random");
            cbMap.addItem("Tú");
            
            cbMap.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent ie) {
                    cbMapItemStateChanged(ie);
                }
            });
            
            cbPanel.add(cbMap);
            
            levelPanel.add(lbPanel);
            levelPanel.add(cbPanel);
            
            
            JPanel btPanel = new JPanel();
            btNewGame = new JButton("Start a new game");
            btNewGame.addActionListener(this);
            btHighScore = new JButton("High scores");
            btHighScore.addActionListener(this);
            
            btPanel.add(btNewGame);
            btPanel.add(btHighScore);
            
            optionPanel.add(levelPanel, BorderLayout.NORTH);
            optionPanel.add(btPanel, BorderLayout.SOUTH);
            
            
            add(optionPanel);
            setSize(280, 130);
            setResizable(false);
            setLocation(650, 0);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
        
        private void cbLevelItemStateChanged(ItemEvent ie) {
            String value = (String) cbLevel.getSelectedItem();
            GameScreen.currLevel = Integer.valueOf(value);
        }

        private void cbMapItemStateChanged(ItemEvent ie) {
            String value = (String) cbMap.getSelectedItem();
            if(value.equals("Ko map")) m.clearMap();
            if(value.equals("Map 1")) m.setMap1();
            if(value.equals("Map 2")) m.setMap2();
            if(value.equals("Random")) m.setRandomMap();
            if(value.equals("Tú")) m.setMapTu();
            
            GameScreen.bg = m.getMap();
            GameScreen.bg[10][10] = 2;
        }
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource() == btNewGame) {
                gs.cr.resetGame();
                GameScreen.isPlaying = false;
                GameScreen.diem = 0;
                cbLevel.setEnabled(true);
                cbMap.setEnabled(true);
            }
            
            if(ae.getSource() == btHighScore) {
                String data = gs.cr.readData();
                JOptionPane.showMessageDialog(null, data, "High scores", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
