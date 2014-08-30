import java.util.ArrayList;

public class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> digits = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            digits.add(i+1);
        }
        k--;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int f = fac(n - i);
            int idx = k / f;
            int cur = digits.get(idx);
            sb.append(cur);
            digits.remove(new Integer(cur));
            k = k % f;
        }
        return sb.toString();
    }

    private int fac(int k) {
        int res = 1;
        for (int i = 1; i <= k; i++) {
            res *= i;
        }
        return res;
    }
}