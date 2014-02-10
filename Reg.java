/*
 * Title: Regular Expression Matching 
 * Description:
 * Implement regular expression matching with support for '.' and '*'.
 *
 * Solution:
 * the tricky part is how to deal with *
 * use recursion, try match each count of char that is *-ed
 * til current char of s is not a match of the *-ed char
 */
public class Reg {
    public boolean isMatch(String s, String p) {
        return isMatchHelper(s, p, 0, 0);
    }
    
    public boolean isMatchHelper(String s, String p, int sIdx, int pIdx){
        // note only if we use up p we can make decision, 
        // when use up s, p may remain *
        if (pIdx == p.length()){
            return sIdx == s.length();
        }
        int pLen = p.length();
        int sLen = s.length();
        // check if next char is *
        if (pIdx < pLen - 1 && p.charAt(pIdx+1) == '*'){
            // check match 0, 1, 2...
            while (sIdx < sLen && (s.charAt(sIdx) == p.charAt(pIdx) || p.charAt(pIdx) == '.')){
                if (isMatchHelper(s, p, sIdx, pIdx + 2)){
                    return true;
                }
                // match one more c
                sIdx++;
            }
            // * does not match any more, move on
            return isMatchHelper(s, p, sIdx, pIdx + 2);
        }
        else{
            if (sIdx != sLen){
                return (s.charAt(sIdx) == p.charAt(pIdx) || p.charAt(pIdx) == '.') 
                                                         && isMatchHelper(s, p, sIdx+1, pIdx+1);
            }
            else{
                // use up s, but p is not *
                return false;
            }
        }
    }
}
