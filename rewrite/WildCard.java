public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        int sIdx = 0;
        int pIdx = 0;
        int ps = -1;
        int ss = 0;
        while (sIdx < s.length()) {
            if (pIdx < p.length()) {
                if (p.charAt(pIdx) == '?' || p.charAt(pIdx) == s.charAt(sIdx)) {
                    pIdx++;
                    sIdx++;
                    continue;
                }
                if (p.charAt(pIdx) == '*') {
                    ps = pIdx++;
                    ss = sIdx;
                    continue;
                }
            }
            if (ps != -1) {
                sIdx = ++ss;
                pIdx = ps + 1;
                continue;
            }
            return false;
        }
        while (pIdx < p.length() && p.charAt(pIdx) == '*') pIdx++;
        return pIdx == p.length();
    }
}