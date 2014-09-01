public class Solution {
    public int divide(int dividend, int divisor) {
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        long fac = b;
        while (fac <= a) {
            fac <<= 1;
        }
        fac >>= 1;
        int res = 0;
        while (fac >= b) {
            res <<= 1;
            if (a >= fac) {
                a -= fac;
                res++;
            }
            fac >>= 1;
        }
        return (dividend ^ divisor) >> 31 == 0? res : -res;
    }
}