public class Solution {
    public boolean search(int[] A, int target) {
        if (A == null || A.length == 0) return false;
        int left = 0;
        int right = A.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (A[mid] == target) return true;
            if (A[mid] > A[left]) { // left half is sorted
                if (A[left] <= target && target <= A[mid])
                	right = mid - 1;
                else
                	left = mid + 1;
            } else if (A[mid] < A[left]) { // right half is sorted
                if (A[mid] <= target && target <= A[right])
                	left = mid + 1;
                else 
                	right = mid - 1;
            } else { // not sure
            	left++;
            }
        }
        return false;
    }
}

