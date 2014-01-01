import java.util.Arrays;

public class LongestSubstr {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int[] occurArray = new int[256];
        Arrays.fill(occurArray, -1);
        int start = 0;
        int pointer = 0;
        while (pointer < s.length()){
            char c = s.charAt(pointer);
            int lastOccurIndex = occurArray[c];
            if (!(lastOccurIndex >= start && lastOccurIndex < pointer)){
                occurArray[c] = pointer;
                pointer++;
            }
            else{
                maxLength = Math.max(maxLength, (pointer - start));
                start = lastOccurIndex + 1;
                pointer = start;
            }
        }
        return Math.max(maxLength, (pointer - start));
    }
}
