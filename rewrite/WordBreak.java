import java.util.Set;

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        int N = s.length();
        boolean[] validTil = new boolean[N+1];
        validTil[0] = true;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                if (validTil[j] && dict.contains(s.substring(j, i))) {
                    validTil[i] = true;
                    break;
                }
            }
        }
        return validTil[N];
    }
}