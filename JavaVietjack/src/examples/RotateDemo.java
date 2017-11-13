/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author AnhTu
 */
public class RotateDemo {
    public static void main(String[] args) {
        List list = Arrays.asList("one Two three Four five six".split(" "));
        System.out.println("List :" + list);
        Collections.rotate(list, 3);
        System.out.println("rotate: " + list);
    }
}
