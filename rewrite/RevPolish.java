public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<Integer>();
        for (String token: tokens) {
            try {
                // operand
                int num = Integer.parseInt(token);
                s.push(num);
            } catch (Exception e) {
                // operator
                int b = s.pop();
                int a = s.pop();
                if (token.equals("+")) {
                    s.push(a+b);
                } else if (token.equals("-")) {
                    s.push(a-b);
                } else if (token.equals("*")) {
                    s.push(a*b);
                } else {
                    s.push(a/b);
                }
            }
        }
        return s.pop();
    }
}