/*
 * Title:
 * Interleaving String
 *
 * Description:
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 *
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 *
 * Solution:
 * DP
 * isLeave represent if s1.substring(0,i) and s2.substring(0,j) is the interleave of s3.substring(0, i+j)
*/
public class InterleaveStrDP {
    public boolean isInterleave1(String s1, String s2, String s3) {
        int M = s1.length();
        int N = s2.length();
        int P = s3.length();
        if (M+N != P)
            return false;
        boolean[][] isLeave = new boolean[M+1][N+1];
        isLeave[0][0] = true;
        for (int i = 1; i <= M; i++){
            isLeave[i][0] = s1.substring(0, i).equals(s3.substring(0, i));
        }
        for (int j = 1; j <= N; j++){
            isLeave[0][j] = s2.substring(0, j).equals(s3.substring(0, j));
        }

        for (int i = 1; i <= M; i++){
            for (int j = 1; j <= N; j++){
                isLeave[i][j] = isLeave[i-1][j] && s3.charAt(i+j-1) == s1.charAt(i-1)
                    || isLeave[i][j-1] && s3.charAt(i+j-1) == s2.charAt(j-1);
            }
        }
        return isLeave[M][N];
    }

    public static void main(String[] args){
        InterleaveStrDP is = new InterleaveStrDP();
        String s1 = "abbbbbbcabbacaacccababaabcccabcacbcaabbbacccaaaaaababbbacbb";
        String s2 = "ccaacabbacaccacababbbbabbcacccacccccaabaababacbbacabbbbabc";
        String s3 = "cacbabbacbbbabcbaacbbaccacaacaacccabababbbababcccbabcabbaccabcccacccaabbcbcaccccaaaaabaaaaababbbbacbbabacbbacabbbbabc";
        System.out.println(is.isInterleave(s1,s2,s3));
    }
}
