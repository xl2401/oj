public class Solution {
    public boolean isValidSudoku(char[][] board) {
    	int M = board.length;
    	int N = board[0].length;
        // check horizontal
        for (int i = 0; i < M; i++) {
        	if (!isValid(board[i])) return false;
        }
        // check vertical
        for (int j = 0; j < N; j++) {
            char[] col = new char[9];
            for (int i = 0; i < M; i++) {
            	col[i] = board[i][j];
            }
            if (!isValid(col)) return false;
        }
        // check grid
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
            	char[] grid = new char[9];
            	int idx = 0;
                for (int p = i*3; p < i*3+3; p++) {
                    for (int q = j*3; q < j*3+3; q++) {
                    	grid[idx++] = board[p][q];
                    }
                }
                if (!isValid(grid)) return false;
            }
        }
        return true;
    }
    
    private boolean isValid(char[] list) {
        HashSet<Character> set = new HashSet<Character>();
        for (char c: list) {
        if (c != '.') {
        	if (set.contains(c)) return false;
        	set.add(c);
        }
        }
        return true;
    }
}