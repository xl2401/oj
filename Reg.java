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
        return isMatch(s, p, 0, 0);
    }

    public boolean isMatch(String s, String p, int sIdx, int pIdx){
        // end of either string
        if (pIdx == p.length())
            return sIdx == s.length();

        // last char or next char is not *
        if (pIdx == p.length()-1 || p.charAt(pIdx+1) != '*'){
            if (sIdx != s.length())
                return (p.charAt(pIdx) == '.' || p.charAt(pIdx) == s.charAt(sIdx))
                                          && isMatch(s, p, sIdx+1, pIdx+1);
            else
                return false;
        }
        // next char is *
        while (sIdx < s.length() && (p.charAt(pIdx) == s.charAt(sIdx) || p.charAt(pIdx) == '.')){
            if (isMatch(s, p, sIdx, pIdx+2))
                return true;
            sIdx++;
        }
        return isMatch(s, p, sIdx, pIdx+2);
    }

    public static void main(String[] args){
        System.out.println(new Reg().isMatch("a", "ab*"));
    }
}
