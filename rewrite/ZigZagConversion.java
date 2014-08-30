import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String convert(String s, int nRows) {
        if (nRows == 1) return s;
        List<List<Character>> lines = new ArrayList<List<Character>>();
        for (int i = 0; i < nRows; i++) {
            lines.add(new ArrayList<Character>());
        }
        for (int i = 0, row = 0, dir = 1; i < s.length(); i++, row += dir) {
            lines.get(row).add(s.charAt(i));
            if ((row == 0 && dir == -1) || (row == nRows-1 && dir == 1)) dir *= -1;
        }
        StringBuilder sb = new StringBuilder();
        for (List<Character> line: lines) {
            for (Character c: line) sb.append(c);
        }
        return sb.toString();
    }
}