public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int N = num.length;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < N-2; i++) {
            int a = num[i];
            int l = i + 1;
            int r = N - 1;
            while (l < r) {
                int left = num[l];
                int right = num[r];
                int expRight = target - a - left;
                if (right > expRight) {
                    if (Math.abs(a+left+right-target) < Math.abs(diff))
                        diff = a + left + right - target;
                    r--;
                } else if (right < expRight) {
                    if (Math.abs(a+left+right-target) < Math.abs(diff))
                        diff = a + left + right - target;
                    l++;
                } else {
                    return target;
                }
            }
        }
        return diff + target;
    }
}