public class Solution {
    public void nextPermutation(int[] num) {
        int N = num.length;
        if (num == null || N < 2) return;
        int l = N - 2;
        int r = N - 1;
        while (l >= 0 && num[l] >= num[r]) {
            l--;
            r--;
        }
        if (l == -1) reverse(num, 0, N-1);
        else {
            int i = N - 1;
            while (i >= r && num[l] >= num[i]) i--;
            swap(num, l, i);
            reverse(num, r, N-1);
        }
    }

    private void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    private void reverse(int[] num, int i, int j) {
        while (i < j) {
            swap(num, i++, j--);
        }
    }
}