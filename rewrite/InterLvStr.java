public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (!checkValid(s1, s2, s3)) return false;
        int M = s1.length();
        int N = s2.length();
        boolean[][] isIntLv = new boolean[M + 1][N + 1];
        for (int i = 0; i <= M; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == 0 && j == 0) {
                    isIntLv[0][0] = true;
                    continue;
                }
                isIntLv[i][j] =
                        ((i == 0 ? false : isIntLv[i - 1][j]) && s3.charAt(i + j - 1) == s1.charAt(i - 1))
                     || ((j == 0 ? false : isIntLv[i][j - 1]) && s3.charAt(i + j - 1) == s2.charAt(j - 1));
            }
        }
        return isIntLv[M][N];
    }

    private boolean checkValid(String s1, String s2, String s3) {
        String comb = s1 + s2;
        if (comb.length() != s3.length()) return false;
        char[] array = comb.toCharArray();
        Arrays.sort(array);
        comb = new String(array);
        array = s3.toCharArray();
        Arrays.sort(array);
        String sortS3 = new String(array);
        return sortS3.equals(comb);
    }
}