public class Solution {
    public int sqrt(int x) {
        int start = 1;
        int end = x;
        while (start <= end) {
            int mid = (start + end) / 2;
            int expMid = x / mid;
            if (expMid > mid) { // mid too small
                expMid = x / (mid + 1);
                if (expMid < (mid+1)) return mid;
                start = mid + 1;
            } else if (expMid < mid) { // mid too large
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return 0;
    }
}