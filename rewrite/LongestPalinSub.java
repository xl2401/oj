public class Solution {
    public String longestPalindrome(String s) {
        int cnt = 0;
        String palin = "";
        char[] seq = s.toCharArray();
        for (int i = 0; i < seq.length; i++) {
            int curCnt = 1;
            int l = i - 1;
            int r = i + 1;
            while (l >= 0 && r < seq.length && seq[l] == seq[r]) {
                l--;
                r++;
                curCnt += 2;
            }
            if (curCnt > cnt) {
                cnt = curCnt;
                palin = s.substring(++l, r);
            }
        }
        for (int i = 0; i < seq.length-1; i++) {
            int curCnt = 0;
            int l = i;
            int r = i + 1;
            while (l >= 0 && r < seq.length && seq[l] == seq[r]) {
                l--;
                r++;
                curCnt += 2;
            }
            if (curCnt > cnt) {
                cnt  = curCnt;
                palin = s.substring(++l, r);
            }
        }
        return palin;
    }
}