import java.util.LinkedList;

public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int M = board.length;
        int N = board[0].length;
        for (int i = 0; i < M; i++) {
            expand(board, i, 0);
            expand(board, i, N-1);
        }
        for (int j = 1; j < N-1; j++) {
            expand(board, 0, j);
            expand(board, M-1, j);
        }
        mark(board);
    }

    private void mark(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'E') board[i][j] = 'O';
            }
        }
    }

    // DFS will result in stack overflow, so use BFS
    private void expand(char[][] board, int i, int j) {
        int M = board.length;
        int N = board[0].length;
        if (board[i][j] == 'O') {
            LinkedList<int[]> queue = new LinkedList<int[]>();
            // visit
            board[i][j] = 'E';
            queue.add(getPair(i, j));
            while (!queue.isEmpty()) {
                int[] pair = queue.poll();
                int p = pair[0];
                int q = pair[1];
                // add neighbors
                if (p > 0 && board[p-1][q] == 'O'){
                    queue.add(getPair(p-1, q));
                    board[p-1][q] = 'E';
                }
                if (p < M-1 && board[p+1][q] == 'O') {
                    queue.add(getPair(p + 1, q));
                    board[p+1][q] = 'E';
                }
                if (q > 0 && board[p][q-1] == 'O') {
                    queue.add(getPair(p, q - 1));
                    board[p][q-1] = 'E';
                }
                if (q < N-1 && board[p][q+1] == 'O') {
                    queue.add(getPair(p, q + 1));
                    board[p][q+1] = 'E';
                }
             }
        }
    }

    private int[] getPair(int i, int j) {
        int[] pair = {i, j};
        return pair;
    }
}
