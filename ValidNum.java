/*
 * Title: Validate if a given string is numeric.
 *
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
 *
 * Solution:
 * Easy, but many corner situation
 * think carefully about what is a valid number and break the question into smaller parts.
 */
public class ValidNum {
    // Pure integer like 1234
    public boolean isPureNum(String s, int l, int r){
        if (l == r)
            return false;
        for (int i = l; i < r; i++){
            if (!Character.isDigit(s.charAt(i)))
                return false;
        }
        return true;
    }

    public boolean isFloatNum(String s, int l, int r){
        int dotIdx = -1;
        for (int i = l; i < r; i++){
            if (s.charAt(i) == '.'){
                dotIdx = i;
                break;
            }
        }
        if (dotIdx == -1)
            return isPureNum(s, l, r);
        else{
            if (l == dotIdx)// .1
                return isPureNum(s, dotIdx+1, r);
            else if(dotIdx == r-1)
                return isPureNum(s, l, dotIdx);
            else
                return isPureNum(s, dotIdx+1, r)
                    && isPureNum(s, l, dotIdx);
        }
    }

    public boolean isSignFloat(String s, int l, int r){
        if (l >= s.length())
            return false;
        char firstChar = s.charAt(l);
        if (firstChar == '-' || firstChar == '+'){
            return isFloatNum(s, l+1, r);
        }
        else
            return isFloatNum(s, l, r);
    }

    public boolean isSignInt(String s, int l, int r){
        if (l >= s.length())
            return false;
        char firstChar = s.charAt(l);
        if (firstChar == '-' || firstChar == '+'){
            return isPureNum(s, l+1, r);
        }
        else
            return isPureNum(s, l, r);
    }

    public boolean isNumber(String s) {
        // get rid of space
        s = s.trim();
        if (s.length() == 0)
            return false;
        // search for e
        int eIdx = s.indexOf('e');
        if (eIdx == -1){ // no e appear
            return isSignFloat(s, 0, s.length());
        }
        else{ // scientific representation
            return isSignFloat(s, 0, eIdx)
                && isSignInt(s, eIdx+1, s.length());
        }
    }

    public static void main(String[] args){
        ValidNum vn = new ValidNum();
        System.out.println("0e:" + vn.isNumber("0e"));
        System.out.println("0:" + vn.isNumber("0"));
        System.out.println("  0.1 :" + vn.isNumber(" 0.1 "));
        System.out.println("abc: " + vn.isNumber("abc"));
        System.out.println("1 a:" + vn.isNumber("1 a"));
        System.out.println("-2e10:" + vn.isNumber("-2e10"));

    }
}
