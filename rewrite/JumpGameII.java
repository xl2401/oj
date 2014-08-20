public class Solution {
    public int jump(int[] A) {
        int N = A.length;
        int curReach = 0;
        int nextReach = 0;
        int i = 0;
        int cnt = 0;
        while (i < N) {
            if (curReach >= N-1) return cnt;
            while (i < N && i <= curReach) {
            	nextReach = Math.max(nextReach, i+A[i]);
            	i++;
            }
            curReach = nextReach;
            cnt++;
        }
        return cnt;
    }
}