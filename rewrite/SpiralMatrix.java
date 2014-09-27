public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) return res;
        int m = matrix.length;
        int n = matrix[0].length;
        spiral(res, matrix, m, n, 0);
        return res;
    }

    private void spiral(List<Integer> res, int[][] mat, int m, int n, int layer) {
        if (m <= 0 || n <= 0) return;
        if (m == 1) {
            for (int j = layer; j < layer + n; j++)
                res.add(mat[layer][j]);
        }
        if (n == 1) {
            for (int i = layer; i < layer + m; i++)
                res.add(mat[i][layer]);
        }
        int start = layer;
        int colEnd = layer + n - 1;
        int rowEnd = layer + m - 1;
        // left to right
        for (int j = start; j < colEnd; j++)
            res.add(mat[start][j]);
        // top to btm
        for (int i = start; i < rowEnd; i++)
            res.add(mat[i][colEnd];
        // right to left
        for (int j = colEnd; j > start; j--) {
            res.add(mat[rowEnd][j]);
        }
        // btm to top
        for (int i = rowEnd; i > start; i--) {
            res.add(mat[i][start]);
        }
        spiral(res, mat, m-2, n-2, layer+1);
    }
}

