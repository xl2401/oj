import java.util.ArrayList;

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
 * the solution can be expressed in a one-dimension array
 * int[] sol: sol[k] represent: in the kth row, which col idx do we choose to be the Queen
 * Use DFS, check every col in the current row and check the next row
 */
public class NQueens {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> res = new ArrayList<String[]>();
        // for each line, which col to place the queen
        int[] sol = new int[n];
        solveHelper(sol, res, 0, n);
        return res;
    }

    /*
     * Generate a line. e.g. ..Q..
     * the `col`th element is Q
     * the length of the line is n
     */
    private String generateLine(int col, int n){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++){
            if (i == col){
                sb.append('Q');
            }
            else{
                sb.append('.');
            }
        }
        return sb.toString();
    }

    /*
     * Generate String[] according to sol
     */
    private String[] generateSol(int[] sol){
        int n = sol.length;
        String[] sols = new String[n];
        for (int i = 0; i < n; i++){
            sols[i] = generateLine(sol[i], n);
        }
        return sols;
    }

    /*
     * Check if the (row, col) cordinate is OK to place a queen
     * only check rows before `row`
     */
    private boolean isValid(int row, int col, int[] sol){
        for (int rowToCheck = 0; rowToCheck < row; rowToCheck++){
            if (col == sol[rowToCheck] || Math.abs(row - rowToCheck) == Math.abs(col - sol[rowToCheck])){
                return false;
            }
        }
        return true;
    }

    /*
     * recursion
     * every layer is to check the current row
     * check every column of the current row
     * int[] sol: the column idx of the queen in the corresponding row!
     */
    private void solveHelper(int[] sol, ArrayList<String[]> res, int row, int n){
        if (row == n){// bottom out
            String[] solFormat = generateSol(sol);
            res.add(solFormat);
            return;
        }
        for (int col = 0; col < n; col++){
            if (isValid(row, col, sol)){
                sol[row] = col;
                solveHelper(sol, res, row+1, n);
            }
        }
    }
}
