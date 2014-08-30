public class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        int N = ratings.length;
        int[] cand = new int[N];
        cand[0] = 1;
        for (int i = 1; i < N; i++) {
            if (ratings[i] > ratings[i-1]) cand[i] = cand[i-1] + 1;
            else cand[i] = 1;
        }
        for (int i = N-2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) cand[i] = Math.max(cand[i], cand[i+1] + 1);
        }
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += cand[i];
        }
        return sum;
    }
}