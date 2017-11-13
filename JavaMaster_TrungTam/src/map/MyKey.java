/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

/**
 *
 * @author AnhTu
 */
public class MyKey implements Comparable<MyKey> {
    int data;

    public MyKey(int data) {
        this.data = data;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if(obj instanceof MyKey) {
//            return this.data == ((MyKey) obj).data;
//        }
//        return false;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 67 * hash + this.data;
//        return hash;
//    }

    @Override
    public int compareTo(MyKey k) {
        if(this.data > k.data) return 1;
        else if(this.data < k.data) return -1;
        else return 0;
    }
}
