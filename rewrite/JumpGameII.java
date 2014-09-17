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

    // if can jump exactly A[i] what is the min jump
    public int jumpExactly(int[] A) {
        // null check
        if (A == null) return Integer.MAX_VALUE;
        int N = A.length;
        //record the min jump to the current position
        int[] C = new int[N];
        for (int i = 1; i < N; i++) {
            int min = Integer.MAX_VALUE;
            for (int k = 0; k < i; k++) {
                if (k + A[k] == i && C[k] != -1) {
                    min = Math.min(min, C[k]);
                }
            }
            if (min != Integer.MAX_VALUE) min++;
            C[i] = min;
        }
        return C[N-1];
    }

    public static void main(String[] args) {
        int[] A = {1,3,1,1,4};
        System.out.println(new Solution().jumpExactly(A));
    }
}
