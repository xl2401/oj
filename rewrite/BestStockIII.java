public class Solution {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        if (prices == null || N < 2) return 0;
        int[] maxList = new int[N-1];
        int[] maxRevList = new int[N-1];
        int sum = 0;
        int max = 0;
        for (int i = 1; i < N; i++) {
            sum += prices[i] - prices[i-1];
            if (sum < 0) sum = 0;
            else {
                max = Math.max(max, sum);
            }
            maxList[i-1] = max;
        }
        max = 0;
        sum = 0;
        for (int i = N-1; i >= 1; i--) {
            sum += prices[i] - prices[i-1];
            if (sum < 0) sum = 0;
            else {
                max = Math.max(max, sum);
            }
            maxRevList[i-1] = max;
        }
        max = maxRevList[0];
        for (int i = 0; i < N-1; i++) {
            int leftMax = maxList[i];
            int rightMax = i == N-2 ? 0 : maxRevList[i+1];
            max = Math.max(max, leftMax+rightMax);
        }
        return max;
    }
}