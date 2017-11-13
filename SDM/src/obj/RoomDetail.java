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
public class RoomDetail {
    public RoomDetail(int id, int name,int capacity, int free, String dormitory){
        this.Room_id = id;
        this.Room_name = name;
        this.Dormitory_name = dormitory;
        this.Room_capacity = capacity;
        this.Room_free = free;
    }
    int Room_id;
    int Room_name;
    String Dormitory_name;
    int Room_capacity;
    int Room_free;

    public int getRoom_capacity() {
        return Room_capacity;
    }

    public int getRoom_free() {
        return Room_free;
    }
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
