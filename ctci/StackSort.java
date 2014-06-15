import java.util.LinkedList;
import java.util.Arrays;

/*
 * 3.6
 * Sort a stack with an additional stack
 * this is essentially insertion sort
 */
public class StackSort {
    public LinkedList<Integer> sort(LinkedList<Integer> stack) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        while (!stack.isEmpty()) {
            int curVal = stack.pop();
            while (!res.isEmpty() && curVal < res.peek()) {
                stack.push(res.pop());
            }
            res.push(curVal);
        }
        return res;
    }

    public static void main(String[] args) {
        LinkedList<Integer> stack = new LinkedList<Integer>(Arrays.asList(3,1,5,2,4));
        LinkedList<Integer> res = new StackSort().sort(stack);
        while (!res.isEmpty()) {
            System.out.println(res.pop());
        }
    }
}
