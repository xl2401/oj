/*
 * Title:
 * String to Integer (atoi) 
 * Description:
 * Implement atoi to convert a string to an integer.
 *
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 *
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
 *
 * spoilers alert... click to show requirements for atoi.
 *
 * Requirements for atoi:
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 *
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 *
 * Solution:
 * The overflow check is tricky
 * pay attention: -65536 does not overflow, but 65536 actually overflows, here overflow info is not correct but the final result is right,
 * if require other kind of return, this condition require special attention
 */
public class Atoi{
    public int atoi(String s){
         int ptr = 0;
         int N = s.length();
         while (ptr < N && s.charAt(ptr) == ' '){
             ptr++;
         }
         if (ptr == N) return 0;// empty string
         // deal with + and -
         int sign = 1;
         if (s.charAt(ptr) == '+' || s.charAt(ptr) == '-'){
             if (s.charAt(ptr) == '-') sign = -1;
             ptr++;
         }
         boolean overflow = false;
         int res = 0;
         // read digit
         while (ptr < N && s.charAt(ptr) >= '0' && s.charAt(ptr) <= '9'){
             if (res > Integer.MAX_VALUE / 10){
                 overflow = true;
                 break;
             }
             res = res * 10 + s.charAt(ptr) - '0';
             if (res < 0){
                 overflow = true;
                 break;
             }
             ptr++;
         }
         if (overflow){
             if (sign == 1){
                 return Integer.MAX_VALUE;
             }
             else{
                 return Integer.MIN_VALUE;
             }
         }
         return sign * res;
    }
}
