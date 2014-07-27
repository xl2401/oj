public class Solution {
	// same as fibo
    public int climbStairs(int n) {        
    	if (n == 0) return 1;
    	int[] buff = new int[n+1];
    	buff[0] = 1;
    	buff[1] = 1;
    	for (int i = 2; i <= n; i++) {
    		buff[i] = buff[i-1] + buff[i-2];
    	}
    	return buff[n];
    }
}