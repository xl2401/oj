import java.util.Stack;

public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.isEmpty()) return 0;
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    // update
                    stack.pop();
                    max = Math.max(max, i-(stack.isEmpty()? -1:stack.peek()));
                } else {
                    stack.push(i);
                }
            }
        }
        return max;
    }
}