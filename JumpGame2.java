public class JumpGame2 {
    /*
     * O(n^2) not good.
     * keep track of min step
     */
    public int jump2(int[] A) {
        int N = A.length;
        if (N == 0) return Integer.MAX_VALUE;
        int[] minStep = new int[N];
        minStep[0] = 0;
        for (int i = 1; i < N; i++){
            minStep[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < N-1; i++){
            if (minStep[i] == Integer.MAX_VALUE) return Integer.MAX_VALUE;
            for (int j = i+1; j < N && j <= i+A[i]; j++){
                minStep[j] = Math.min(minStep[j], minStep[i]+1);
            }
        }
       return minStep[N-1];
    }

    /**
     * Greedy algorithm
     * A[i] can reach the farthest point among the position <=i
     * continuously choose farthest point(greedy) from i+1 to curMax util reach the last point
     */
    public int jump(int[] A) {
        int N = A.length;
        if (N == 0) return Integer.MAX_VALUE;
        if (N == 1) return 0;
        int jumps = 0;
        int curMax = 0;
        int i = 0;
        while (i < N){
            curMax = A[i] + i;
            if (A[i] == 0)
                return Integer.MAX_VALUE;
            else
                jumps++;
            if (curMax >= N-1)
                return jumps;

            // determine to jump to which index
            // select the one which reach the farthest
            int tempMax = 0;
            for (int j = i+1; j <= curMax; j++){
                if (j+A[j] >= tempMax){
                    tempMax = j + A[j];
                    i = j;
                }
            }
        }
        return jumps;
    }


    public static void main(String[] args){
        int[] A = {2,3,1,1,4};
        System.out.println(new JumpGame2().jump(A));
    }
}
