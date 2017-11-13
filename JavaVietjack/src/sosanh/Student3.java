/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sosanh;

/**
 *
 * @author AnhTu
 */
public class Student3 {
    public int id;

    public Student3(int id) {
        super();
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object ob) {
        return (ob instanceof Student3) ? ( this.getId() == ((Student3) ob).getId() ) : false;
    }

    @Override
    public int hashCode() {
        return this.id;
    }
    
    
}
