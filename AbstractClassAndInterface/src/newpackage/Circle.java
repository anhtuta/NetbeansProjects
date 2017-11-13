/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.awt.Graphics;

/**
 *
 * @author AnhTu
 */
public class Circle extends Shape implements Actable {

    private int radius;

    public Circle(String name, int x, int y, int radius) {
        super(name, x, y);
        this.radius = radius;
    }
    
    @Override
    public float calculateArea() {
        return (float) (Math.PI*radius*radius);
    }

    @Override
    public float calculatePerimeter() {
        return (float) (2*Math.PI*radius);
    }
    
    @Override
    public void draw(Graphics g) {
        g.drawOval(x-radius, y-radius, 2*radius, 2*radius);
    }

    @Override
    public void moveTo(Graphics g, int x1, int y1) {
        erase(g);
        x = x1; y = y1;
        draw(g);
    }

    @Override
    public void erase(Graphics g) {
        //paint the region with background color...
    }
    
    public static void main(String[] args) {
        Circle c = new Circle("Anhtu", 5, 5, 12);
        System.out.println("Dien tich hinh tron la: "+c.calculateArea());
        System.out.println("Chu vi hinh tron la: "+c.calculatePerimeter());
        
    }

}
