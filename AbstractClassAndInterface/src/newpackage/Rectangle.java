/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AnhTu
 */
public class Rectangle extends Shape implements Actable {

    int h,w; //height, width
    public Rectangle(String name, int x, int y, int h, int w) {
        super(name, x, y);
        this.h=h;
        this.w=w;
    }

    @Override
    public float calculateArea() {
        return (float) (h*w);
    }

    @Override
    public float calculatePerimeter() {
        return 2*(h+w);
    }
    
    @Override
    public void draw(Graphics g) {
        g.drawRect(x, y, h, w);
    }

    @Override
    public void moveTo(Graphics g, int x1, int y1) {
        System.out.println("Move to");
    }

    @Override
    public void erase(Graphics g) {
        System.out.println("erase");
    }

    public static void main(String[] args) {
        Shape shape = new Rectangle("Toan", 3, 5, 6, 9);
        List<String> stuList = new ArrayList<>();
    }
}
