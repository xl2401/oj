/*
 * Title: Palindrome Partitioning II 
 * Description:
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 *
 * Solution:
 * DP, cutRec record: to the from first char to ith char, the min cut
 * in very loop we make decision where to cut
 * Pay attention, we use isPalinRec to decide if i, j is a palindrome,
 * this improve isPalindrome to O(1)
 */
public class PalindromePartition2 {
    public int minCut(String s) {
        int N = s.length();
        int[] cutRec = new int[N+1];
        boolean[][] isPalinRec = new boolean[N][N];
        cutRec[0] = 0;
        for (int i = 1; i <= N; i++){
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++){
                if (isPalindrom(s, i-j, i-1, isPalinRec)){
                    if (i-j != 0)
                        // update min
                        min = Math.min(min, cutRec[i-j]+1);
                    else
                        min = 0;
                }
            }
            cutRec[i] = min;
        }
       return cutRec[N];
    }

    public boolean isPalindrom(String a, int i, int j, boolean[][] isPalinRec){
        if (a.charAt(i) == a.charAt(j)){
            if (i == j || j-i == 1){
                isPalinRec[i][j] = true;
                return true;
            }
            else {
                isPalinRec[i][j] = isPalinRec[i+1][j-1];
                return isPalinRec[i][j];
            }
        }
        else{
            return false;
        }
    }

    public static void main(String[] args){
        PalindromePartition2 pp = new PalindromePartition2();
        System.out.println(pp.minCut("abbab"));
    }
}
