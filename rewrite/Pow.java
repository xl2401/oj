public class Pow {
    public double pow(double base, int exp) {
        if (base == 0) return 0;
        if (base == 1) return 1;
        boolean expNeg = exp < 0;
        if (expNeg) exp = exp * -1;
        double powVal = powHelper(exp, base);
        if (expNeg)
            powVal = 1 / powVal;
        return powVal;
    }

    private double powHelper(int exp, double curMulti) {
        // base condition
        if (exp == 0)
            return 1;
        double curRes = exp % 2 == 0 ? 1 : curMulti;
        return curRes * powHelper(exp/2, curMulti*curMulti);
    }

    public double powIter(double base, int exp) {
        if (base == 0) return 0;
        if (base == 1) return 1;
        boolean expNeg = exp < 0;
        if (expNeg) exp = -1 * exp;
        double res = 1;
        while (exp != 0) {
            if (exp % 2 != 0)
                res *= base;
            base *= base;
            exp /= 2;
        }
        if (expNeg) res = 1.0 / res;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Pow().powIter(2, 3));
    }
}
