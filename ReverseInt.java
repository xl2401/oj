/*
 * Title: Reverse Integer 
 * Description:
 * Reverse digits of an integer.
 *
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 *
 * Solution:
 * use mod to retrive last digit first and construct a reverse int
 * Check overflow is tricky
 */
public class ReverseInt{
    public int reverse(int x) throws Exception{
        int sign = 1;
        if (x < 0){
            sign = -1;
            x *= -1;
        }
        int result = 0;
        while (x != 0){
            if (result > Integer.MAX_VALUE / 10){
                // multi by 10 will overflow
                throw new Exception("OVERFLOW");
            }
            else{
                result *= 10;
            }
            result += x % 10;
            if (result < 0){
                throw new Exception("OVERFLOW");
            }
            x /= 10;
        }
        result *= sign;
        return result;
    }
}
