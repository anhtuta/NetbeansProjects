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

//block code ko thuộc 1 cái j cả
//chung cho tất cả đối tượng
//block code static đc thực hiện trước rồi đến block code thường rồi mới đến các phương thức khác
public class BlockCode {
    {
        System.out.println("block code 1");
    }
    static {
        System.out.println("static block code 1");
    }
    public BlockCode(){
        System.out.println("Constructor");
    }
    public static void main(String[] args) {
        BlockCode bai57 = new BlockCode(); 
    }
    
    {
        System.out.println("block code 2");
    }
    static {
        System.out.println("static block code 2");
    }
    
}
