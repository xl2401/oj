import java.util.ArrayList;

/*
 * Title: Median of Unsorted Array
 * (Not in leetcode)
 * Description:
 *
 * Solution:
 * use quick sort partition (but not totally sorted) to get the pivot
 * adjust l & r util p == (N-1)/2 when N is odd
 * or p == (N-1)/2 : p == (N-1)/2+1 when N is even
 */
public class MedUnsorted{
    public void exch(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public int partition(int[] A, int l, int r){
        int p = A[l];
        int i = l+1;
        int j = r;
        while (true){
            while (i < r && A[i] <= p) i++;
            while (j > l && A[j] > p) j--;
            if (i >= j) break;
            exch(A, i, j);
        }
        exch(A, l, j);
        return j;
    }

    public double med(int[] A){
        int N = A.length;
        boolean even = N%2 == 0;
        int former = 0;
        int latter = 0;
        boolean oneSet = false;

        int i = 0;
        int j = N-1;
        while (true){
            int p = partition(A, i, j);
            if (p == (N-1)/2){
                if (!even)
                    return A[p];
                else{
                    former = A[p];
                    if (oneSet)
                        return 1.0 * (former + latter) / 2;
                    else
                        oneSet = true;
                    i = p+1;
                }
            }
            else if (p == (N-1)/2+1){
                if (even){
                    latter = A[p];
                    if (oneSet)
                        return 1.0 * (former + latter) / 2;
                    else
                        oneSet = true;
                    j = p-1;
                }
                else
                    j = p-1;
            }
            else if (p < (N-1)/2)
                i = p+1;
            else{
                j = p-1;
            }
        }
    }

    public static void main(String[] args){
        int[] A = {3,1,4,5,2,6};
        MedUnsorted mu = new MedUnsorted();
        System.out.println(mu.med(A));
    }
}
