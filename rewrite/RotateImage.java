public class Solution {
    public void rotate(int[][] matrix) {
    	if (matrix == null) return;
        int N = matrix.length;
        for (int layer = 0; layer < N/2; layer++) {
            int start = layer;
            int end = N - layer - 1;
            for (int offset = 0; offset < N-2*layer-1; offset++) {
                int tmp = matrix[start][start+offset];
                matrix[start][start+offset] = matrix[end-offset][start];
                matrix[end-offset][start] = matrix[end][end-offset];
                matrix[end][end-offset] = matrix[start+offset][end];
                matrix[start+offset][end] = tmp;
            }
        }
    }
}