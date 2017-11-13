/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked_list;

/**
 *
 * @author AnhTu
 */
class StudentNode {

    String name;      // Note: package access is used only
    int mark;         // for teaching purposes, would
    StudentNode next; // be private

    public StudentNode(String _n, int _m) {
        name = _n;
        mark = _m;
        next = null;
    }
}
