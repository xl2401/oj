public class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 0; i < prices.length-1; i++) {
            int diff = prices[i+1] - prices[i];
            sum += diff >= 0 ? diff : 0;
        }
        return sum;
    }
}