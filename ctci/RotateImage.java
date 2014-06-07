/*
 * 1.6
 * Rotate an N*N matrix clockwise
 *
 * Solution:
 * simple loop
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int N = matrix[0].length;
        for (int layer = 0; layer < N / 2; layer++){
            // use tmp variable like start and end wisely
            int start = layer;
            int end = N - layer - 1;
            for (int offset = 0; offset < end; offset++) {
                int tmp = matrix[start][start+offset];
                matrix[start][start+offset] = matrix[end-offset][start];
                matrix[end-offset][start] = matrix[end][end-offset];
                matrix[end][end-offset] = matrix[start+offset][end];
                matrix[start+offset][end] = tmp;
            }
        }
    }

    public static void main(String[] args){
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        new RotateImage().rotate(matrix);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
