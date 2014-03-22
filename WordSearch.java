/*
 * Title: Word Search
 * Description:
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * For example,
 * Given board =
 *
 * [
 *   ["ABCE"],
 *   ["SFCS"],
 *   ["ADEE"]
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 *
 * Solution:
 * check at every coordinate, start at that coordinate, use DFS to check if match
 * maintain a visited to prevent multi use
 * remember if not a match, revise the visited status
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        boolean ex = false;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (exist(board, visited, i, j, word, 0)){
                    ex = true;
                    break;
                }
            }
        }
        return ex;
    }

    // check if the word exists starting at (i, j)
    public boolean exist(char[][] board, boolean[][] visited, int i, int j, String word, int idx){
        if (idx == word.length()) return true;
        int m = board.length;
        int n = board[0].length;
        // out of bound check
        if (i < 0 || j < 0 || i >= m || j >= n) return false;
        // has used?
        if (visited[i][j]) return false;
        char boardChar = board[i][j];
        char wordChar = word.charAt(idx);
        if (boardChar != wordChar) return false;
        else{
            // current match
            visited[i][j] = true;
            if (exist(board, visited, i-1, j, word, idx+1) || exist(board, visited, i+1, j, word, idx+1) ||
                    exist(board, visited, i, j+1, word, idx+1) || exist(board, visited, i, j-1, word, idx+1)){
                // either direction match
                return true;
            }
            // not match
            // recover visited to false <VERY IMPORTANT>
            visited[i][j] = false;
            return false;
        }
    }

    public static void main(String[] args){
        char[][] board = {
            {'A', 'A'},
        };
        WordSearch ws = new WordSearch();
        System.out.println(ws.exist(board, "AAA"));
    }
}
