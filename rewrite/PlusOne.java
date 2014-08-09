public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length-1; i >= 0; i--) {
            int curRes = digits[i] + 1;
            digits[i] = curRes % 10;
            carry = curRes >= 10 ? 1 : 0;
            if (carry == 0) return digits;
        }
        int[] newNum = new int[digits.length+1];
        // no need to copy the whole array, 999 -> 1000
        newNum[0] = 1;
        return newNum;
    }
}
