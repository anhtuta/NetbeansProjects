/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DrunkardsWalk_solution;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author AnhTu
 */
public class NewClass {

    public static void main(String[] args) {
        int x = 0;
        int fx;
        Scanner inputData = new Scanner(System.in);
        do {
            try {
                System.out.print("Enter x: ");
                x = inputData.nextInt();
                fx = 1/x;
                if(x!=0) System.out.println("f(x) = " + fx);
            } catch (InputMismatchException inputMisException) {
                System.out.println("You entered not - integer value!");
            } catch (ArithmeticException arithException) {
                System.out.println("Error " + arithException);
            }
        } while (x == 0);
    }
}
