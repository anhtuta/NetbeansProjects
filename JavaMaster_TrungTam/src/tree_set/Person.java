/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree_set;

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
    
    public String getInfo() {
        return this.id+" - "+this.name;
    }

    @Override
    public int compareTo(Person p) {    //so sánh theo ID, nếu 2 person có ID = nhau thì tiếp tục so sánh theo tên. Cả 2 để theo chiều tăng dần
        if(this.id > p.id) return 1;
        else if(this.id < p.id) return -1;
        else {
            return this.name.compareTo(p.name);
        }
    }
    
}
