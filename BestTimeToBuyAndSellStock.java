public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int[] diff = new int[prices.length-1];
        for (int i = 1; i < prices.length; i++){
            diff[i-1] = prices[i] - prices[i-1];
        }
        int sum = diff[0];
        int max = diff[0];
        for (int i = 1; i < diff.length; i++){
            int newsum = sum + diff[i];
            if (newsum < diff[i]){
                sum = diff[i];
            }
            else sum = newsum;
            if (sum > max) max = sum;
        }
        if (max < 0) max = 0;
        return max;
    }
}
