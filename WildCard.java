/*
 * Title: Wildcard Matching 
 * Description:
 * Implement wildcard pattern matching with support for '?' and '*'.
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 *
 * The matching should cover the entire input string (not partial).
 *
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 *
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 *
 * Solution:
 * http://yucoding.blogspot.com/2013/02/leetcode-question-123-wildcard-matching.html
 * pay attention, here we need to check pIdx < p.length()
 */
public class WildCard {
    public boolean isMatch(String s, String p) {
        int starIdx = -1;
        int sIdx = 0;
        int ssIdx = sIdx;
        int pIdx = 0;

        while (sIdx < s.length()){
            if (pIdx < p.length()){
                if (s.charAt(sIdx) == p.charAt(pIdx) || p.charAt(pIdx) == '?'){
                    sIdx++;
                    pIdx++;
                    continue;
                }
                if (p.charAt(pIdx) == '*'){// record the sIdx and the pIdx(the index of the start)
                    starIdx = pIdx++;
                    ssIdx = sIdx;
                    continue;
                }
            }
            if (starIdx != -1){// mismatch, but there is star before, reset the pIdx and sIdx
                pIdx = starIdx + 1;
                sIdx = ++ssIdx;
            }
            else{
                return false;
            }
        }
        // get rid of last *
        while (pIdx < p.length() && p.charAt(pIdx) == '*'){
            pIdx++;
        }
        return pIdx == p.length();
    }

    public static void main(String[] args){
        WildCard wc = new WildCard();
        String s = "cabcaabcb";
        String p = "c*a*b";
        System.out.println(wc.isMatch(s, p));
    }
}
