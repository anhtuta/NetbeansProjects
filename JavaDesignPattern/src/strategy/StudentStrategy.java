/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

/**
 *
 * @author AnhTu
 */
public class StudentStrategy implements MarketingStrategy {

    @Override
    public void sale() {
        System.out.println("I'm poor, don't delude my money");
    }
}
