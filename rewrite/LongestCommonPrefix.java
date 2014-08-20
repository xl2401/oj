public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String first = strs[0];
        int i = 0;
        while (i < first.length()) {
            boolean common = true;
            char c = first.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                String str = strs[j];
                if (str.length() <= i || str.charAt(i) != c) {
                    common = false;
                    break;
                }
            }
            if (common) i++;
            else break;
        }
        return first.substring(0, i);
    }
}
