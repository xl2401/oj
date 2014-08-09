public class Solution {
    public int removeDuplicates(int[] A) {        
    	if (A == null || A.length == 0) return 0;
    	int dupTotalCnt = 0;
    	int dupCnt = 0;
    	for (int i = 1; i < A.length; i++) {
    		if (A[i] == A[i-1]) {
    			if (dupCnt > 0) {
    				dupTotalCnt++;
    			} else {
    			    A[i-dupTotalCnt] = A[i];
    			}
    			dupCnt++;
    		} else {
    			A[i-dupTotalCnt] = A[i];
    			dupCnt = 0;
    		}
    	}
    	return A.length - dupTotalCnt;
    }
}