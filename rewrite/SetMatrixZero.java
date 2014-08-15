public class Solution {
    public void setZeroes(int[][] matrix) {
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
            	break;
            }
        }
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // clear
        for (int i = 1; i < M; i++) {
        	if (matrix[i][0] == 0) {
                for (int j = 0; j < N; j++) { 
                	matrix[i][j] = 0;
                }
        	}
        }
        for (int j = 1; j < N; j++) {
            if (matrix[0][j] == 0) {
            	for (int i = 0; i < M; i++) {
            		matrix[i][j] = 0;
            	}
            }
        }
        if (firstLineZero) {
        	for (int j = 0; j < N; j++)
        		matrix[0][j] = 0;
        }
        if (firstColZero) {
        	for (int i = 0; i < M; i++) 
        		matrix[i][0] = 0;
        }
    }
}


