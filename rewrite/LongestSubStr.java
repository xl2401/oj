import java.util.Arrays;

public class Solution{
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int max = 0;
        int N = s.length();
        int[] appearIdx = new int[256];
        Arrays.fill(appearIdx, -1);
        for (int i = 0; i < N; i++) {
            int lastIdx = appearIdx[s.charAt(i)];
            if (lastIdx >= start && lastIdx < i) {
                max = Math.max(max, i-start);
                start = lastIdx + 1;
            }
            appearIdx[s.charAt(i)] = i;
        }
        max = Math.max(max, N-start);
        return max;
    }
}