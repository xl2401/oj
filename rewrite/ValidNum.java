public class Solution {
    public boolean isNumber(String s) {
        if (s == null) return false;
        s = s.trim();
        int eIdx = s.indexOf('e');
        if (eIdx == -1) return isFloat(s);
        else {
            return isFloat(s.substring(0, eIdx)) && isInteger(s.substring(eIdx+1));
        }
    }

    private boolean isPosInteger(String s) {
        if (s.length() == 0) return false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') return false;
        }
        return true;
    }

    private boolean isInteger(String s) {
        if (s.length() == 0) return false;
        if (s.charAt(0) == '-' || s.charAt(0) == '+') return isInteger(s.substring(1));
        return isPosInteger(s);
    }
    private boolean isPosFloat(String s) {
        int dotIdx = s.indexOf('.');
        if (dotIdx == -1) return isPosInteger(s);
        if (dotIdx == 0) return isPosInteger(s.substring(1));
        if (dotIdx == s.length()-1) return isPosInteger(s.substring(0, s.length()-1));
        return isPosInteger(s.substring(0, dotIdx)) && isPosInteger(s.substring(dotIdx+1));
    }
    
    private boolean isFloat(String s) {
        if (s.length() == 0) return false;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') return isPosFloat(s.substring(1));
        else return isPosFloat(s);
    }
}