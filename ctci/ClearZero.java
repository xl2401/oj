/*
 * 1.7
 * Given an M*N matrix, if the element is 0, the corresponding line & col are all set to 0
 *
 * Solution:
 * use the first line and col as storage for if the line or col is zero
 * but pay attention, first check if first line or col contains 0
 */
public class ClearZero {
    public void clearZero(int[][] matrix) {
        boolean firstLineZero = false;
        boolean firstColZero = false;
        int M = matrix.length;
        int N = matrix[0].length;
        for (int i = 0; i < M; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }
        for (int j = 0; j < N; j++) {
            if (matrix[0][j] == 0) {
                firstLineZero = true;
            }
        }
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++){
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 0; i < M; i++) {
            if (matrix[i][0] == 0) {
                // clear all this line
                for (int j = 1; j < N; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < N; j++) {
            if (matrix[0][j] == 0) {
                // clear all this col
                for (int i = 1; i < M; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        // check first line and col
        if (firstColZero) {
            for (int i = 0; i < M; i++) {
                matrix[i][0] = 0;
            }
        }
        if (firstLineZero) {
            for (int j = 0; j < N; j++) {
                matrix[0][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 0, 6},
            {7, 8, 9}
        };
        new ClearZero().clearZero(matrix);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
