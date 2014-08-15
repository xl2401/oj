public class Solution {	
    public int search(int[] A, int target) {    
        if (A == null || A.length == 0) return -1;
        int left = 0;
        int right = A.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int midVal = A[mid];
            if (midVal == target) return mid;
            if (midVal >= A[left]) {
            	if (A[left] <= target && target <= midVal)
            		right = mid - 1;
            	else
            		left = mid + 1;
            } else {
                if (midVal <= target && target <= A[right])
                	left = mid + 1;
                else
                	right = mid - 1;
            }
        }
        return -1;
    }
}