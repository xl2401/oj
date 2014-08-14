import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) return res;
        int M = matrix.length;
        int N = matrix[0].length;
        int layerMax = (Math.min(M, N) + 1) / 2;
        for (int layer = 0; layer < layerMax; layer++) {
            for (int j = layer; j < N-layer-1; j++)
                res.add(matrix[layer][j]);
            for (int i = layer; i < M-layer-1; i++)
                res.add(matrix[i][N-layer-1];
            if ((M-2*layer) == 1 || (N-2*layer) == 1) 
                break;
            for (int j = N-layer-1; j > layer; j--)
                res.add(matrix[M-layer-1][j];
            for (int i = M-layer-1; i > layer; i--)
                res.add(matrix[i][layer];
        }
        return res;
    }
}
