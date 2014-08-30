public class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < prices.length-1; i++) {
            int diff = prices[i+1] - prices[i];
            sum += diff;
            if (sum < 0) sum = 0;
            else {
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}