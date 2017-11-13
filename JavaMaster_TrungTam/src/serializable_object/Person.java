/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializable_object;

import java.io.Serializable;

/**
 *
 * @author AnhTu
 */
public class Person implements Serializable {
    int id;
    String name;

    private static final long serialVersionUID = 231214223;
    
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getInfo() {
        return this.id+" - "+this.name;
    }
}
