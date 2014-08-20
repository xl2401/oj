public class Solution {
    public int trap(int[] A) {        
    	int N = A.length;
        int[] lMax = new int[N];
        int[] rMax = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {	
            lMax[i] = max;
        	if (A[i] > max) 
        		max = A[i];
        }
        max = 0;
        for (int i = N-1; i >= 0; i--) {
            rMax[i] = max;
        	if (A[i] > max) 
        		max = A[i];
        }
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int val = Math.min(lMax[i], rMax[i]) - A[i];
            sum += val > 0 ? val : 0;
        }
        return sum;
    }
}
