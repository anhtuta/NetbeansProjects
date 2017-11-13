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
A Maze is given as N*N binary matrix of blocks where source block is the upper left most block i.e., maze[0][0] and destination block is lower rightmost block i.e., maze[N-1][N-1]. A rat starts from source and has to reach destination. The rat can move only in two directions: forward and down.
In the maze matrix, 0 means the block is dead end and 1 means the block can be used in the path from source to destination. Note that this is a simple version of the typical Maze problem. For example, a more complex version can be that the rat can move in 4 directions and a more complex version can be with limited number of moves.

cách làm bài này giống hệt bài KnightTour.java, do đó cách làm bài này và bài KnightTour.java chỉ tìm đc 1 lời giải
*/
public class RatMaze {
    static int N;
    static int [][] sol;
    static int [][] maze;
    static int [] xMove = {1,0};
    static int [] yMove = {0,1};    //rat chỉ đi đc 2 hướng: đi xuống dưới(1,0) hoặc đi sang phải(0,1)
    
    private static boolean thuocTapUCV(int x, int y) {
        return x>=0 && x<N && y>=0 && y<N && maze[x][y]==1;
    }
    
    static void ratMaze() {
        sol = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sol[i][j] = 0;
            }
        }
        sol[0][0] = 1;      //xuất phát từ vị trí (0,0)
        ratMazeUtil(0,0);      //xuất phát từ vị trí (0,0)
    }
    
    private static boolean ratMazeUtil(int x_curr, int y_curr) {    //vị trí hiện tại đã có thể đi đc, hàm này tìm vị trí tiếp theo để đi
        if(x_curr==N-1 && y_curr==N-1) {
            ghiNhan();
            return true;
        }
        int x_next, y_next, i;
        for (i = 0; i < 2; i++) {
            x_next = x_curr + xMove[i];
            y_next = y_curr + yMove[i];
            if(thuocTapUCV(x_next, y_next)) {
                sol[x_next][y_next] = 1;    //chấp nhận vị trí tiếp theo
                if(ratMazeUtil(x_next, y_next)) return true;    //nếu vị trí tiếp theo (x_next,y_next) có thể đi tới đích thì return true;
                else sol[x_next][y_next] = 0;   //ngược lại thì loại bỏ vị trí tiếp theo đó
            }
        }
        
        return false;
    }
    
    
    static void ghiNhan() {
        //printSolution: print array sol[][]
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        maze = new int [][] {
//            {1, 0, 0, 0},
//            {1, 1, 0, 1},
//            {0, 1, 0, 0},
//            {1, 1, 1, 1}
//        };
        
        maze = new int [][] {
            {1, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 0, 0},
            {1, 0, 1, 1, 0, 1, 1, 0},
            {1, 0, 0, 1, 1, 0, 0, 0},
            {0, 1, 1, 1, 0, 0, 0, 0},
            {0, 0, 0, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 0, 1, 1, 1},
            {0, 0, 0, 0, 0, 1, 0, 1}
        };
        N = maze[0].length;
        ratMaze();
    }

}
