/*
 * Title: Divide Two Integers 
 * Description:
 * Divide two integers without using multiplication, division and mod operator.
 *
 * Solution:
 * the very naive method is to substract divisor and count
 * this is slow, let divisor be b
 * let's try substract b 2b 4b 8b ... 
 * pay attention to the precision! Math.abs(Integer.MIN_VALUE) will overflow.
 */
public class Divide {
    public int divide1(int dividend, int divisor) {
        boolean pos = false;
        if (divisor == 0){
            throw new ArithmeticException("Divide by zero");
        }
        if (divisor == 1){
            return dividend;
        }
        if (divisor == -1){
            return -dividend;
        }
        if (dividend == 0){
            return 0;
        }
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor == 0)){
            pos = true;
        }
        // trans to pos
        if (dividend < 0){
            dividend = -dividend; 
        }
        if (divisor < 0){
            divisor = -divisor;
        }
        int sum = 0;
        while (dividend > divisor){
            sum++;
            dividend -= divisor;
        }
        if (pos){
            return sum;
        }
        else{
            return -sum;
        }
    }

    public int divide(int dividend, int divisor){
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        int res = 0;
        while (a >= b){
            long c = b;
            for (int i = 0; a >= c; c <<= 1, i++){
                a -= c;
                res += 1 << i;
            }
        }
        return (dividend ^ divisor) >> 31 == 0 ? res : -res;
    }

    public static void main(String[] args){
        System.out.println(new Divide().divide(-1010369383, -2147483648));
        System.out.println(Long.MAX_VALUE);
    }
}
