/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectSerialization;

/**
 *
 * @author AnhTu
 */
import java.io.*;

class Point implements Serializable {

    double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ") ";
    }
}

class Triangle implements Serializable {

    Point a, b, c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    @Override
    public String toString() {
        return "<" + a.toString() + b.toString() + c.toString() + ">";
    }
}

public class TriangleFile {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Triangle t1 = new Triangle(new Point(-1, 0), new Point(1, 0), new Point(0, 1));

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("myObjectFile"));
        out.writeObject(t1);
        out.close();
        System.out.println("Serialized data is saved in myObjectFile");
        
        System.out.println("Serialized data...");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("myObjectFile"));
        Triangle t2 = (Triangle) in.readObject();
        System.out.println(t2.toString());
        
    }

}
