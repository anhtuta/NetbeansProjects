/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strings;

/**
 *
 * @author AnhTu
 */
//StringBuilder ko đồng bộ
//StringBuffer tất cả các hàm là đồng bộ, do đó nó chậm hơn StringBuilder
//Nếu nối chuỗi nhiều thì nên dùng StringBuilder hoặc StringBuffer thay vì String
public class StringBuilderAndBuffer {
    public static void main(String[] args) {
        StringBuilder strBuilder = new StringBuilder("Tao la ta anh tu");
        System.out.println(strBuilder);
        
        String str = strBuilder.toString();
        System.out.println(str);
        
        strBuilder.append(" hnay la thu 7");
        strBuilder.append(" ngay 22/4/2017");
        strBuilder.append(" troi mat");
        
        System.out.println(strBuilder);
        
    }
    
}
