import java.util.HashMap;

/*
 * Title:Surrounded Regions 
 * Description:
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region .
 *
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 * Solution:
 * The basic thought is that inner 'O' which can be reached by expansion from the border 'O' cannot be flipped
 * otherwise, it should be flipped
 * pay attention to the recursive traverse expand method
 */
public class SurRegion {
    int M = 0;
    int N = 0;

    public void solve(char[][] board) {
        M = board.length;
        if (M == 0) return;
        N = board[0].length;
        if (N == 0) return;
        // expand from 4 borders
        for (int i = 1; i < M; i++){
            if (board[i][0] == 'O')
                expand(board, i, 1);
            if (board[i][N-1] == 'O')
                expand(board, i, N-2);
        }
        for (int j = 1; j < N; j++){
            if (board[0][j] == 'O')
                expand(board, 1, j);
            if (board[M-1][j] == 'O')
                expand(board, M-2, j);
        }

        // set 'S' to 'O' and 'O'(not reach by expand) to 'X'
        for (int i = 1; i < M-1; i++){
            for (int j = 1; j < N-1; j++){
                if (board[i][j] == 'S')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

    /*
     * Recursively expand the cur char come from the border 'O'
     * set it to 'S' when the cur is 'O'
     */
    public void expand(char[][] board, int i, int j){
        if (i > 0 && i < M-1 && j > 0 && j < N-1){
            char cur = board[i][j];
            if (cur == 'S' || cur == 'X')
                return;
            else{// cur == 'O'
                board[i][j] = 'S';
                expand(board, i-1, j);
                expand(board, i+1, j);
                expand(board, i, j-1);
                expand(board, i, j+1);
            }
        }
        else
            return;
    }

    public static void main(String[] args){
        char[][] board = 
        {
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };
        SurRegion sr = new SurRegion();
        sr.solve(board);
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
