/*
 * Title: Median of Two Sorted Arrays
 * Description:
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * Solution:
 * use findkthsmallest to find the kth element in two sorted list
 * deal with even and odd condition
 */
public class MedOfTwoSorted {
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;
        if ((m + n) % 2 == 0){// even
            int k1 = (m + n) / 2;
            int k2 = (m + n) / 2 + 1;
            int r1 = findKthSmallest(A, 0, A.length-1, B, 0, B.length-1, k1);
            int r2 = findKthSmallest(A, 0, A.length-1, B, 0, B.length-1, k2);
            return 1.0 * (r1 + r2) / 2;
        }
        else{// odd
            int k = (m + n) / 2 + 1;
            return findKthSmallest(A, 0, A.length-1, B, 0, B.length-1, k);
        }
    }

    /*
     * @param A, B two input array
     *        as - start point of A
     *        ae - end point of A
     *        bs - start point of B
     *        be - end point of B
     * @ return: kth element in sorted array A and B
     * every time chop roughly k/2 elements
     * pay attention not to miss `return`
     * pay attention to end condition
     */
    int findKthSmallest(int A[], int as, int ae, int B[], int bs, int be, int k){
        int M = ae - as + 1;
        int N = be - bs + 1;
        if (M > N){// to ensure len A <= len B, to avoid idx out of bound
            return findKthSmallest(B, bs, be, A, as, ae, k);
        }
        if (M == 0){// end condition, one of the array is empty
            return B[bs+k-1];
        }
        if (k == 1){// end condition, k bottom out, A[idxA], B[idxB] not necessarily equal at the end
            return Math.min(A[as], B[bs]);
        }
        int offA = Math.min(M, k/2);
        int offB = k - offA;
        int idxA = as + offA - 1;
        int idxB = bs + offB - 1;

        if (A[idxA] < B[idxB]){// not in A[as..idxA]
            return findKthSmallest(A, idxA+1, ae, B, bs, be, k-offA);
        }
        else if (A[idxA] > B[idxB]){// not in B[bs..idxB]
            return findKthSmallest(A, as, ae, B, idxB+1, be, k-offB);
        }
        else{
            return A[idxA]; 
        }
    }

    public static void main(String[] args){
        int[] A = {2};
        int[] B = {};
        MedOfTwoSorted m = new MedOfTwoSorted();
        System.out.println(m.findMedianSortedArrays(A, B));
    }
}
