/*
 * 3.1
 * Implement several stacks with a single array
 *
 * Solution:
 * Every stack is flexible in size. When full, shift the next stack 1 slot rightward.
 */
class Stack {
    public int start;
    public int capacity;
    public int top;
    public int size;

    public Stack(int idx, int capacity) {
        this.capacity = capacity;
        this.top = idx - 1;
        this.size = 0;
        this.start = idx;
    }

    public boolean isWithinStack(int idx, int totalSize) {
        if (start <= idx && idx < start+capacity) {
            return true;
        } else if (start+capacity>totalSize && 
                idx < (start+capacity)/totalSize){
            return true;
        }
        return false;
    }
}

public class ArrayStack {
    private int numOfStack;
    private int stackSize;
    private int totalSize;
    private Stack[] stacks;
    private int[] buffer;

    public ArrayStack(int numOfStack, int stackSize) {
        this.numOfStack = numOfStack;
        this.stackSize = stackSize;
        this.totalSize = numOfStack * stackSize;
        // init stacks
        stacks = new Stack[numOfStack];
        for (int i = 0; i < numOfStack; i++) {
            stacks[i] = new Stack(i*stackSize, stackSize);
        }
        buffer = new int[totalSize];
    }

    private int numOfElements() {
        int cnt = 0;
        for (int i = 0; i < numOfStack; i++) {
            cnt += stacks[i].size;
        }
        return cnt;
    }

    private int nextStack(int stackNum) {
        return (stackNum + 1) % numOfStack;
    }

    private int nextIdx(int idx) {
        return (idx + 1) % totalSize;
    }

    private int prevIdx(int idx) {
        if (idx == 0) return totalSize - 1;
        else return idx - 1;
    }

    private int nextNIdx(int idx, int n) {
        return (idx + n) % totalSize;
    }

    private void shift(int stackNum) {
        Stack curStack = stacks[stackNum];
        Stack nStack = stacks[nextStack(stackNum)];
        if (nStack.size >= nStack.capacity) {
            shift(nextStack(stackNum));
        }
        for (int i = nextNIdx(curStack.start, curStack.size); curStack.isWithinStack(i, totalSize); i = prevIdx(i)) {
            buffer[i] = buffer[prevIdx(i)];
        }
        curStack.start = nextIdx(curStack.start);
        curStack.capacity--;
        curStack.top = nextIdx(curStack.top);
    }

    private void expand(int stackNum) {
        shift(nextStack(stackNum));
        // update capacity
        stacks[stackNum].capacity++;
    }

    public void push(int stackNum, int val) 
        throws Exception {
        if (numOfElements() >= totalSize) {
            throw new Exception("Out of space");
        }
        // check if space enough in the current stack
        Stack curStack = stacks[stackNum];
        if (curStack.size >= curStack.capacity) {
            expand(stackNum);
        }
        // add element
        curStack.top = nextIdx(curStack.top);
        buffer[curStack.top] = val;
        curStack.size++;
    }

    public int pop(int stackNum) 
        throws Exception {
        Stack curStack = stacks[stackNum];
        if (curStack.size == 0)
            throw new Exception("Try to pop from empty stack");
        int val = peek(stackNum);
        curStack.top = prevIdx(curStack.top);
        curStack.size--;
        return val;
    }

    public int peek(int stackNum) {
        int idx = stacks[stackNum].top;
        return buffer[idx];
    }

    public static void main(String[] args) throws Exception{
        ArrayStack as = new ArrayStack(3, 3);
        as.push(0, 1);
        as.push(0, 2);
        as.push(0, 3);
        as.push(0, 4);
        System.out.println(as.pop(0));
        as.push(0, 5);
        System.out.println(as.pop(0));
    }
}
