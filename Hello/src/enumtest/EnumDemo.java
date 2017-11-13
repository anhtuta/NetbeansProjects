/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enumtest;

/**
 *
 * @author AnhTu
 */
public enum EnumDemo { //Enum là một class lai với hằng số. Dùng để tạo các hằng số dạng class để có thể sử dụng một cách linh động như đối tượng trong java.
    CAFE("cafe"), TEA("trà"), MILK("sữa");
    private String name;

    private EnumDemo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public static void main(String[] args) {
        System.out.println(EnumDemo.MILK.getName());
    }
    
}
