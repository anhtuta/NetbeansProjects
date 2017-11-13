/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anno;

/**
 *
 * @author AnhTu
 */
public @interface MyFirstAnnotation {
 
 // Phần tử name.
 public String name();
 
 // Phần tử description, có giá trị mặc định "".
 public String description() default "";
}