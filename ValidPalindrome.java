public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        // Preprocess, to lowercase, to alphanumeric
        s = s.toLowerCase().replaceAll("[^A-Za-z0-9]", "");
        int N = s.length();
        if (s.length() == 0) return true;
        int i = 0;
        int j = N-1;
        while (i <= j){
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
