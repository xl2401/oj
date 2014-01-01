public class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        if (N == 0) return 0;
        int[] priceDiff = new int[N-1];
        for (int i = 1; i < N; i++){
            priceDiff[i-1] = prices[i] - prices[i-1];
        }
        int sum = 0;
        for (int i = 0; i < N-1; i++){
            if (priceDiff[i] > 0){
                sum += priceDiff[i];
            }
        }
        return sum;
    }
}
