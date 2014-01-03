public class TrapWater {
    public int trap(int[] A) {
        // Special condition
        int N = A.length;
        if (N == 0) return 0;
        // leftMax[i], the max elevation smaller than i
        // rightMax[i], the max elevation larger than i
        int[] leftMax = new int[N];
        int[] rightMax = new int[N];
        leftMax[0] = 0;
        rightMax[0] = 0;
        for (int i = 1; i < N; i++){
            if (leftMax[i-1] < A[i-1])
                leftMax[i] = A[i-1];
            else
                leftMax[i] = leftMax[i-1];
        }
        for (int j = N-2; j >= 0; j--){
            if (rightMax[j+1] < A[j+1])
                rightMax[j] = A[j+1];
            else
                rightMax[j] = rightMax[j+1];
        }
        int sum = 0;
        for (int i = 0; i < N; i++){
            int max = Math.min(leftMax[i], rightMax[i]);
            sum += max <= A[i]? 0: max - A[i];
        }
        return sum;
    }

    public static void main(String[] args){
        int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new TrapWater().trap(A));
    }
}
