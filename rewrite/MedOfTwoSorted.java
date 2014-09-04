public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int M = A.length;
        int N = B.length;
        if ((M+N) % 2 == 0) {
            return (findKth(A, B, 0, M-1, 0, N-1, (M+N)/2)
                    + findKth(A, B, 0, M-1, 0, N-1, (M+N)/2+1)) / 2.0;
        } else {
            return findKth(A, B, 0, M-1, 0, N-1, (M+N+1)/2);
        }
    }

    private int findKth(int A[], int B[], int as, int ae, int bs, int be, int k) {
        int M = ae - as + 1;
        int N = be - bs + 1;
        if (M > N) return findKth(B, A, bs, be, as, ae, k);
        // base condition
        if (M == 0) return B[bs+k-1];
        if (k == 1) return Math.min(A[as], B[bs]);
        int offsetA = Math.min(M, k/2);
        int offsetB = k - offsetA;
        int idxA = as + offsetA - 1;
        int idxB = bs + offsetB - 1;
        if (A[idxA] > B[idxB]) {
            return findKth(A, B, as, idxA, idxB+1, be, k-offsetB);
        } else if (A[idxA] < B[idxB]) {
            return findKth(A, B, idxA+1, ae, bs, idxB, k-offsetA);
        } else {
            return A[idxA];
        }
    }
}