public class Solution {
    public String minWindow(String S, String T) {
        // null check
        if (S == null || T == null) return null;
        int SLen = S.length();
        int TLen = T.length();
        int[] toFind = new int[256];
        int[] found = new int[256];
        // cnt of chars which need to be found
        for (int i = 0; i < TLen; i++) {
            toFind[T.charAt(i)]++;
        }
        // start idx of win
        int startMin = -1;
        int endMin = -1;
        // cnt of found chars
        int cnt = 0;
        int min = Integer.MAX_VALUE;
        for (int end = 0, start = 0; end < SLen; end++) {
            char c = S.charAt(end);
            if (toFind[c] == 0) continue;
            if (toFind[c] > found[c]) {// not full
                cnt++;
            }
            found[c]++;
            // advance start
            while (true) {
                char sc = S.charAt(start);
                if (found[sc] == 0) start++;
                else if(found[sc] > toFind[sc]) {
                    found[sc]--;
                    start++;
                }
                else break;
            }
            // check min win
            if (cnt == TLen) {
                if (end - start + 1 < min) {
                    startMin = start;
                    endMin = end;
                    min = end - start + 1;
                }
            }
        }
        if (startMin == -1) return "";
        else return S.substring(startMin, endMin+1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
    }
}