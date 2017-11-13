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

////////////số thuận nghịch là số đọc từ phải qua trái cũng = đọc từ trái qua phải
////////////ta liệt kê các số thuận nghịch có 6 chữ số
public class SoThuanNghich {
    static boolean thuanNghich(int n)  {
        
        //biến temp là biến n được viết ngược lại vd: n=642579 thì temp = 975246
        int tg = n; int temp = 0; //tg là biến lưu giá trị n
        while(tg>0) {
            temp = temp*10 + tg%10;
            tg /=10;
        }
        if(temp == n) return true;
        else return false;
    }
    
    static void display() {
        int count = 0; //đếm số
        for(int i=10000; i<=99999; i++) 
            if(thuanNghich(i)) {
                System.out.print(i+" ");
                if(count%10==0) System.out.println("");
                count++;
            }
        System.out.println("\nco tat ca "+count+"so thuan nghich");
    }
    
    public static void main(String[] args) {
        System.out.println("cac so thuan nghich co 5 chu so la: ");
        display();
    }
}
