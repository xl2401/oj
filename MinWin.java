/*
 * Title: Minimum Window Substring
 * Description:
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 *
 * Note:
 * If there is no such window in S that covers all characters in T, return the emtpy string "".
 *
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 *
 * Solution:
 * use two pointers start/end to represent the idx of the window,
 * maintain needtofind, hasfound 256 ASKII map to record the cnt need to find and has found
 * maintain the cnt: the length of chars in the current window that is in T
 * once cnt reached M, advance start before it breaks the requirement
 * update min val
 * http://leetcode.com/2010/11/finding-minimum-window-in-s-which.html
 */
public class MinWin {
    public String minWindow(String S, String T) {
        int N = S.length();
        int M = T.length();
        int[] needToFind = new int[256];
        int[] hasFound = new int[256];
        int winStart = -1;
        int winEnd = -1;
        int start = 0;
        int end = 0;
        int cnt = 0;
        int winLen = Integer.MAX_VALUE;

        // scan target
        for (int i = 0; i < M; i++){
            char c = T.charAt(i);
            needToFind[c]++;
        }
        for (end = 0; end < N; end++){
            char c = S.charAt(end);
            if (needToFind[c] != 0){
                hasFound[c]++;
                if (hasFound[c] <= needToFind[c])
                    cnt++;
                // complete window
                if (cnt == M){
                    // advance start
                    while (needToFind[S.charAt(start)] == 0 
                            || needToFind[S.charAt(start)] < hasFound[S.charAt(start)]){
                        if (needToFind[S.charAt(start)] < hasFound[S.charAt(start)]){
                            hasFound[S.charAt(start)]--;
                        }
                        start++;
                    }
                    // update
                    int newLen = end - start + 1;
                    if (newLen < winLen){
                        winLen = newLen;
                        winStart = start;
                        winEnd = end;
                    }
                }
            }
        }
        if (winStart == -1) return "";
        else return S.substring(winStart, winEnd+1);
    }

    public static void main(String[] args){
        MinWin mw = new MinWin();
        System.out.println(mw.minWindow("ADOBECODEBANC", "ABC"));
    }
}
