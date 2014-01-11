import java.util.ArrayList;

/*
 * Title:
 * Valid Sudoku 
 * Description:
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 * Solution:
 * just determine if element duplicate
 * doesn't mean solution of sudoku exists
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int[][] line = new int[9][9];
        int[][] col = new int[9][9];
        int[][] block = new int[9][9];

        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if (board[i][j] == '.')
                    continue;
                int c = board[i][j] - '1';
                int bIdx = i / 3 * 3 + j / 3;
                if (line[i][c] == 1 || col[j][c] == 1 || block[bIdx][c] == 1)
                    return false;
                else
                    line[i][c] = col[j][c] = block[bIdx][c] = 1;
            }
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println('1' - '1');
    }
}
