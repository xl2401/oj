public class Solution {
    public int numDecodings(String s) {
        if (s == null) return 0;
        int N = s.length();
        if (N == 0) return 0;
        int[] C = new int[N+1];
        C[N] = 1;
        for (int i = N-1; i >= 0; i--) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') return 0;
            if (i == N-1) {
                C[i] = s.charAt(i) == '0' ? 0 : 1;
            } else {
                if (s.charAt(i) == '0') {
                    C[i] = 0;
                } else {
                    int cur = C[i+1];
                    int sum = (s.charAt(i) - '0') * 10 + s.charAt(i+1) - '0';
                    if (sum <= 26)
                        cur += C[i+2];
                    C[i] = cur;
                }
            }
        }
        return C[0];
    }
}