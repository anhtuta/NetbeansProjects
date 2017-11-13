/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastream;

/**
 *
 * @author AnhTu
 */
class NewBorn {

    private float weight;
    private char gender;

    NewBorn(float _w, char _g) {
        weight = _w;
        gender = _g;
    }

    public float getWeight() {
        return weight;
    }

    public char getGender() {
        return gender;
    }
}
