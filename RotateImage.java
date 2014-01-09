/*
 * Title: Rotate Image
 * Description:
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * Follow up:
 * Could you do this in-place?
 *
 * Solution:
 * divide the matrix into several layers
 * clockwise swap 4 numbers
 * the tricky part is to find the right index of the 4 numbers
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix == null) return;
        if (matrix[0] == null) return;
        int N = matrix.length;
        int numOfLayer = N / 2;
        for (int i = 0; i < numOfLayer; i++){
            rotateLayer(i, matrix);
        }
    }

    public void rotateLayer(int layer, int[][] A){
        int N = A.length;
        for (int i = 0; i < N-2*layer-1; i++){
            int temp1 = A[layer][layer+i];
            A[layer][layer+i] = A[N-1-layer-i][layer];
            int temp2 = A[layer+i][N-1-layer];
            A[layer+i][N-1-layer] = temp1;
            int temp3 = A[N-1-layer][N-1-layer-i];
            A[N-1-layer][N-1-layer-i] = temp2;
            A[N-1-layer-i][layer] = temp3;
        }
    }
}
