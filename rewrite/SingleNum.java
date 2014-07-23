public class SingleNum {
    public int singleNumber(int[] A) {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            res ^= A[i];
        }
        return res;
    }
}
