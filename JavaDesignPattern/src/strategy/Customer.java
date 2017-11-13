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
public class Customer {
    private MarketingStrategy strategy;
    public Customer(MarketingStrategy s) {
        strategy = s;
    }
    public void sale() {
        strategy.sale();
    }
    
    public static void main(String[] args) {
        Customer c1 = new Customer(new EmployeeStrategy());
        c1.sale();
        
        Customer c2 = new Customer(new StudentStrategy());
        c2.sale();
        
        Customer c3 = new Customer(new MarketingStrategy() {
            @Override
            public void sale() {
                System.out.println("this is another strategy");
            }
        });
        c3.sale();
    }
}
