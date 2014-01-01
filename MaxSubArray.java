import java.util.ArrayList;

public class MaxSubArray {
    public int maxSubArray(int[] A) {
        int N = A.length;
        if (N == 0){// Array is empty
            return -1;
        }
        // here sum array: index i, sumArray.get(i) is the largest sum end at i!
        ArrayList<Integer> sumArray = new ArrayList<Integer>();
        sumArray.add(A[0]);
        for (int i = 1; i < N; i++){
            // compare current element and plus previous max sum
            int curSum = Math.max(sumArray.get(i-1) + A[i], A[i]);
            sumArray.add(curSum);
        }
        int maxSum = sumArray.get(0);
        for (int i = 1; i < N; i++){
            maxSum = Math.max(maxSum, sumArray.get(i));
        }
        return maxSum;
    }
}
