public class Solution {
    public boolean isMatch(String s, String p) {
        return helper(s, 0, p, 0);
    }

    private boolean helper(String s, int sIdx, String p, int pIdx) {
        // base condition
        if (pIdx == p.length()) {
            return sIdx == s.length();
        }
        // next is not *
        if (pIdx == p.length()-1 || p.charAt(pIdx+1) != '*') {
            if (sIdx == s.length()) return false;
            return (s.charAt(sIdx) == p.charAt(pIdx) || p.charAt(pIdx) == '.')
                    && helper(s, sIdx+1, p, pIdx+1);
        } else {
            while (sIdx < s.length() 
                && (p.charAt(pIdx) == s.charAt(sIdx) 
                || p.charAt(pIdx) == '.')) {
                if (helper(s, sIdx, p, pIdx+2)) return true;
                sIdx++;
            }
            return helper(s, sIdx, p, pIdx+2);
        }
    }
}