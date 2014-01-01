import java.util.HashMap;
import java.util.ArrayList;

public class LetterComOfPhoneNum {
    public String getMapString(int digit){
        switch (digit){
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
    public ArrayList<String> letterCombinations(String digits) {
        if (digits.length() == 0){
            ArrayList<String> result = new ArrayList<String>();
            result.add("");
            return result;
        } 
        if (digits.length() == 1){
            ArrayList<String> resultList = new ArrayList<String>();
            int digit = Integer.parseInt("" + digits.charAt(0));
            String mapString = getMapString(digit);
            for (int i = 0; i < mapString.length(); i++){
                resultList.add("" + mapString.charAt(i));
            }
            return resultList;
        }
        else{
            int N = digits.length();
            ArrayList<String> previousCombination = letterCombinations(digits.substring(0, N-1));
            // add last digit
            int lastDigit = Integer.parseInt("" + digits.charAt(N-1));
            String mapString = getMapString(lastDigit);
            ArrayList<String> result = new ArrayList<String>();
            for (String digitString: previousCombination){
                for (int i = 0; i < mapString.length(); i++){
                    char appendix = mapString.charAt(i);
                    result.add(digitString + appendix);
                }
            }
            return result;
        }
        
    }
}
