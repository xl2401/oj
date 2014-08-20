public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] res = {-1, -1};
        int leftBound = searchBound(A, target, true);
        if (leftBound == -1) return res;
        res[0] = leftBound;
        res[1] = searchBound(A, target, false);
        return res;
    }

    private int searchBound(int[] A, int target, boolean leftBound) {
        int l = 0;
        int r = A.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (A[mid] > target) {
                r = mid - 1;
            } else if (A[mid] < target) {
                l = mid + 1;
            } else {
                if (leftBound) {
                    // check elem on left
                    if (mid == 0 || A[mid-1] < target) return mid;
                    else r = mid - 1;
                } else {
                    if (mid == A.length-1 || A[mid+1] > target) return mid;
                    else l = mid + 1;
                }
            }
        }
        return -1;
    }
}

