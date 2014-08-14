public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int maxLayer = n / 2;
        int val = 1;
        for (int layer = 0; layer < maxLayer; layer++) {
            int start = layer;
            int end = n - layer - 1;
            for (int j = start; j < end; j++)
            	res[start][j] = val++;
            for (int i = start; i < end; i++)
            	res[i][end] = val++;
            for (int j = end; j > start; j--) 
            	res[end][j] = val++;
            for (int i = end; i > start; i--)
            	res[i][start] = val++;
        }
        if (n % 2 == 1) res[n/2][n/2] = val;
        return res;
    }
}
