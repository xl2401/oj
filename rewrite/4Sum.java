public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        int N = num.length;
        int i = 0;
        while (i < N-3) {
            int a = num[i];
            int j = i + 1;
            while (j < N-2) {
                int b = num[j];
                int curTar = target - a - b;
                int l = j + 1;
                int r = N - 1;
                while (l < r) {
                    int left = num[l];
                    int right = num[r];
                    int expRight = curTar - left;
                    if (right < expRight) l++;
                    else if (right > expRight) r--;
                    else {
                        List<Integer> four = new ArrayList<Integer>();
                        four.add(a);
                        four.add(b);
                        four.add(left);
                        four.add(right);
                        res.add(four);
                        while (l < r && num[l] == left) l++;
                        while (l < r && num[r] == right) r--;
                    }
                }
                while (j < N-2 && num[j] == b) j++;
            }
            while (i < N-3 && num[i] == a) i++;
        }
        return res;
    }
}