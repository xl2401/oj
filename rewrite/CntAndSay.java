public class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String prev = countAndSay(n-1);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < prev.length()) {
            char c = prev.charAt(i);
            int cnt = 0;
            while (i < prev.length() && prev.charAt(i) == c) {
                cnt++;
                i++;
            }
            sb.append(cnt);
            sb.append(c);
        }
        return sb.toString();
    }
}