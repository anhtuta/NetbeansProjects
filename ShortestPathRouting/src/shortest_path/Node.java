/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortest_path;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author AnhTu
 */
public class Node {

    private int index;
    private int x, y;   //coordinates
    private final int RADIUS = 15;
    //private String neighbors;
    int [] neighbors;
    int [] weights;
    private JFrame frame;
    
    public Node(int index, int x, int y, JFrame frame) {
        this.index = index;
        this.x = x;
        this.y = y;
        this.frame = frame;
        
        this.frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                //System.out.println("clicked");
                int x = me.getX();
                int y = me.getY();
                if(x < Node.this.x + 10 && x > Node.this.x - 10 && y < Node.this.y + 10 && y > Node.this.y - 10) {
                    String neighbors = "";
                    for (int i = 0; i < Node.this.neighbors.length; i++) {
                        neighbors += Node.this.neighbors[i] + " ";
                    }
                    JOptionPane.showMessageDialog(frame, "Node "+index + ", coordinate: (" + Node.this.x + ", " + Node.this.y + ")\n" + "Neighbors: " + neighbors);
                }
            }
        });
        
        this.frame.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                int x = me.getX();
                int y = me.getY();
                if(x < Node.this.x + 10 && x > Node.this.x - 10 && y < Node.this.y + 10 && y > Node.this.y - 10) {
                    setX(x);
                    setY(y);
                    frame.repaint();
                }
            }
        });
        
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

    public int[] getWeights() {
        return weights;
    }

    public void setWeights(int[] weights) {
        this.weights = weights;
    }
    
    public void drawNode(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x-RADIUS+4, y-RADIUS-4, RADIUS*2, RADIUS*2);
        g.setColor(Color.BLACK);
        g.drawString(index+"", x, y);
    }
}
