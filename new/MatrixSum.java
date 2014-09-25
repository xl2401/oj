import java.util.ArrayList;
import java.util.List;

/**
 * Given a square matrix and k, return the sum of all sum of subarray of size k*k
 * http://www.geeksforgeeks.org/given-n-x-n-square-matrix-find-sum-sub-squares-size-k-x-k/
 */
public class Solution {
    public List<Integer> sumSimple(int[][] mat, int k) {
        List<Integer> res = new ArrayList<Integer>();
        if (mat == null || mat.length == 0) return res;
        int n = mat.length;
        int[][] stripeSum = new int[n-k+1][n];
        // preprocess stripe sum, k * 1 column stripe
        // process column by column
        for (int j = 0; j < n; j++) {
            // first stripe of the column
            stripeSum[0][j] = sumStripe(mat, 0, j, k);
            for (int i = 1; i <= n - k; i++) {
                stripeSum[i][j] = stripeSum[i-1][j] - mat[i-1][j] + mat[i+k-1][j];
            }
        }
        // construct result
        // add column stripe
        // calculate line by line
        for (int i = 0; i <= n-k; i++) {
            int sum = 0;
            // first subarray
            for (int j = 0; j < k; j++) {
                sum += stripeSum[i][j];
            }
            res.add(sum);
            for (int j = 1; j <= n-k; j++) {
                sum = sum - stripeSum[i][j-1] + stripeSum[i][j+k-1];
                res.add(sum);
            }
        }
        return res;
    }

    private int sumStripe(int[][] mat, int p, int q, int k) {
        int sum = 0;
        for (int i = p; i < p+k; i++) {
            sum += mat[i][q];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2},
                {3, 3, 3, 3, 3},
                {4, 4, 4, 4, 4},
                {5, 5, 5, 5, 5},
        };
        List<Integer> res = new Solution().sumSimple(mat, 3);
        for (Integer i: res) {
            System.out.println(i);
        }
    }
}
