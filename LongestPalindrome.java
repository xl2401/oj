/*
 * Title: Longest Palindromic Substring 
 * Description:
 * Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 *
 * Solution:
 * The very naive method is to choose two idx as start and end and judge if it is a palindrome,
 * however this method is O(n^3), so it's very slow.
 *
 * Use DP can improve the complexity to O(n^2)
 * How to break the palindrome problem into smaller problem?
 * consider str of idx i, j(i < j && j-i>1). if str[i] == str[j] than we need str.substring(i+1, j) to be palindrome
 * so the len of subproblem is originallen-2, so we can solve shorter string first, from 1-> N
 * the matrix isPal record if str from i to j is palindrome, if yes, the item will be 1
 *
 * !!! Another solution:
 * The DP solution solve this problem in O(N^2), and use O(N^2) space
 * the following method use O(N^2) time and C space:
 * we pick a point or the space between 2 num to be the center of the palindrome, so there are N+N-1 = 2N-1 centers,
 * try to expand from the center and reach the max palindrome, expansion takes O(N), so in total O(N^2)
 * No extra space needed.
 * See LongestPalindrome2.java for code
 *
 * There exists O(N) solutions:
 * see http://www.felix021.com/blog/read.php?2040
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int N = s.length();
        int[][] isPal = new int[N][N];
        int max = 0;
        int start = 0;
        int end = 0;
        for (int l = 1; l <= N; l++){// len of the s
            for (int i = 0; i < N-l+1; i++){
                if (s.charAt(i) == s.charAt(i+l-1)){
                    if (l == 1 || l == 2){
                        isPal[i][i+l-1] = 1;
                        if (l > max){
                            max = l;
                            start = i;
                            end = i+l-1;
                        }
                    }
                    else if (isPal[i+1][i+l-2] == 1){
                        isPal[i][i+l-1] = 1;
                        if (l > max){
                            max = l;
                            start = i;
                            end = i+l-1;
                        }
                    }
                }
            }
        }
        return s.substring(start, end+1);
    }

    public static void main(String[] args){
        System.out.println(new LongestPalindrome().longestPalindrome("caba"));
    }
}
