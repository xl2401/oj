/*
 * Title: Distinct Subsequences 
 * Description:
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 *
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 *
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 *
 * Return 3.
 *
 * Solution:
 * This is a similar problem to LCS
 * Use DP
 * C[i][j] represent numdistint S[1..i] T[1..j] note: idx is 1 based, 0 represent empty string
 * recursive formula:
 * C[i][j] = C[i-1][j-1] + C[i-1][j] when S[i] == T[j]
 *           C[i-1][j]               when S[i] != T[j]
 * The tricky part is the base condition
 * when j is 0, find every occurence of first char in T in S, C[idxFirst][0] = 1
 */
public class DistinctSubStr {
    public int numDistinct(String S, String T) {
        int M = S.length();
        int N = T.length();
        int[][] C = new int[M+1][N+1];
        // find first occur of first char of T
        int idxFirst = S.indexOf(T.charAt(0));
        if (idxFirst == -1) return 0;
        else{
            // for every occurence
            while (idxFirst >= 0){
                C[idxFirst][0] = 1;
                idxFirst = S.indexOf(T.charAt(0), idxFirst+1);
            }
        }
        for (int j = 1; j <= N; j++){
            for (int i = 1; i <= M; i++){
                if (S.charAt(i-1) == T.charAt(j-1)){
                    C[i][j] = C[i-1][j-1] + C[i-1][j];
                }
                else{
                    C[i][j] = C[i-1][j];
                }
            }
        }
        return C[M][N];
    }

    public static void main(String[] args){
        DistinctSubStr dss = new DistinctSubStr();
        System.out.println(dss.numDistinct("errabbbit", "rabbit"));
    }
}
