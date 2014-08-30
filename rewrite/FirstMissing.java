public class FirstMissing {
    public int firstMissingPositive(int[] A) {
        int i = 0;
        int N = A.length;
        while (i < N) {
            if (A[i] != i+1 && A[i] >= 1 && A[i] <= N && A[A[i]-1] != A[i]) {
                swap(A, i, A[i] - 1);
            } else
                i++;
        }
        for (i = 0; i < N; i++) {
            if (A[i] != i+1) return i+1;
        }
        return N+1;
    }

    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
