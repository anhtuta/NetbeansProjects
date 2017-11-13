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
public class User {
    //client class
    public void charge() {  //Hàm này coi như 1 black box với User vì nó ko biết Adaptee là cái j
        ChargerAdapter c = new ChargerAdapter();
        c.charge();
    }
}
