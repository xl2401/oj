public class ReverseInt {
    public int reverse(int x) throws Exception{
        Exception overflowExept = new Exception("Reverse int overflow");
        boolean neg = x < 0;
        x = Math.abs(x);
        int res = 0;
        while (x != 0) {
            // check overflow
            if (Integer.MAX_VALUE / 10 < res) {
                throw overflowExept;
            }
            res *= 10;
            // check overflow
            if (Integer.MAX_VALUE - x % 10 < res) {
                throw overflowExept;
            }
            res += x % 10;
            x /= 10;
        }
        return neg ? (-1 * res) : res;
    }
}
