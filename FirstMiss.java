/*
 * Title: First Missing Positive 
 * Description:
 * Given an unsorted integer array, find the first missing positive integer.
 *
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 *
 * Your algorithm should run in O(n) time and uses constant space.
 *
 * Solution:
 * swap element to the right place at best effort
 * then iterate again to find the missing one
 */
public class FirstMiss {
    public int firstMissingPositive(int[] A) {
        int N = A.length;
        if (N == 0){
            return 1;
        }
        int i = 0;
        while (i < N){
            // A[A[i]-1] != A[i] to prevent infinite loop
            if (A[i] > 0 && A[i] <= N && A[i] != (i + 1) && A[A[i] - 1] != A[i]){
                swap(A, i, A[i] - 1);
            }
            else{
                i++;
            }
        }
        for (i = 0; i < N; i++){
            if (A[i] != i + 1){
                return i + 1;
            }
        }
        return A[N - 1] + 1;
    }

    public void swap(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void main(String[] args){
        int[] A = {1};
        FirstMiss fm = new FirstMiss();
        System.out.println(fm.firstMissingPositive(A));
    }
}
