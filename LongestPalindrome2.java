 /*
 * Title: Longest Palindromic Substring 
 * Description:
 * Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 *
 * Solution:
 * This is the solution that first pickup the center position and try to expand.
 * Pay attention that the center position could be between two numbers.
 */
public class LongestPalindrome2{
    public String longestPalindrome(String s){
        int max = 0;
        int start = 0;
        int end = 0;
        int N = s.length();
        for (int i = 0; i < 2 * N - 1; i++){
            int[] subIdx = expand(s, i);
            int curStart = subIdx[0];
            int curEnd = subIdx[1];
            if (curEnd - curStart + 1 > max){
                max = curEnd - curStart + 1;
                start = curStart;
                end = curEnd;
            }
        }
        return s.substring(start, end + 1);
    }
    
    /*
     * This method accept the idx: from 0 - 2N-2
     * calculate the start and end idx after expand
     * e.g. abcba, center is 'c', then expand, subIdx[0] = 0, subIdx[1] = 4
     */
    public int[] expand(String s, int idx){
        int[] subIdx = new int[2];
        // mod == 0: num, mod == 1 between
        int mod = idx % 2;
        int i = 0;
        int j = 0;
        if (mod == 0){
            i = idx / 2 - 1;
            j = idx / 2 + 1;
        }
        else{
           i = idx / 2;
           j = idx / 2 + 1;
        }
        while (i >= 0 && j < s.length()){
            if (s.charAt(i) == s.charAt(j)){
                i--;
                j++;
            }
            else{
                break;
            }
        }
        i++;
        j--;
        subIdx[0] = i;
        subIdx[1] = j;
        return subIdx;
    }

    public static void main(String[] args){
        System.out.println(new LongestPalindrome2().longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }
}
