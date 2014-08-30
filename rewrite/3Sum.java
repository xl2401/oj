public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        int N = num.length;
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int i = 0;
        while (i < N-2) {
            int cur = num[i];
            int target = (-1) * cur;
            int l = i + 1;
            int r = N - 1;
            while (l < r) {
                int left = num[l];
                int right = num[r];
                int expRight = target - left;
                if (right > expRight) {
                    r--;
                } else if (right < expRight) {
                    l++;
                } else {
                    List<Integer> idxs = new ArrayList<Integer>();
                    idxs.add(cur);
                    idxs.add(left);
                    idxs.add(right);
                    res.add(idxs);
                    while (l < r && num[l] == left) l++;
                    while (l < r && num[r] == right) r--;
                }
            }
            while (i < N-2 && num[i] == cur) i++;
        }
        return res;
    }
}
