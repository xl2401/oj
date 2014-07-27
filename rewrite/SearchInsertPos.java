public class Solution {
    public int searchInsert(int[] A, int target) {    
    	int idx = 0;
    	while (idx < A.length) {
    		int cur = A[idx];
    		if (cur >= target) break;
    		idx++;
    	}
    	return idx;
    }
}