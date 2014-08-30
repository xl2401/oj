public class Solution {
    public int numDistinct(String S, String T) {
        int M = S.length();
        int N = T.length();
        int[][] C = new int[M+1][N+1];
        // init
        for (int i = 0; i <= M; i++) C[i][0] = 1;
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (S.charAt(i-1) == T.charAt(j-1))
                    C[i][j] = C[i-1][j-1] + C[i-1][j];
                else
                    C[i][j] = C[i-1][j];
            }
        }
        return C[M][N];
    }
}