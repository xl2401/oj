public class Solution {
    public int atoi(String str) {
        if (str == null || str.length() == 0) return 0;
        str = str.trim();
        if (str.equals(Integer.MIN_VALUE+"")) return Integer.MIN_VALUE;
        int neg = str.charAt(0) == '-' ? -1 : 1;
        int i = 0;
        if (str.charAt(0) == '-' || str.charAt(0) == '+') i++;
        int res = 0;
        boolean overflow = false;
        for (; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') break;
            int cur = str.charAt(i) - '0';
            // check for overflow
            if (res > Integer.MAX_VALUE/10) {
                overflow = true;
                break;
            }
            res *= 10;
            // check for overflow
            if (res > Integer.MAX_VALUE - cur) {
                overflow = true;
                break;
            }
            res += cur;
        }
        if (overflow) return neg == -1? Integer.MIN_VALUE : Integer.MAX_VALUE;
        return res * neg;
    }
}
