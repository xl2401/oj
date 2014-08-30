public class Solution {
    public int minCut(String s) {
        int N = s.length();
        int[] D = new int[N+1];
        boolean[][] P = new boolean[N][N];
        for (int i = N-1; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < N; j++) {
                if (s.charAt(i) == s.charAt(j) && ((j-i < 2) || P[i+1][j-1])) {
                    P[i][j] = true;
                    min = Math.min(min, 1+D[j+1]);
                }
            }
            D[i] = min;
        }
        return D[0] - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minCut("ab"));
    }
}