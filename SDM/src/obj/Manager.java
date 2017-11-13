/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obj;

/**
 *
 * @author tungt
 */
public class Manager {
    public Manager(int id, String name, String password,
            String phone, String add, String doritory){
        this.Manager_id = id;
        this.Manager_name = name;
        this.Manager_password = password;
        this.Manager_phone = phone;
        this.Manager_add = add;
        this.Dormitory_name = doritory;
    }
    int Manager_id;
    String Manager_name;
    String Manager_password;
    String Manager_phone;
    String Manager_add;
    String Dormitory_name;

    public int getManager_id() {
        return Manager_id;
    }

    public String getManager_name() {
        return Manager_name;
    }

    public String getManager_password() {
        return Manager_password;
    }

    public String getManager_phone() {
        return Manager_phone;
    }

    public String getManager_add() {
        return Manager_add;
    }

    public String getDormitory_name() {
        return Dormitory_name;
    }
    
}
