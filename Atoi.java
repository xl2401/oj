/*
 * Title: String to Integer (atoi) 
 * Description:
 * Implement atoi to convert a string to an integer.
 *
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 *
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
 *
 * Solution:
 * the overflow judge can be tricky...
 */
public class Atoi {
    public int atoi(String str) {
        int result = 0;
        boolean sign = true;
        boolean overflow = false;
        int N = str.length();
        if (N == 0) return 0;
        int i = 0;
        while (Character.isWhitespace(str.charAt(i)))
            i++;
        // check sign
        if (str.charAt(i) == '+')
            i++;
        if (str.charAt(i) == '-'){
            i++;
            sign = false;
        }
        for (;i < N; i++){
            if (!Character.isDigit(str.charAt(i)))
                break;
            // judge if *10 will overflow
            if (result != 0 && Integer.MAX_VALUE / 10 < result){
                overflow = true;
                break;
            }
            result *= 10;
            result += str.charAt(i) - '0';
            // judge if + will overflow
            if (result < 0){
                overflow = true;
                break;
            }
        }
        if (overflow){
            if (sign)
                return Integer.MAX_VALUE;
            else
                return Integer.MIN_VALUE;
        }
        if (!sign)
            result *= -1;
        return result;
    }

    public static void main(String[] args){
        Atoi a = new Atoi();
        System.out.println(a.atoi("2147483648"));
    }
}
