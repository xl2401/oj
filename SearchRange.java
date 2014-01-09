/**
 * Title: Search for a Range 
 * Given a sorted array of integers, find the starting and ending position of a given target value
 * Your algorithm's runtime complexity must be in the order of O(log n)
 * If the target is not found in the array, return [-1, -1].
 *
 * Solution:
 * Revise `iterative` binary search and find left and right bound
 */
public class SearchRange {
    int rightStart = 0;

    public int[] searchRange(int[] A, int target) {
        int[] result = {-1, -1};
        if (A.length == 0) return result;
        int leftBound = findLeftBound(A, target);
        if (leftBound == -1) return result;
        int rightBound = findRightBound(A, target);
        result[0] = leftBound;
        result[1] = rightBound;
        return result;
    }

    public int findLeftBound(int[] A, int target){
        int start = 0;
        int end = A.length-1;
        int leftBound = -1;
        while (start <= end){
            int mid = (start + end) / 2;
            if (A[mid] > target) end = mid - 1;
            else if (A[mid] < target) start = mid + 1;
            else{
                // record the start position of right search
                if (leftBound == -1) rightStart = mid;
                leftBound = mid;
                end = mid - 1;
            } 
        }
        return leftBound;
    }

    public int findRightBound(int[] A, int target){
        int start = rightStart;
        int end = A.length-1;
        int rightBound = -1;
        while (start <= end){
            int mid = (start + end) / 2;
            if (A[mid] > target) end = mid - 1;
            else if (A[mid] < target) start = mid + 1;
            else{
                rightBound = mid;
                start = mid + 1;
            }
        }
        return rightBound;
    } 

    public static void main(String[] args){
        int[] A = {5, 7, 7, 8, 8, 10};
        int[] result = new SearchRange().searchRange(A, 8);
        System.out.println(result[0] + " " + result[1]);
    }
}
