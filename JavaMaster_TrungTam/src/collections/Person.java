/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

/**
 *
 * @author AnhTu
 */
public class Person implements Comparable<Person> {
    int id;
    String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Person p) {    //sắp xếp theo chiều tăng dần của ID nếu như dùng hàm Collections.sort();
        //Chú ý rằng hàm này có 1 tham số vì thằng this của class này sẽ so sánh với thằng p
        if(this.id > p.id) return 1;
        else if(this.id < p.id) return -1;
        else return 0;
    }
    
    public String getInfo() {
        return this.id+" - "+this.name;
    }
}
