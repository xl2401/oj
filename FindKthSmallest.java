/* Title: Find the k-th Smallest Element in the Union of Two Sorted Arrays
*/
public class FindKthSmallest{
    /*
     * @param A, B two input array
     *        as - start point of A
     *        ae - end point of A
     *        bs - start point of B
     *        be - end point of B
     */
    int findKthSmallest(int A[], int as, int ae, int B[], int bs, int be, int k){
        int M = ae - as + 1;
        int N = be - bs + 1;
        if (M > N){
            // to ensure that len A is the smaller than len B
            return findKthSmallest(B, bs, be, A, as, ae, k);
        }
        if (M == 0){// one of the array is empty
            return B[bs + k - 1];
        }
        if (k == 1){// exit condition
            return Math.min(A[as], B[bs]);
        }
        int offA = Math.min(k/2, M);
        int offB = k - offA;
        int idxA = as + offA - 1;
        int idxB = bs + offB - 1;

        if (A[idxA] < B[idxB]){// not in A[as..idxA]
            return findKthSmallest(A, idxA + 1, ae, B, bs, be, k - offA);
        }
        else if (A[idxA] > B[idxB]){// not in B[bs..idxB]
            return findKthSmallest(A, as, ae, B, idxB + 1, be, k - offB);
        }
        else{// hit
            return A[idxA];
        }
    }

    public static void main(String[] args){
        FindKthSmallest f = new FindKthSmallest();
        int[] A = {1,2,5};
        int[] B = {4,6,7,8};
        System.out.println(f.findKthSmallest(A, 0, A.length-1, B, 0, B.length-1, 3));
    }
}
