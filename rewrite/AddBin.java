public class Solution {
    public String addBinary(String a, String b) {
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < Math.max(a.length(), b.length()); i++) {
            int aDigit = i < a.length() ? a.charAt(i) - '0' : 0;
            int bDigit = i < b.length() ? b.charAt(i) - '0': 0;
            int sum = aDigit + bDigit + carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry == 1) sb.append(1);
        return sb.reverse().toString();
    }
}
