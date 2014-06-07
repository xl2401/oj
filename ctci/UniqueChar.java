/*
 * 1.1
 * Determine if a string has all unique characters
 * use ascii buffer: 256
 * or use hashset
 */
import java.util.HashSet;

public class UniqueChar {
    public boolean isUniqueChar(String str){
        int[] occur = new int[256];
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if (occur[c] == 1) return false;
            occur[c] = 1;
        }
        return true;
    }

    public boolean isUniqueCharWithHash(String str){
        HashSet<Character> charSet = new HashSet<Character>();
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if (charSet.contains(c))
                return false;
            charSet.add(c);
        }
        return true;
    }

    public static void main(String[] args){
        UniqueChar uc = new UniqueChar();
        System.out.println(uc.isUniqueChar("abc"));
        System.out.println(uc.isUniqueChar("abcab"));
        System.out.println(uc.isUniqueCharWithHash("abc"));
        System.out.println(uc.isUniqueCharWithHash("abcab"));
    }
}
