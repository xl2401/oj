public class SetZero {
    public void setZeroes(int[][] matrix) {
        int M = matrix.length;
        if (M == 0) return;
        int N = matrix[0].length;
        boolean hasFirstColZero = false;
        boolean hasFirstLineZero = false;
        // check first line
        for (int j = 0; j < N; j++){
            if (matrix[0][j] == 0) hasFirstLineZero = true;
        }
        // check first col
        for (int i = 0; i < M; i++){
            if (matrix[i][0] == 0) hasFirstColZero = true;
        }
        // use the first line and column to store info
        for (int i = 0; i < M; i++){
            for (int j = 0; j < N; j++){
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // set zero, except the first line and col
        for (int i = 1; i < M; i++){
            for(int j = 1; j < N; j++){
                if (matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        // handle first line and column
        if (hasFirstColZero){
            for (int i = 0; i < M; i++){
                matrix[i][0] = 0;
            }
        }
        if (hasFirstLineZero){
            for (int j = 0; j < N; j++){
                matrix[0][j] = 0;
            }
        }
    }
}
