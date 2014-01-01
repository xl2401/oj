import java.util.LinkedList;

public class ValidParentheses {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '['){
                stack.push(c);
            }
            // prevent pop empty stack
            if (stack.isEmpty() && (c == ')' || c == '}' || c == ']')){
                return false;
            }
            if (c == ')'){
                char prevChar = stack.pop();
                if (!(prevChar == '(')) return false;
            }
            if (c == '}'){
                char prevChar = stack.pop();
                if (!(prevChar == '{')) return false;
            }
            if (c == ']'){
                char prevChar = stack.pop();
                if (!(prevChar == '[')) return false;
            }
        }
        // final check
        if (stack.isEmpty()) return true;
        else return false;
    }

    public static void main(String[] args){
        System.out.println(new ValidParentheses().isValid("(){}[]"));
        System.out.println(new ValidParentheses().isValid("([)]"));
    }
}
