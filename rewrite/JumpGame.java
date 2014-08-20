public class Solution {
    public boolean canJump(int[] A) {    
        int maxReach = 0;
        for (int i = 0; i < A.length; i++) {
            if (i > maxReach) return false;
            maxReach = Math.max(maxReach, i+A[i]);
        }
        return maxReach >= A.length - 1;
    }
}