import java.util.ArrayList;
import java.util.Arrays;

/*
 * Title: N-Queens
 * Description:
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 *
 * [
 *  [".Q..",  // Solution 1
 *    "...Q",
 *    "Q...",
 *    "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 *
 * Solution:
 * this solution uses space O(n^2) to record the board, there's O(n) implementation, see NQueens.java
 */
public class NqueensBoard {
    public ArrayList<String[]> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++){
            Arrays.fill(board[i], '.');
        }
        ArrayList<String[]> res = new ArrayList<String[]>();
        placeQueen(board, 0, n, res);
        return res;
    }

    private boolean isValid(char[][] board, int row, int col){
        int n = board.length;
        // check col
        for (int i = 0; i < row; i++){
            if (board[i][col] == 'Q') return false;
        }
        // check diagonal
        int i = row - 1;
        int j = col - 1;
        while (i >= 0 && j >= 0 && i < n && j < n){
            if (board[i][j] == 'Q') return false;
            i--;
            j--;
        }
        i = row - 1;
        j = col + 1;
        while (i >= 0 && j >= 0 && i < n && j < n){
            if (board[i][j] == 'Q') return false;
            i--;
            j++;
        }
        return true;
    }

    private void placeQueen(char[][] board, int row, int n, ArrayList<String[]> res){
        if (row == n){// bottom out
            String[] sol = new String[n];
            for (int i = 0; i < n; i++){
               sol[i] = new String(board[i]);
            }
            res.add(sol);
        }
        for (int col = 0; col < n; col++){
            if (isValid(board, row, col)){
                board[row][col] = 'Q';
                placeQueen(board, row+1, n, res);
                // don't forget to recover, the board remains the same before the next col
                board[row][col] = '.';
            }
        }
    }
}
