public class Solution {
    public String multiply(String num1, String num2) {
        int M = num1.length();
        int N = num2.length();
        num1 = reverse(num1);
        num2 = reverse(num2);
        int[] digits = new int[M+N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int prod = digit(num1.charAt(i)) * digit(num2.charAt(j));
                digits[i+j] += prod;
            }
        }
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < M+N; i++) {
            int sum = carry + digits[i];
            sb.append(sum % 10);
            carry = sum / 10;
        }
        String res = sb.reverse().toString();
        int i = 0;
        while (i < res.length()-1 && res.charAt(i) == '0') i++;
        return res.substring(i);
    }

    private int digit(char a) {
        return a - '0';
    }

    private String reverse(String a) {
        return new StringBuilder(a).reverse().toString();
    }
}