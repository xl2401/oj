import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Serialize a string list
 * list -> string (serialize)
 * string -> list (deserialize)
 */
public class Solution {
    public String serializeStrings(List<String> strs) {
        List<String> res = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        boolean firstStr = true;
        for (String str: strs) {
            // first transform the real backslash
            str = str.replace("\\", "\\\\");
            // escape comma
            str = str.replace(",", "\\,");
            if (!firstStr) sb.append(",");
            else firstStr = false;
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> deserialize(String content) {
        List<String> res = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < content.length(); i++) {
            if (content.charAt(i) == '\\') {
                if (content.charAt(i+1) == ',') sb.append(',');
                else if (content.charAt(i+1) == '\\') sb.append('\\');
                i++;
            } else if (content.charAt(i) == ',') {
                res.add(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append(content.charAt(i));
            }
        }
        res.add(sb.toString());
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> strs = new ArrayList<String>(Arrays.asList("abc,,", "skjdf\\,\\\\", "kjfd"));
        String serializeStr = s.serializeStrings(strs);
        System.out.println(serializeStr);
        List<String> res = s.deserialize(serializeStr);
        for (String str: res) {
            System.out.println(str);
        }
    }
}
