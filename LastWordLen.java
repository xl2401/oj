/*
 * Title: Length of Last Word 
 * Description:
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Solution:
 * simply count,
 * Note 'b a        ' -> 1
 * only the current char is ' '  and the next char isn't ' ' update count = 0
 */
public class LastWordLen {
    public int lengthOfLastWord(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == ' '){
                if (i+1 < s.length() && s.charAt(i+1) != ' ')
                    count = 0;
            }
            else
                count++;
        } 
        return count;
    }

    public static void main(String[] args){
        String s = "b    a       ";
        System.out.println(new LastWordLen().lengthOfLastWord(s));
    }
}
