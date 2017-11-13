/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

/**
 *
 * @author AnhTu
 */
public class HanoiTower {
    static int soBuocChuyen=0;
    public static void hanoiTower(int size, String A, String C, String B) { //chuyển n=size đĩa từ cọc A sang cọc C, cọc B làm cọc trung gian
        
        if(size==1) {
            System.out.println(A + " -> " + C);
            soBuocChuyen++;
        }
        else {
            hanoiTower(size-1, A, B, C);    //Bước 1: chuyển size-1 đĩa trên cùng từ cọc A sang cọc B, cọc C làm cọc trung gian
            hanoiTower(1, A, C, B);         //Bước 2: chuyển 1 đĩa còn lại (to nhất) từ cọc A sang cọc C, cọc B làm cọc trung gian
            hanoiTower(size-1, B, C, A);    //Bước 3: chuyển size-1 đĩa (ở Bước 1) từ cọc B sang cọc C, cọc A làm cọc trung gian
        }
    }
    
    public static void main(String[] args) {
        String cocNguon="A";
        String cocDich="C";
        String cocTrungGian="B";
        
        int n=6;
        hanoiTower(n, cocNguon, cocDich, cocTrungGian);
        System.out.println("Số bước chuyển = "+soBuocChuyen+" = 2^"+n+"-1");
    }
}
