/*
 * Title: ZigZag Conversion
 * Solution:
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 *
 * Solution:
 * Create nRows StringBuilder represent each row
 * iterate over the string, revise row num in zigzag fashion, add character into corresponding row stringbuilder
 * merge all row into a single string
 * # pay attention that when nRows == 1, this does not suite. So this is a special condition
 */
public class ZigZag{
    public String convert(String s, int nRows){
        if (nRows == 1) return s;
        StringBuilder[] sbRow = new StringBuilder[nRows];
        for (int i = 0; i < nRows; i++){
            sbRow[i] = new StringBuilder();
        }
        int row = 0;
        int head = 1;        
        for (int i = 0; i < s.length(); i++){
            if (row == 0){
                head = 1;
            }
            if (row == nRows - 1){
                head = -1;
            }
            sbRow[row].append(s.charAt(i));
            row += head;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nRows; i++){
            sb.append(sbRow[i].toString());
        }
        return sb.toString();
    }
}
