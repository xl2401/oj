public class Solution {
    public boolean isValid(String s) {        
        if (s == null) return false;
        LinkedList<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ("([{".contains(String.valueOf(c))) stack.push(c);
            else {
                if (!stack.isEmpty() && isMatch(stack.peek(), c)) {
                    stack.pop();
                } else return false;
            }
        }
        return stack.isEmpty();
    }
    
    private boolean isMatch(char l, char r) {
        return (l == '(' && r == ')')
            || (l == '[' && r == ']')
            || (l == '{' && r == '}');
    }
}