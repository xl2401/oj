public class removeDuplicates {
    public int removeDuplicates(int[] A) {
        // damn it's sorted!
        int dupCount = 0;
        int N = A.length;
        for (int i = 1; i < N; i++){
            if (A[i] == A[i-1]) dupCount++;
            else{
                A[i-dupCount] = A[i];
            }
        }
        return N - dupCount;
    }
}
