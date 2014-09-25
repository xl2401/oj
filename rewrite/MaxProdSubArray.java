public class Solution {
    public double maxProduct(double[] A) {
        if (A == null || A.length == 0) return 0;
        // max Prod til the current idx, must use the element of the current index
        double maxProd = A[0];
        // min Prod til the current idx, must use the element of the current index
        double minProd = A[0];
        double max = maxProd;
        for (int i = 1; i < A.length; i++) {
            double prevMaxProd = maxProd, prevMinProd = minProd;
            // update maxprod/ minprod
            maxProd = max(A[i], A[i] * prevMinProd, A[i] * prevMaxProd);
            minProd = min(A[i], A[i] * prevMinProd, A[i] * prevMaxProd);
            max = Math.max(max, maxProd);
        }
        return max;
    }

    private double max(double a, double b, double c) {
        return Math.max(a, Math.max(b, c));
    }

    private double min(double a, double b, double c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) {
        double[] A = {60, 2, -0.000000001, 99999};
        System.out.println(new Solution().maxProduct(A));
    }
}