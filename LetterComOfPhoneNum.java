import java.util.ArrayList;

/*
 * Title: Letter Combinations of a Phone Number
 * Description:
 * Given a digit string, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 *
 * Solution:
 * recursive.
 */
public class LetterComOfPhoneNum {
    public ArrayList<String> letterCombinations(String digits) {
        return letterCombinations(digits, digits.length());        
    }
    
    private String getAlphaStr(int i){
        switch (i){
            case 2:
                return "abc";
            case 3:
                return "def";
            case 4:
                return "ghi";
            case 5:
                return "jkl";
            case 6:
                return "mno";
            case 7:
                return "pqrs";
            case 8:
                return "tuv";
            case 9:
                return "wxyz";
            default:
                return "";
        }
    }
    
    // the combination before idx
    public ArrayList<String> letterCombinations(String digits, int idx){
        if (idx == 0){
            ArrayList<String> res = new ArrayList<String>();
            res.add("");
            return res;
        }
        ArrayList<String> prevComb = letterCombinations(digits, idx - 1);
        String alphaStr = getAlphaStr(digits.charAt(idx - 1) - '0');
        ArrayList<String> res = new ArrayList<String>();
        for (int i = 0; i < alphaStr.length(); i++){
            char c = alphaStr.charAt(i);
            for (int j = 0; j < prevComb.size(); j++){
                res.add(prevComb.get(j) + c);
            }
        }
        return res;
    }
}
