public class Solution {    
    public boolean searchMatrix(int[][] matrix, int target) {
    	if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int M = matrix.length;
        int N = matrix[0].length;
        int len = M * N;
        int start = 0;
        int end = len - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int midVal = matrix[mid/N][mid%N];
            if (midVal > target)
            	end = mid - 1;
            else if (midVal < target)
            	start = mid + 1;
            else
            	return true;
        }
        return false;
    }
}