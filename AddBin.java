/*
 * Title: Add Binary 
 * Descirption:
 * Given two binary strings, return their sum (also a binary string).
 *
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 *
 * Solution:
 * Soooo easy...
 */
public class AddBin {
    public String addBinary(String a, String b) {
        // pad zero
        int M = a.length();
        int N = b.length();
        if (M < N){
            int diff = N-M;
            for (int i = 0; i < diff; i++){
                a = '0' + a;
            }
        }
        else{
            int diff = M-N;
            for (int i = 0; i < diff; i++){
                b = '0' + b;
            }
        }
        N = Math.max(M, N);
        StringBuilder sb = new StringBuilder();
        boolean carry = false;
        for (int i = N-1; i >= 0; i--){
            int ac = a.charAt(i) - '0';
            int bc = b.charAt(i) - '0';
            int sum = ac + bc;
            if (carry)
                sum++;
            if (sum == 0){
                carry = false;
            }
            else if (sum == 1){
                carry = false;
            }
            else if (sum == 2){
                carry = true;
                sum = 0;
            }
            else{
                carry = true;
                sum = 1;
            }
            sb.append(sum);
        }
        if (carry)
            sb.append(1);
        return sb.reverse().toString();
    }

    public static void main(String[] args){
        AddBin ab = new AddBin();
        System.out.println(ab.addBinary("0", "0"));
    }
}
