public class Solution {
    public int maxSubArray(int[] A) {
    	if (A == null || A.length == 0) return Integer.MIN_VALUE;
    	int max = A[0];
    	int sum = 0;
    	for (int i = 0; i < A.length; i++) {
    		sum += A[i];
            // put check in the right place!
    		if (sum > max) 
                max = sum;
            // then fix
    		if (sum < 0) {
    			// reset
    			sum = 0;
    		}
    	}
    	return max;
    }
}
