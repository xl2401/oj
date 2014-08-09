public class Solution {
    public int removeDuplicates(int[] A) {
    	// null check
    	if (A == null || A.length == 0) return 0;
    	int dupCnt = 0;
    	for (int i = 1; i < A.length; i++) {
    		if (A[i] == A[i-1]) dupCnt++;
    		else
    			A[i-dupCnt] = A[i];
    	}
    	return A.length - dupCnt;
    }
}