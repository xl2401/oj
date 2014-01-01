import java.util.Arrays;

public class SingleNumber {
    public int singleNumber(int[] A) {
        Arrays.sort(A);
        int N = A.length;
        if (N == 0) return -1;
        if (N == 1) return A[0];
        int i = 0;
        int j = 1;
        if (A[i] != A[j]) return A[i];
        if (A[N-1] != A[N-2]) return A[N-1];
        while (j < N-1){
            if (A[i] == A[j]){
                i += 2;
                j += 2;
            }
            else{
                return A[i];
            }
        }
        return -1;
    }
}
