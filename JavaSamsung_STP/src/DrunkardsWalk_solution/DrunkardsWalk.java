/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DrunkardsWalk_solution;

import java.util.Scanner;

/**
 *
 * @author AnhTu
 */
//SEE MORE: SLIDE JAVA BASIC, LESSON 30, JAVA STP SAMSUNG
//A man leaves the pub to walk home
// Every step he takes on the way home is in
//one of the four directions: north, south, east or west
// The direction in which he takes each step is random
// Given the location of the pub and his home,
//calculate how many steps he takes to get home
// Keep track of which coordinates he has
//visited on the way home
public class DrunkardsWalk {

    char[][] town;
    int currentXcoord;
    int currentYcoord;
    int numberOfSteps;
    Scanner keyboard = new Scanner(System.in);

    public DrunkardsWalk() {
        numberOfSteps = 0;
        System.out.print("Enter size of town [height] [width]: ");
        int height = keyboard.nextInt();
        int width = keyboard.nextInt();
        town = new char[height][width];
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                town[i][j] = '.';
            }
        }
        System.out.print("Enter coordintates of Pub [Y] [X]: ");
        int pubYcoord = keyboard.nextInt();
        int pubXcoord = keyboard.nextInt();
        town[pubYcoord][pubXcoord] = 'P';
        System.out.print("Enter coordintates of Home [Y] [X]: ");
        int homeYcoord = keyboard.nextInt();
        int homeXcoord = keyboard.nextInt();
        town[homeYcoord][homeXcoord] = 'H';
        currentXcoord = pubXcoord;
        currentYcoord = pubYcoord;
    }

    public void displayTown() {
        for (int i = 0; i < town[0].length + 2; ++i) {
            System.out.print("*");
        }
        System.out.println();
        for (int x = 0; x < town.length; ++x) {
            System.out.print("*");
            for (int y = 0; y < town[x].length; ++y) {
                System.out.print(town[x][y]);
            }
            System.out.println("*");
        }
        for (int i = 0; i < town[0].length + 2; ++i) {
            System.out.print("*");
        }
        System.out.println();
    }

    public void walkHome() {
        int nextXcoord = currentXcoord;
        int nextYcoord = currentYcoord;
        boolean bumpedIntoWall;
        while (town[nextYcoord][nextXcoord] != 'H') {
            ++numberOfSteps;
            bumpedIntoWall = false;
            int direction = (int) (Math.random() * 4);
            switch (direction) {
                case 0: // go north
                    if (currentYcoord == 0) {
                        bumpedIntoWall = true;
                    } else {
                        nextXcoord = currentXcoord;
                        nextYcoord = currentYcoord - 1;
                    }
                    break;

                case 1: // go south
                    if (currentYcoord == town.length - 1) {
                        bumpedIntoWall = true;
                    } else {
                        nextXcoord = currentXcoord;
                        nextYcoord = currentYcoord + 1;
                    }
                    break;
                case 2: // go west
                    if (currentXcoord == 0) {
                        bumpedIntoWall = true;
                    } else {
                        nextXcoord = currentXcoord - 1;
                        nextYcoord = currentYcoord;
                    }
                    break;

                case 3: // go east
                    if (currentXcoord == town[0].length - 1) {
                        bumpedIntoWall = true;
                    } else {
                        nextXcoord = currentXcoord + 1;
                        nextYcoord = currentYcoord;
                    }
                    break;
            }
// update map if not home
            if (town[nextYcoord][nextXcoord] != 'H') {
                town[currentYcoord][currentXcoord] = '-'; // visited
                currentXcoord = nextXcoord;
                currentYcoord = nextYcoord;
                town[currentYcoord][currentXcoord] = '@';
                displayTown();
            }
            keyboard.nextLine();
        }
        System.out.println("Reached Home! it took " + numberOfSteps + " steps");
    }
    
    public static void main(String[] args) {
        DrunkardsWalk dw = new DrunkardsWalk();
        dw.displayTown();
        dw.walkHome();
    }
}
