import java.util.LinkedList;

/*
 * Title: Evaluate Reverse Polish Notation
 * Description:
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 * Solution:
 * so easy, use stack
 */
public class EvalRPN {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < tokens.length; i++){
            String c = tokens[i];
            if (!isOp(c)){
                stack.push(Integer.parseInt(c));
            }
            else{
                int oprand1 = stack.pop();
                int oprand2 = stack.pop();
                int result = 0;
                char op = c.charAt(0);
                switch (op){
                    case '+':
                        result = oprand1 + oprand2;
                        break;
                    case '-':
                        result = oprand2 - oprand1;
                        break;
                    case '*':
                        result = oprand2 * oprand1;
                        break;
                    case '/':
                        result = oprand2 / oprand1;
                }
                stack.push(result);
            }
        }
        int result = stack.pop();
        return result;
    }

    public boolean isOp(String s){
        return s.equals("+") || s.equals("-") 
               || s.equals("*") || s.equals("/");
    }

    public static void main(String[] args){
        String[] rpn = {"4","3","-"};
        System.out.println(new EvalRPN().evalRPN(rpn));
    }
}
