import java.util.ArrayList;
import java.util.LinkedList;

/*
 * 3.3
 * Create a stack that will topple,
 * if the stack exceed the threshold, it will create a new stack
 */
public class ToppleStack {
    private ArrayList<LinkedList<Integer>> stacks;
    private int limit;

    public ToppleStack(int limit) {
        this.stacks = new ArrayList<LinkedList<Integer>>();
        this.limit = limit;
    }

    public void push(int val) {
        LinkedList<Integer> lastStack = getLastStack();
        // new stack
        if (lastStack == null || lastStack.size() >= limit) {
            lastStack = new LinkedList<Integer>();
            stacks.add(lastStack);
        }
        lastStack.push(val);
    }

    public int pop() 
        throws Exception {
        LinkedList<Integer> lastStack = getLastStack();
        if (lastStack == null) {
            throw new Exception("try to pop from empty stack");
        }
        int val = lastStack.pop();
        if (lastStack.size() == 0) {
            stacks.remove(stacks.size()-1);
        }
        return val;
    }

    public int popAt(int sIdx) throws Exception{
        if (sIdx >= stacks.size()) {
            throw new Exception("stack idx too large");
        }
        LinkedList<Integer> curStack = stacks.get(sIdx);
        int val = curStack.pop();
        if (sIdx + 1 < stacks.size()) {
            curStack.push(mvBtmLeft(sIdx+1));
        }
        if (curStack.size() == 0) {
            stacks.remove(stacks.size()-1);
        }
        return val;
    }

    private int mvBtmLeft(int sIdx) {
        LinkedList<Integer> curStack = stacks.get(sIdx);
        int val = curStack.removeLast();
        if (sIdx+1 < stacks.size()) {
            curStack.push(mvBtmLeft(sIdx+1));
        }
        if (curStack.size() == 0) {
            stacks.remove(stacks.size()-1);
        }
        return val;
    }

    private LinkedList<Integer> getLastStack() {
        if (stacks.size() == 0)
            return null;
        return stacks.get(stacks.size()-1);
    }

    public static void main(String[] args) 
        throws Exception {
        ToppleStack ts = new ToppleStack(2);
        ts.push(1);
        ts.push(2);
        ts.push(3);
        ts.push(4);
        ts.push(5);
        System.out.println(ts.popAt(1));
        System.out.println(ts.popAt(1));
    }
}
