import java.util.ArrayList;

/*
 * Title: Permutation Sequence
 * Description: 
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 * Note: Given n will be between 1 and 9 inclusive.
 *
 * Solution:
 * (k-1) / factorial(n-i-1): the idx in the numList
 * remove the idx element
 * update k
 */
public class PermuSeq {
    public int factorial(int n){
        if (n == 0) return 1;
        int f = 1;
        for (int i =1; i <= n; i++){
            f *= i;
        }
        return f;
    }
    
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> numList = new ArrayList<Integer>();
        for (int i = 0; i < n; i++){
            numList.add(i+1);
        }
        k--;
        for (int i = 0; i < n; i++){
            int f = factorial(n - i - 1);
            int q = k / f;
            int r = k % f;
            int cur = numList.get(q);
            sb.append(cur);
            numList.remove(new Integer(cur));
            k = r;
        }
        return sb.toString();
    }

    public static void main(String[] args){
        PermuSeq ps = new PermuSeq();
        for (int i = 0; i < 24; i++){
            System.out.println(ps.getPermutation(4, i+1));
        }
    }
}
