public class Solution {
    public int singleNumber(int[] A) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int j = 0; j < A.length; j++) {
                cnt += (A[j] >> i) & 1;
            }
            res |= (cnt % 3) << i;
        }  
        return res;
    }
}
