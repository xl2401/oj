import java.util.LinkedList;

/*
 * 3.2
 * Implement stack that support min that returns the minimum element of the stack in O(1) time
 *
 * Solution:
 * maintain another minStack to record the min val
 */
public class MinStack {
    LinkedList<Integer> stack;
    LinkedList<Integer> minStack;

    public MinStack() {
        stack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val < minStack.peek()) {
            minStack.push(val);
        }
    }

    public int min() {
        return minStack.peek();
    }

    public int pop() {
        int res = stack.pop();
        if (res == minStack.peek()) {
            minStack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(5);
        ms.push(3);
        ms.push(8);
        ms.push(6);
        System.out.println(ms.min());
        ms.pop();
        ms.pop();
        ms.pop();
        System.out.println(ms.min());
    }
}
