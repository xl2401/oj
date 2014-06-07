/*
 * 1.3
 * Given two strings, check if one is the permutation of another
 * 2 pass, count method
 */
public class CheckPermStr {
    public boolean isPerm(String a, String b) {
        int[] charCnt = new int[256];
        for (int i = 0; i < a.length(); i++) {
            charCnt[a.charAt(i)]++;
        }
        for (int i = 0; i < b.length(); i++) {
            char c = b.charAt(i);
            if (--charCnt[c] < 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        CheckPermStr cps = new CheckPermStr();
        System.out.println(cps.isPerm("abc", "cba"));
        System.out.println(cps.isPerm("asdf", "asdk"));
    }
}
