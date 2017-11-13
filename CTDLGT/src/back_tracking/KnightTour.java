/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package back_tracking;

/**
 *
 * @author AnhTu
 */
/*
The knight is placed on the first block of an empty board and, moving according to the rules of chess, must visit each square exactly once.

Backtracking works in an incremental way to attack problems. Typically, we start from an empty solution vector and one by one add items (Meaning of item varies from problem to problem. In context of Knight’s tour problem, an item is a Knight’s move). When we add an item, we check if adding the current item violates the problem constraint, if it does then we remove the item and try other alternatives. If none of the alternatives work out then we go to previous stage and remove the item added in the previous stage. If we reach the initial stage back then we say that no solution exists. If adding an item doesn’t violate constraints then we recursively add items one by one. If the solution vector becomes complete then we print the solution.

Backtracking Algorithm for Knight’s tour

Following is the Backtracking algorithm for Knight’s tour problem:

If all squares are visited 
    print the solution
Else
   a) Add one of the next moves to solution vector and recursively 
   check if this move leads to a solution. (A Knight can make maximum 
   eight moves. We choose one of the 8 moves in this step).
   b) If the move chosen in the above step doesn't lead to a solution
   then remove this move from the solution vector and try other 
   alternative moves.
   c) If none of the alternatives work then return false (Returning false 
   will remove the previously added item in recursion and if false is 
   returned by the initial call of recursion then "no solution exists" )

Đây là bài toán mã đi tuần
*/
public class KnightTour {
    static int N = 5;
    static int [][] sol;
    static int [] xMove = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int [] yMove = {-1, 1, -2, 2, -2, 2, -1, 1};
    
    static boolean thuocTapUCV(int x, int y) {
        return (x>=0 && x<N && y>=0 && y<N && sol[x][y] < 0);
    }
    
    public static void knightTour() {
        sol = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sol[i][j] = -1;
            }
        }
        sol[0][0] = 0;
        if(!knightTourSolution(0, 0, 1)) System.out.println("Solution doesn't exist!");
    }
    
    private static boolean knightTourSolution(int x_curr, int y_curr, int nextMoveNum) {
        if(nextMoveNum == N*N) {
            ghiNhan();
            System.out.println();
            return true;
        }
        int i, x_next, y_next;
        
        for (i = 0; i < xMove.length; i++) {
            x_next = x_curr + xMove[i];
            y_next = y_curr + yMove[i];
            if(thuocTapUCV(x_next, y_next)) {
                sol[x_next][y_next] = nextMoveNum;
                if(knightTourSolution(x_next, y_next, nextMoveNum + 1)) return true;
                else sol[x_next][y_next] = -1;      //backtracking, nghĩa là tại ô tiếp theo quân mã đi tới mà ko tìm đc lời giải thì ô tiếp theo đó phải = -1
            }
        }
        return false;   //nếu ko có ô nào mà quân mã có thể đi tiếp dù vẫn còn ô trống thì return false
    }
    
    static void ghiNhan() {
        //printSolution: print array sol[][]
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(sol[i][j] > 9) System.out.print(sol[i][j] + " ");
                else System.out.print(" " + sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        knightTour();
    }
    
}
/*
giả sử đang tính: knightTourSolution(7,2,56):
 - vòng lặp 1: x_next=6, y_next=0 thuộc Sk, do đó sol[6][0] = 56
        nhưng knightTourSolution(6,0,57) = false vì ko tìm đc ô nào chứa 57
        do đó gán lại: sol[6][0] = -1;
 - Các vòng lặp còn lại: x_next và y_next ko tìm đc nữa
 - Vậy return false: knightTourSolution(7,2,56) = false;

Do knightTourSolution(7,2,56) = false nên sol[7][2] = -1;
*/