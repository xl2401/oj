public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) return false;
        int N = s1.length();
        if (N == 0) return true;
        boolean[][][]  S = new boolean[N][N][N+1];
        for (int i = N-1; i >= 0; i--) {
            for (int j = N-1; j >= 0; j--) {
                for (int len = 1; len <= N-Math.max(i, j); len++) {
                    // base case
                    if (len == 1) {
                        S[i][j][len] = s1.charAt(i) == s2.charAt(j);
                        continue;
                    }
                    boolean subScramble = false;
                    for (int l = 1; l < len; l++) {
                        if (S[i][j][l] && S[i+l][j+l][len-l]) subScramble = true;
                        if (S[i][j+len-l][l] && S[i+l][j][len-l]) subScramble = true;
                        if (subScramble) break;
                    }
                    S[i][j][len] = subScramble;
                }
            }
        }
        return S[0][0][N];
    }
}