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
@MyFirstAnnotation(name = "Some name", description = "Some description")
public class UsingMyFirstAnnotation {

    // Annotation được gắn trên cấu tử.
    // Với giá trị của phần tử name là "John"
    // Giá trị phần tử description là "Write by John".
    @MyFirstAnnotation(name = "John", description = "Write by John")
    public UsingMyFirstAnnotation() {

    }

    // Annotation được gắn lên method.
    // Với giá trị phần tử name là "Tom"
    // Phần tử descriptiono không khởi tạo, nó sẽ lấy theo mặc định.
    @MyFirstAnnotation(name = "Tom")
    public void someMethod() {

    }

    // Annotation gắn trên tham số của method.
    public void todo(@MyFirstAnnotation(name = "none") String job) {

        // Annotation được gắn lên biến địa phương.
        @MyFirstAnnotation(name = "Some name")
        int localVariable = 0;

    }

}
