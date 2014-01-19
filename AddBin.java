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
 * Reverse string at first make code much cleaner
 */
public class AddBin {
    public String addBinary(String a, String b) {
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < Math.max(a.length(), b.length()); i++){
            int aDigit = 0;
            int bDigit = 0;
            if (i < a.length())
                aDigit = a.charAt(i) - '0';
            if (i < b.length())
                bDigit = b.charAt(i) - '0';
            int sum = aDigit + bDigit + carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry == 1)
            sb.append(1);
        return sb.reverse().toString();
    }

    public static void main(String[] args){
        AddBin ab = new AddBin();
        System.out.println(ab.addBinary("11", "1"));
    }
}
