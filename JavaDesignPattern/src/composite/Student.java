/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composite;

/**
 *
 * @author AnhTu
 */
//subclass1
public class Student implements Education {

    private float math, physic;

    public Student(float math, float physic) {
        this.math = math;
        this.physic = physic;
    }
    
    
    @Override
    public float caculatePoint() {
        return (math + physic)/2;
    }
    
}
