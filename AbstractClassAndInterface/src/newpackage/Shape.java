/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author AnhTu
 */
public abstract class Shape {
    protected String name;
    protected int x,y;  //tọa độ của hình

    public String getName() {
        return name;
    }

    public Shape(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }
    
    public abstract float calculateArea();
    public abstract float calculatePerimeter(); //tính chu vi
    
}