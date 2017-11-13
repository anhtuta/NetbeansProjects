/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash_set_CHU_Y_static;

import java.util.HashSet;
import java.util.Scanner;
import javax.swing.JFrame;

/**
 *
 * @author AnhTu
 */
/*
Cách chạy:
chạy file Test1 trước, khi đó máy yêu cầu nhập j đó, đừng nhập và chạy luôn file Test2
Rõ ràng Test1 chạy thì listUser đã đc khởi tạo, tại sao bên Test2 ko in ra được phần tử nào?
*/
public class Test1 extends JFrame {
    public static HashSet<String> listUser = new HashSet<>();
    
    static boolean checkWhetherExist(String str) {
        return listUser.contains(str);
    }
    public static void main(String[] args) {
        listUser.add("anhtu");
        listUser.add("goku");
        listUser.add("trung nguyen");
        listUser.add("tai sao");
        System.out.println("listUser:");
        for(String s: listUser) {
            System.out.println(s);
        }
        System.out.println("enter something...");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(s);
    }
}
