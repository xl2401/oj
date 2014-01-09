/*
 * Title: Search in Rotated Sorted Array II 
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 *
 * Would this affect the run-time complexity? How and why?
 *
 * Write a function to determine if a given target is in the array.
 *
 * Solution:
 * when A[start] == A[mid]?? we cannot make a judge which half is sorted.
 * so just start++;
 * this piece of code is more concise then the previous one,
 * combine find pivot and search process
 */
public class SearchRotate2 {
    public boolean search(int[] A, int target) {
        int start = 0;
        int end = A.length-1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (A[mid] == target) return true;
            if (A[start] < A[mid]){// left half is sorted
                if (A[start] <= target && A[mid] > target)
                    end = mid - 1;
                else
                    start = mid + 1;
            }
            else if (A[start] > A[mid]){// right half is sorted
                if (A[mid] < target && A[end] >= target)
                    start = mid + 1;
                else
                    end = mid - 1;
            }
            else{
                start++;
            }
        }
        return false;
    }
}
