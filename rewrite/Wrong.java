public class Solution {
    private int[][] rowVisit;
    private int[][] colVisit;
    private int[][] gridVisit;

    public void solveSudoku(char[][] board) {
        rowVisit = new int[9][10];
        colVisit = new int[9][10];
        gridVisit = new int[9][10];
        // init visit history
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') fill(i, j, board[i][j]-'0');
            }
        }
        solve(board, 0);
    }

    private int gridIdx(int i, int j){
        return i / 3 * 3 + j / 3;
    }

    private boolean solve(char[][] board, int idx) {
        if (idx > 80) return true;
        int row = idx / 9;
        int col = idx - 9 * row;
        if (board[row][col] != '.') return solve(board, idx+1);
        for (char val = '1'; val <= '9'; val++) {
            if (isValid(row, col, val-'0')) {
                board[row][col] = val;
                fill(row, col, val-'0');
                if (solve(board, idx+1)) return true;
                clear(row, col, val-'0');
            }
        }
        board[row][col] = '.';
        return false;
    }

    // before insert val, if valid?
    private boolean isValid(int i, int j, int val) {
        return !(rowVisit[i][val] == 1
                || colVisit[i][val] == 1
                || gridVisit[gridIdx(i, j)][val] == 1);
    }

    // update visit record
    private void fill(int i, int j, int val) {
        rowVisit[i][val] = 1;
        colVisit[j][val] = 1;
        gridVisit[gridIdx(i, j)][val] = 1;
    }

    // clear visit record
    private void clear(int i, int j, int val) {
        rowVisit[i][val] = 0;
        colVisit[j][val] = 0;
        gridVisit[gridIdx(i, j)][val] = 0;
    }
}