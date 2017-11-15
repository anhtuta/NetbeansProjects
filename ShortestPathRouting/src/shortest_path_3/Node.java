/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortest_path_3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author AnhTu
 */
public class Node {

    private int index;
    String name;
    public int x, y;   //coordinates
    private final int RADIUS = 15;
    //private String neighbors;
    private int [] neighbors;
    int [] weights;
    private JPanel panel;
    
    public Node(int index, int x, int y, JPanel panel) {
        this.index = index;
        this.x = x;
        this.y = y;
        this.panel = panel;
        
//        this.panel.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent me) {
//                //System.out.println("clicked");
//                int mouseX = me.getX();
//                int mouseY = me.getY();
//                
//                showNodeInfo(mouseX, mouseY);
//                
//            }
//
//        });
//        
//        this.panel.addMouseMotionListener(new MouseMotionAdapter() {
//            @Override
//            public void mouseDragged(MouseEvent me) {
//                int x = me.getX();
//                int y = me.getY();
//                if(x < Node.this.x + 10 && x > Node.this.x - 10 && y < Node.this.y + 10 && y > Node.this.y - 10) {
//                    setX(x);
//                    setY(y);
//                    panel.repaint();
//                    //drawNode(panel.getGraphics());
//                }
//            }
//        });
//        
    }

    private void showNodeInfo(int mouseX, int mouseY) {
        if(mouseX < this.x + 10 && mouseX > this.x - 10 && mouseY < this.y + 10 && mouseY > this.y - 10) {
            System.out.println("x = " + this.x + ", y = " + this.x + "; mouse: x = " + mouseX + ", y = " + mouseY);
            System.out.println();
            
            String neighbors = "";
            for (int i = 0; i < this.neighbors.length; i++) {
                neighbors += this.neighbors[i] + " ";
            }
            JOptionPane.showMessageDialog(panel, "Node "+index + ", coordinate: (" + this.x + ", " + this.y + ")\n" + "Neighbors: " + neighbors);
        }
    }
    
    public int getRADIUS() {
        return RADIUS;
    }

    public int getIndex() {
        return index;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setNeighbors(int [] neighbors) {
        this.neighbors = neighbors;
    }

    public int [] getNeighbors() {
        return neighbors;
    }
    
    public String getNeighborsName() {
        String str = "";
        for (int i = 0; i < neighbors.length; i++) {
            str += neighbors[i] + " ";
        }
        return str;
    }

    public int[] getWeights() {
        return weights;
    }

    public void setWeights(int[] weights) {
        this.weights = weights;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void drawNode(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x-RADIUS+4, y-RADIUS-4, RADIUS*2, RADIUS*2);
        g.setColor(Color.BLACK);
        g.setFont(new java.awt.Font("Tahoma", 1, 16));
        g.drawString(index+"", x, y);
    }
}
