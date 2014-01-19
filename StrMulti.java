import java.util.ArrayList;

/*
 * Title:Multiply Strings 
 * Description:
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 *
 * Note: The numbers can be arbitrarily large and are non-negative.
 *
 * Solution:
 * arithmatic problem -> reverse string
 * the use of array d
 */
public class StrMulti {
    public String multiply(String num1, String num2){
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        int M = num1.length();
        int N = num2.length();
        int[] d = new int[M+N];
        for (int i = 0; i < M; i++){
            for (int j = 0; j < N; j++){
                int dum1D = num1.charAt(i) - '0';
                int dum2D = num2.charAt(j) - '0';
                d[i+j] += dum1D * dum2D;
            }
        }
        // deal with carry
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < d.length; i++){
            int sum = d[i] + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        // trim leading zeros
        while (sb.length() > 1 && sb.charAt(sb.length()-1) == '0'){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args){
        StrMulti sm = new StrMulti();
        System.out.println(sm.multiply("0", "0"));
    }
}
