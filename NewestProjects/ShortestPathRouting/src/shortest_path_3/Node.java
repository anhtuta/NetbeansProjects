/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortest_path_3;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author AnhTu
 */
public class Node {

    private int index;      //Số thứ tự của node
    public int x, y;   //coordinates, tọa độ của node
    private final int RADIUS = 15;
    private int [] neighbors;       //các hàng xóm của node
    int [] weights;     //giá tương ứng với hàng xóm. 
    
    public Node(int index, int x, int y) {
        this.index = index;
        this.x = x;
        this.y = y;
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
    
    public void drawNode(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x-RADIUS+4, y-RADIUS-4, RADIUS*2, RADIUS*2);
        
        g.setColor(Color.BLACK);
        g.setFont(new java.awt.Font("Tahoma", 1, 16));
        g.drawString(index+"", x, y);
        g.drawOval(x-RADIUS+4, y-RADIUS-4, RADIUS*2, RADIUS*2);
    }
}
