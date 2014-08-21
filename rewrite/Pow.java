public class Solution {
    public double pow(double x, int n) {
        // special
        if (x == 0) return 0;
        if (x == 1) return 1;
        boolean neg = n < 0;
        n = Math.abs(n);
        double prod = 1;
        while (n != 0) {
            if (n % 2 == 1) prod *= x;
            n /= 2;
            x *= x;
        }
        return neg ? 1/prod : prod;
    }
}
