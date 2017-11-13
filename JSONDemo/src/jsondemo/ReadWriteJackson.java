/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsondemo;

import java.io.IOException;

/**
 *
 * @author AnhTu
 * 
Jackson provides many ways of working. For simple cases, you can have POJO (plain
old Java objects) converted to/from JSON more-or-less automatically, as is illustrated
in Example 19-1.
 */

//Example 19-1. Reading and Writing POJOs with Jackson
public class ReadWriteJackson {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInput
                = "{\"id\":0,\"firstName\":\"Robin\",\"lastName\":\"Wilson\"}";
        Person q = mapper.readValue(jsonInput, Person.class);
        System.out.println("Read and parsed Person from JSON: " + q);
        Person p = new Person("Roger", "Rabbit");
        System.out.print("Person object " + p + " as JSON = ");
        mapper.writeValue(System.out, p);
    }
}
