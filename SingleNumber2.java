import java.util.Arrays;

public class SingleNumber2 {
    public int singleNumber(int[] A) {
        Arrays.sort(A);
        int N = A.length;
        if (N == 0) return -1;
        if (N == 1) return A[0];
        int i = 0;
        int j = 2;
        if (A[i] != A[j]) return A[i];
        if (A[N-1] != A[N-3]) return A[N-1];
        while (j < N-1){
            if (A[i] == A[j]){
                i += 3;
                j += 3;
            }
            else{
                return A[i];
            }
        }
        return -1;
    }
}
