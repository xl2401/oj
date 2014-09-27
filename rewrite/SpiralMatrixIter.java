public class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        List<Integer> res = new ArrayList<Integer>();
        if (mat == null || mat.length == 0) return res;
        int m = mat.length;
        int n = mat[0].length;
        int start = 0;
        while (m > 0 && n > 0) {
            int rowEnd = start + m - 1;
            int colEnd = start + n - 1;
            if (m == 1) {
                for (int j = start; j <= colEnd; j++)
                    res.add(mat[start][j]);
                break;
            }
            if (n == 1) {
                for (int i = start; i <= rowEnd; i++) 
                    res.add(mat[i][start]);
                break;
            }
            // left to right
            for (int j = start; j < colEnd; j++)
                res.add(mat[start][j]);
            // top to btm
            for (int i = start; i < rowEnd; i++)
                res.add(mat[i][colEnd]);
            // right to left
            for (int j = colEnd; j > start; j--)
                res.add(mat[rowEnd][j]);
            // btm to up
            for (int i = rowEnd; i > start; i--)
                res.add(mat[i][start]);
            m -= 2;
            n -= 2;
            start++;
        }
        return res;
    }
}