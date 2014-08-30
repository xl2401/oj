public class Solution {
    public String strStr(String haystack, String needle) {
        int M = haystack.length();
        int N = needle.length();
        if (M < N) return null;
        if (M == 0 && N == 0) return "";
        for (int i = 0; i < haystack.length(); i++) {
            if (contains(haystack, needle, i)) return haystack.substring(i);
        }
        return null;
    }
    
    private boolean contains(String haystack, String needle, int start) {
        if (haystack.length() - start < needle.length())
            return false;
        for (int i = 0; i < needle.length(); i++) {
            if (haystack.charAt(start+i) != needle.charAt(i)) return false;
        }
        return true;
    }
}