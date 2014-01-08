/**
 * Title: Unique Paths 
 * Desciption:
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below)
 * The robot can only move either down or right at any point in time,
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below)
 * How many possible unique paths are there?
 *
 * Solution:
 * 1 Calculate C(m+n-2, n-1), be careful of precision overflow, find gcd and divide first
 * 2 DP
 */
public class UniquePath {
    public int uniquePaths(int m, int n) {
        int p = m + n - 2;
        int q = n - 1;
        return C(p, q);
    }

    public int gcd(int a, int b){
        if (a < b){
            int temp = a;
            a = b;
            b = temp;
        }
        while (b != 0){
            int c = a % b;
            a = b;
            b = c;
        }
        return a;
    }

    public int C(int m, int n){
        if (n > m - n) n = m - n;
        int result = 1;
        for (int i = 1; i <= n; i++){
            int multi = m;
            int divi = i;
            int g = gcd(multi, divi);
            multi /= g;
            divi /= g;
            result /= divi;
            result *= multi;
            m--;
        }
        return result;
    }

    /**
     * DP EDITION
     */
    public int uniquePathsDP(int m, int n){
        // matrix result[i][j] represent:
        // there are result[i][j] ways to reach the current cube
        // result[i][j] equals left and upper cube value
        int[][] result = new int[m][n];
        for (int i = 0; i < n; i++){
            result[0][i] = 1;
        }
        for (int i = 0; i < m; i++){
            result[i][0] = 1;
        }
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                result[i][j] = result[i][j-1] + result[i-1][j];
            }
        }
        return result[m-1][n-1];
    }

    public static void main(String[] args){
        System.out.println(new UniquePath().uniquePathsDP(3, 7));
    }
}
