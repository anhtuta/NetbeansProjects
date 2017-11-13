/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author AnhTu
 */
public class String3Dot {
    String name;
    List<String> favoriteFood;

    public String3Dot(String name, List<String> favoriteFood) {
        this.name = name;
        this.favoriteFood = favoriteFood;
    }
    
    public String3Dot(String name, String... foodList) {
        this.name = name;
        this.favoriteFood = new ArrayList<>();
        if(foodList != null) {
            this.favoriteFood.addAll(Arrays.asList(foodList));
        }
    }
    
    void printInfo() {
        System.out.print(this.name + " - ");
        System.out.println(this.favoriteFood);
    }
    
    public static void main(String[] args) {
        List<String> myFoods = new ArrayList<>();
        myFoods.add("banana");
        myFoods.add("guava");   //ổi
        myFoods.add("apple");
        myFoods.add("plum");
        
        String3Dot anhtu = new String3Dot("Anhtu", myFoods);
        anhtu.printInfo();
        
        String3Dot toan = new String3Dot("Toan noob", "orange", "watermelon", "grape", "strawberry");
        toan.printInfo();
    }
}
