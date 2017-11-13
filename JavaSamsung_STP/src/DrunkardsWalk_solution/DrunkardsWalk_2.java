/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DrunkardsWalk_solution;

import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author AnhTu
 */
//làm lại bài DrunkardsWalk
//chú ý: town[5][7] nghĩa là mảng town có 5 phần tử, mỗi phần tử lại có 7 phần tử con
//nếu hiển thị thì: coi town[3] là hàng thứ 4 gồm 7 phần tử trên hàng đó từ town[3][0] tới town[3][6]
//town[3] đại diện cho tọa độ y, town[3][i] là các tọa độ x trên mặt phẳng tọa độ trong Java

public class DrunkardsWalk_2 {
    char [][] town;
    int currentXcoord;
    int currentYcoord;
    int nextXcoord;
    int nextYcoord;
    int numberOfSteps;
    Scanner kb = new Scanner(System.in);
    
    public DrunkardsWalk_2() {
        numberOfSteps = 0;
        System.out.print("Enter size of town [height] [width]: ");
        int height = kb.nextInt();
        int width = kb.nextInt();
        
        town = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                town[i][j] = '.';
            }
        }
        int pubXcoord = 0;
        int pubYcoord = 0;
        
        do {
            try {
                System.out.print("Enter coordintates of Pub [Y] [X]: ");
                pubYcoord = kb.nextInt(); //Y đại diện cho hàng lúc hiển thị
                pubXcoord = kb.nextInt(); //X đại diện cho cột
                town[pubYcoord][pubXcoord] = 'P';
                if ((pubYcoord < town.length) || (pubXcoord < town[0].length)) {
                }
                currentXcoord = pubXcoord;
                currentYcoord = pubYcoord;
            } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "Tọa độ nhập quá kích thước của map");
            }
        } while ((pubYcoord >= town.length) || (pubXcoord >= town[0].length));

        try {
            System.out.println("Enter coordinates of Home [Y] [X]: "); //chú ý là tọa độ phải nhỏ hơn ơheight-1][width-1]
            int homeYcoord = kb.nextInt();
            int homeXcoord = kb.nextInt();
            town[homeYcoord][homeXcoord] = 'H';
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Tọa độ nhập quá kích thước của map");
        }
        
    }
    
    public void displayTown() {
        for (int i = 0; i < town[0].length + 2; i++) { //display the first row
            System.out.print("*");
        }
        System.out.println();
        
        for (int i = 0; i < town.length; i++) { //display the rest of the rows, except the last row
            System.out.print("*");
            for (int j = 0; j < town[0].length; j++) {
                System.out.print(town[i][j]);
            }
            System.out.print("*");
            System.out.println();
        }
        
        for (int i = 0; i < town[0].length + 2; i++) {  //display the last row
            System.out.print("*");
        }
        
        System.out.println();
    }
    
    public void walkHome() {
        nextXcoord = currentXcoord;
        nextYcoord = currentYcoord; //khởi tạo giá trị cho tọa độ tiếp theo
        boolean bumpedIntoWall = false;
        Random rd = new Random();
        
        while(town[nextYcoord][nextXcoord] != 'H') { //khi chưa về đến nhà thì cứ đi mãi, nghĩa là cập nhập giá trị cho nextX,Ycoord, sau đó gán currentX,Ycoord = nextX,Ycoord
            numberOfSteps++;
            int direction = rd.nextInt(4); //random in {0,1,2,3}
            switch (direction) {
                case 0: // go north 
                    if(currentYcoord == 0) bumpedIntoWall = true;
                    else {
                        nextXcoord = currentXcoord;
                        nextYcoord = currentYcoord - 1;
                    }
                    break;
                case 1: //go south
                    if(currentYcoord == town.length - 1) bumpedIntoWall = true;
                    else {
                        nextXcoord = currentXcoord;
                        nextYcoord = currentYcoord + 1;
                    }
                    break;
                case 2: //go east
                    if(currentXcoord == town[0].length - 1) bumpedIntoWall = true;
                    else {
                        nextXcoord = currentXcoord + 1;
                        nextYcoord = currentYcoord;
                    }
                    break;
                case 3: //go west
                    if(currentXcoord == 0) bumpedIntoWall = true;
                    else {
                        nextXcoord = currentXcoord - 1;
                        nextYcoord = currentYcoord;
                    }
                    break;
            }
            if(bumpedIntoWall) {
                System.out.println("Bumped into wall");
                bumpedIntoWall = false;
            }
            
            //update (repaint) the map if it's not home:
            if (town[nextYcoord][nextXcoord] != 'H') {
                town[currentYcoord][currentXcoord] = '-'; //visited
                town[nextYcoord][nextXcoord] = '@'; //current coordinate displayed by @
                currentXcoord = nextXcoord;
                currentYcoord = nextYcoord;
                displayTown();
            }
            kb.nextLine(); //chờ ấn enter để đi tiếp
        }
        System.out.println("Reached Home! it took " + numberOfSteps + " steps");
    }
    
    public static void main(String[] args) {
        DrunkardsWalk_2 dw2 = new DrunkardsWalk_2();
        dw2.displayTown();
        dw2.walkHome();
    }
}
/*
*********
*.......*
*.......*
*.......*
*.......*
*.......*
*********/
