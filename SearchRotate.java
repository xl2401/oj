/*
 * Title: Search in Rotated Sorted Array 
 * Description: Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 *
 * Solution:
 * find the pivot: use revised binary search to do this
 * and choose the right subarray to binary search
 */
public class SearchRotate {
    public int search(int[] A, int target) {
        int pivot = findPivot(A);
        if (pivot == -1) return binarySearch(A, target, 0, A.length-1);
        if (A[0] <= target) return binarySearch(A, target, 0, pivot);
        else return binarySearch(A, target, pivot+1, A.length-1);
    }

    public int binarySearch(int[] A, int target, int start, int end){
        while (start <= end){
            int mid = (start + end) / 2;
            if (A[mid] < target) start = mid + 1;
            else if (A[mid] > target) end = mid - 1;
            else return mid;
        }
        return -1;
    }

    /*
     * pivot has a feature A[pivot] > A[pivot+1]
     */
    public int findPivot(int[] A){
        int start = 0;
        int end  = A.length-1;
        while (start <= end){
            int mid = (start + end) / 2;
            if (mid != A.length-1 && A[mid] > A[mid+1]) return mid;
            // 'equal' is essential, consider 8, 9, 2, 3, 4
            // start -> 8
            // mid -> 8
            // end -> 9
            if (A[start] <= A[mid]) start = mid + 1;
            else end  = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args){
        int[] A = {5,1,2,3,4};
        System.out.println(new SearchRotate().search(A, 3));
    }
}
