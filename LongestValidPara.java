import java.util.LinkedList;

/*
 * Title: Longest Valid Parentheses
 * Description: 
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 *
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 *
 * Solution:
 */
public class LongestValidPara {
    public int longestValidParentheses(String s) {
        LinkedList<Character> stack = new LinkedList<Character>();
        LinkedList<Integer> idxStack = new LinkedList<Integer>();
        int max = 0;
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '('){
                stack.push('(');
                idxStack.push(i);
            }
            else{
                if (!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                    idxStack.pop();
                    int curLen = i - (stack.isEmpty() ? -1: idxStack.peek());
                    max = Math.max(max, curLen);
                }
                else{
                    stack.push(')');
                    idxStack.push(i);
                }
            }
        }
        return max;
    }

    public static void main(String[] args){
        LongestValidPara sol = new LongestValidPara();
        System.out.println(sol.longestValidParentheses("(()(((()"));
    }
}
