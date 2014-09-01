public class Solution {
    public String reverseWords(String s) {
        if (s == null) return "";
        s = s.trim();
        if (s.isEmpty()) return "";
        String[] strs = s.split("\\s+");
        reverse(strs);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            if (i != 0) {
                sb.append(" ");
            }
            sb.append(strs[i]);
        }
        return sb.toString();
    }

    private void reverse(String[] strs) {
        int i = 0;
        int j = strs.length - 1;
        while (i < j) {
            String tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
            i++;
            j--;
        }
    }
}