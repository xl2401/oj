public class Merge {
    public void merge(int A[], int m, int B[], int n) {
        // reverse merge
        int ptr = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0){
            if (A[i] > B[j]){
                A[ptr] = A[i];
                i--;
            }
            else{
                A[ptr] = B[j];
                j--;
            }
            ptr--;
        }
        while (ptr != -1 && j >= 0){
            A[ptr--] = B[j--];
        }
    }
}
