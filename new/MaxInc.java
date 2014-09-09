/**
 * Max Incremental Sequence
 * Find the length of the longest incremental sequence in an array, the element in the sequence may not be adjacent in the array
 * e.g. A: 5 3 1 4 6 2 7 1 9
 * return 5 because the longest incremental seq is 3 4 6 7 9
 *
 * Solution: DP
 */
public class Solution {
    // DP
    // C[i] represent the max inc at the for seq from idx 0 to i
    // C[i] follows formula
    // C[i] = max(C[k]) + 1 when A[k] < A[i] for 0 <= k < i
    public int maxInc(int[] A) {
        if (A == null || A.length == 0) return 0;
        int N = A.length;
        int[] C = new int[N];
        for (int i = 0; i < N; i++) {
            int max = 0;
            for (int k = 0; k < i; k++) {
                if (A[k] < A[i]) {
                    max = Math.max(max, C[k]);
                }
            }
            C[i] = max + 1;
        }
        return C[N-1];
    }

    public static void main(String[] args) {
        int[] A = {5,3,1,4,6,2,7,1,9};
        System.out.println(new Solution().maxInc(A));
    }
}
