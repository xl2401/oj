public class PalindromeNum {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int N = 0;
        int num = x;
        while (num != 0){
            num = num / 10;
            N++;
        }
        return isPalindrome(x, N);
    }
    
    public boolean isPalindrome(int x, int N){
        // Retrieve the first digit and last digit
        if (N == 1) return true;
        if (N == 0) return true;
        if (x == 0) return true;
        int lastDigit = x % 10;
        int firstDigit = (int)(x / Math.pow(10, N-1));
        if (firstDigit != lastDigit){
            return false;
        }
        else{
            int newNumber = x / 10;
            newNumber -= firstDigit * (int)(Math.pow(10, N-2));
            return isPalindrome(newNumber, N-2);
        }
    }
}
