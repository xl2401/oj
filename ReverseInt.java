public class ReverseInt {
    public int reverse(int x) {
        boolean positive = true;
        if (x < 0){
            positive = false;
            x = -x;
        }
        int result = 0;
        while (true){
            int remainder = x % 10;
            x = x/10;
            result *= 10;
            result += remainder;
            if (x == 0) break;
        }
        if (positive == false){
            result = -1 * result;
        }
        return result;
    }
}
