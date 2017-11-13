/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapter;

/**
 *
 * @author AnhTu
 */
public class ChargerAdapter {   //Adapter
    private ChargerAdaptee adaptee;
    
    public void charge() {
        adaptee = new ChargerAdaptee();
        adaptee.plug();
    }
}
