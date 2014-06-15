import java.util.LinkedList;

/*
 * 3.5
 * Implement queue using two stacks
 */
public class MyQueue {
    // used to store tmp data
    LinkedList<Integer> bufferStack;
    // used to store res
    LinkedList<Integer> resStack;

    public MyQueue() {
        bufferStack = new LinkedList<Integer>();
        resStack = new LinkedList<Integer>();
    }

    public void add(int val) {
        bufferStack.push(val);
    }

    public int poll() 
        throws Exception {
        if (resStack.isEmpty()) {
            if (bufferStack.isEmpty()) {
                throw new Exception("try to poll from empty queue");
            } else {
                // buffer -> res
                while (!bufferStack.isEmpty()) {
                    resStack.push(bufferStack.pop());
                }
            }
        }
        return resStack.pop();
    }

    public static void main(String[] args) throws Exception {
        MyQueue mq = new MyQueue();
        mq.add(1);
        mq.add(2);
        mq.add(3);
        System.out.println(mq.poll());
        System.out.println(mq.poll());
    }
}
