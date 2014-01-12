/*
 * Title: Best Time to Buy and Sell Stock III 
 * Description:
 * transform to max subarray problem
 * Note: calculate max 0...i and max i+1...n
 * calculate max value in ascend and descend order
 */
public class BestTimeToBuyAndSellStock3 {
    // max ascend: max sum from 0 to current i
    // max descend: max sum from n-1 to i
    public int[] maxAscend = null;
    public int[] maxDescend = null;

    public int maxProfit(int[] prices) {
        int N = prices.length-1;
        if (N < 1) return 0;
        int[] diff = new int[N];
        maxAscend = new int[N];
        maxDescend = new int[N];
        for (int i = 1; i < prices.length; i++){
            diff[i-1] = prices[i] - prices[i-1];
        }
        ascendMax(diff);
        descendMax(diff);
        int max = 0;
        for (int i = 0; i < maxAscend.length; i++){
            int dIdx = N-2-i;
            int leftMax = maxAscend[i] > 0? maxAscend[i]: 0;
            int rightMax = 0;
            if (dIdx >= 0)
                rightMax = maxDescend[dIdx] > 0? maxDescend[dIdx]: 0;
            int newsum = leftMax + rightMax;
            if (newsum > max)
                max = newsum;
        }
        return max;
    }

    public void ascendMax(int[] diff) {
        int sum = diff[0];
        int max = diff[0];
        maxAscend[0] = diff[0];
        for (int i = 1; i < diff.length; i++){
            int newsum = sum + diff[i];
            if (newsum < diff[i]){
                sum = diff[i];
            }
            else sum = newsum;
            if (sum > max)
                max = sum;
            maxAscend[i] = max;
        }
    }

    public void descendMax(int[] diff){
        int N = diff.length;
        int sum = diff[N-1];
        int max = diff[N-1];
        maxDescend[0] = diff[N-1];
        for (int i = N-2; i >= 0; i--){
            int idx = N-1-i;
            int newsum = sum + diff[i];
            if (newsum < diff[i])
                sum = diff[i];
            else sum = newsum;
            if (sum > max)
                max = sum;
            maxDescend[idx] = max;
        }
    }

    public static void main(String[] args){
        int[] A = {6,1,3,2,4,7};
        BestTimeToBuyAndSellStock3 b = new BestTimeToBuyAndSellStock3();
        System.out.println(b.maxProfit(A));
        int[] maxAscend = b.maxAscend;
        int[] maxDescend = b.maxDescend;
        for (int i = 0; i < maxAscend.length; i++){
            System.out.print(maxAscend[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < maxDescend.length; i++){
            System.out.print(maxDescend[i] + " ");
        }
        System.out.println();
    }
}
