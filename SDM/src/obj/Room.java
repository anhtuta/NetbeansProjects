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
public class Room {
    public Room(int id, int name, String dormitory){
        this.Room_id = id;
        this.Room_name = name;
        this.Dormitory_name = dormitory;
    }
    int Room_id;
    int Room_name;
    String Dormitory_name;

    public int getRoom_id() {
        return Room_id;
    }

    public int getRoom_name() {
        return Room_name;
    }

    public String getDormitory_name() {
        return Dormitory_name;
    }
}
