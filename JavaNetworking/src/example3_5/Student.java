/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example3_5;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 *
 * @author AnhTu
 */
public class Student {
    String name,street,city;
    final static int NAME_SIZE=32;
    final static int STREET_SIZE=32;
    final static int CITY_SIZE=20;
    
    public Student() {}

    public Student(String name, String street, String city) {
        this.name = name;
        this.street = street;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    public void readStudent(DataInput in) throws IOException {  //đọc thông tin từ tệp theo kích thước cố định
        name=FixedLengthStringIO.readFixedLengthString(NAME_SIZE, in);
        street=FixedLengthStringIO.readFixedLengthString(STREET_SIZE, in);
        city=FixedLengthStringIO.readFixedLengthString(CITY_SIZE, in);
        
    }
    
    public void writeStudent(DataOutput out) throws IOException {  //ghi thông tin lên tệp theo kích thước cố định
        FixedLengthStringIO.writeFixedLengthString(name, NAME_SIZE, out);
        FixedLengthStringIO.writeFixedLengthString(street, STREET_SIZE, out);
        FixedLengthStringIO.writeFixedLengthString(city, CITY_SIZE, out);
        
    }
}
