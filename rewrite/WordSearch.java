public class Solution {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) return true;
        int M = board.length;
        int N = board[0].length;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (helper(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, int idx, int i, int j) {
        int M = board.length;
        int N = board[0].length;
        if (idx == word.length()) return true;
        if (i < 0 || j < 0 || i >= M || j >= N) return false;
        if (board[i][j] != word.charAt(idx)) return false;
        board[i][j] = '.';
        if (helper(board, word, idx+1, i-1, j)) return true;
        if (helper(board, word, idx+1, i, j-1)) return true;
        if (helper(board, word, idx+1, i+1, j)) return true;
        if (helper(board, word, idx+1, i, j+1)) return true;
        board[i][j] = word.charAt(idx);
        return false;
    }
}