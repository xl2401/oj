class CntRes{
    public int cnt = 0;
}

/*
 * Title: N-Queens II
 * Description:
 * Follow up for N-Queens problem.
 *
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 *
 * Solution:
 * simpler version of NQueens.java
 */
public class NQueens2 {
    public int totalNQueens(int n) {
        CntRes cntRes = new CntRes();
        int[] sol = new int[n];
        solveHelper(sol, 0, n, cntRes);
        return cntRes.cnt;
    }

    private boolean isValid(int row, int col, int[] sol){
        for (int rowToCheck = 0; rowToCheck < row; rowToCheck++){
            if (col == sol[rowToCheck] || Math.abs(row - rowToCheck) == Math.abs(col - sol[rowToCheck])){
                return false;
            }
        }
        return true;
    }

    private void solveHelper(int[] sol, int row, int n, CntRes cntRes){
        if (row == n){// bottom out
            (cntRes.cnt)++;
        }
        for (int col = 0; col < n; col++){
            if (isValid(row, col, sol)){
                sol[row] = col;
                solveHelper(sol, row+1, n, cntRes);
            }
        }
    }
}
