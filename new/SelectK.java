import java.util.Random;

public class Solution {
    public int selectK(int[] num, int k) {
        // error check
        if (num == null || k >= num.length) return 0;
        return selectHelper(num, k, 0, num.length-1);
    }

    // select kth from subarray[l...r]
    private int selectHelper(int[] num, int k, int l, int r) {
        if (l <= r) {
            // randomize
            int swapIdx = new Random().nextInt(r-l+1) + l;
            swap(num, swapIdx, l);
            // get pivot idx
            int pIdx = partition(num, l, r);
            if (pIdx == k) return num[k];
            else if (pIdx < k) return selectHelper(num, k, pIdx+1, r);
            else return selectHelper(num, k, l, pIdx-1);
        }
        return -1;
    }

    // partition around num[l], return pivot index
    private int partition(int[] num, int l, int r) {
        int pivot = num[l];
        int i = l+1;
        int j = r;
        while (true) {
            while (num[i] <= pivot) {
                if (i == r) break;
                i++;
            }
            while (num[j] >= pivot) {
                if (j == l) break;
                j--;
            }
            if (i >= j) break;
            swap(num, i, j);
        }
        swap(num, l, j);
        return j;
    }

    private void swap(int[] num, int l, int r) {
        int tmp = num[l];
        num[l] = num[r];
        num[r] = tmp;
    }

    public void sort(int[] num, int l, int r) {
        // end condition
        if (l <= r) return;
        int pivotIdx = partition(num, l, r);
        sort(num, l, pivotIdx-1);
        sort(num, pivotIdx+1, r);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] A = {3,1,5,2,4};
        System.out.println(s.selectK(A, 3));
        s.sort(A, 0, A.length-1);
        for (int i: A) {
            System.out.print(i + " ");
        }
    }
}
