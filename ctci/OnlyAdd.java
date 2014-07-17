/*
 * 7.4
 * implement multiple int operations only using add
 */
public class OnlyAdd {
    private int negate(int x) {
        if (x == 0) return 0;
        int step = x > 0 ? -1 : 1;
        int res = 0;
        while (x != 0) {
            res += step;
            x += step;
        }
        return res;
    }

    public int minus(int a, int b) {
        return a + negate(b);
    }

    public int multiply(int a, int b) {
        if (a == 0 || b == 0) return 0;
        int sum = 0;
        for (int i = 0; i < Math.abs(b); i++) {
            sum += a;
        }
        if (b < 0) {
            sum = negate(sum);
        }
        return sum;
    }

    public int divide(int a, int b) throws IllegalArgumentException{
        if (b == 0){
            throw new IllegalArgumentException("Argument 'divisor' is 0");
        }
        if (a == 0) return 0;
        int aba = Math.abs(a);
        int abb = Math.abs(b);
        int prod = 0;
        int res = 0;
        while (prod + abb <= aba) {
            prod += abb;
            res++;
        }
        // diff sign
        if ((a > 0 && b < 0) || (a < 0 && b > 0)) {
            res = negate(res);
        }
        return res;
    }

    public static void main(String[] args) {
        OnlyAdd cal = new OnlyAdd();
        System.out.println(cal.minus(2, 3));
        System.out.println(cal.multiply(-2, 3));
        System.out.println(cal.divide(2, 3));
    }
}
