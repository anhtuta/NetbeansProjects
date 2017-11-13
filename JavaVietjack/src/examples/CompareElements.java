/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author AnhTu
 */
//chú ý: chữ hoa sẽ nhỏ hơn chữ thường, vì theo mã ASCII:
//A-Z = 65-90,  a-z = 97-122
public class CompareElements {

    public static void main(String[] args) {
        String[] coins = {"Penny", "nickel", "dime", "Quarter", "dollar"};
        Set set = new TreeSet();
        for (int i = 0; i < coins.length; i++) {
            set.add(coins[i]);
        }
        System.out.println(Collections.min(set));
        System.out.println(Collections.min(set, String.CASE_INSENSITIVE_ORDER)); //A Comparator that orders String objects as by compareToIgnoreCase. This comparator is serializable.
                                                                                 //nghĩa là so sánh ko quan tâm tới viết hoa, nghĩa là N=n,...
        System.out.println(Collections.max(set));
        System.out.println(Collections.max(set, String.CASE_INSENSITIVE_ORDER));
    }
}
