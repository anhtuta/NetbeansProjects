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

//chú ý: String bình thường khi sử dụng các hàm thì ko thay đổi giá trị, nhưng StringBuilder và StringBuffer thì bị thay đổi = các lệnh, phương thức của nó
//stringbuffer sẽ nhanh hơn StringBuilder vì có bộ nhớ cache

public class StringBuilderBuffer {
    public static void main(String[] args) {
        StringBuilder sbuilder = new StringBuilder("Ta anh tu 1995");
        sbuilder.append(" bkhn");  //nếu là String bình thường thì sẽ ko thay đổi giá trị của sbuilder
        System.out.println(sbuilder); 
        sbuilder.insert(10, "Vietnam "); //chèn vào vị trí số 10
        System.out.println(sbuilder);
        
        StringBuffer sbuffer = new StringBuffer("Dien tu vien thong 2016");
        sbuffer.reverse();
        System.out.println(sbuffer);
    }
}
