/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

/**
 *
 * @author AnhTu
 */
public class ViduString {
    public static void main(String[] args) {
        String st = "  taanhtu_daihocbkhn  ";
        System.out.println(st);
        System.out.println(st.charAt(6));
        System.out.println("index of anh is: "+st.indexOf("anh"));
        System.out.println("substring(5): "+st.substring(5));
        System.out.println("substring(5,9): "+st.substring(5,9));
        System.out.println("st: "+st);
        System.out.println(st.trim());
        
        String name = "Ta anh tu dhbk hn"; 
        String [] arr = name.trim().split(" ");  //chú ý có dấu cách ở split(" ")
        for(int i = 0; i<arr.length; i++) 
            System.out.println(arr[i]);
        
        ///////////////////////=====================/////////////
        ///vi du 2////////////
        String myCountry = "Beautiful land1 land2 land3";
        System.out.println(myCountry.replace("land", "Viet Nam"));
        System.out.println(myCountry.replaceFirst("land", "Vietnam"));
        
        String name2 = "Anhtu";
        if(name2 == "Anhtu") System.out.println("true");
        if(name2.equals("Anhtu")) System.out.println("Anhtu");
    } 
    
}
