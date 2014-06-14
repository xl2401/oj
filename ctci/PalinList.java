import java.util.LinkedList;

/*
 * 2.7
 * check a linkedlist is a palindrome
 */
public class PalinList {
    public boolean isPalin(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int len = listLen(head);
        int ptr = 0;
        while (head != null) {
            // add to stack
            /*
            if (len % 2 == 0 || (len / 2 != ptr)) {
                if (!stack.isEmpty() && stack.peek() == head.val) {
                    stack.pop();
                } else {
                    stack.push(head.val);
                }
            }
            */
            // write condition as u think, do not optimize
            if (!(len % 2 == 1 && len / 2 == ptr)) {
                if (!stack.isEmpty() && stack.peek() == head.val) {
                    stack.pop();
                } else {
                    stack.push(head.val);
                }
            }
            // forward
            ptr++;
            head = head.next;
        }
        return stack.size() == 0;
    }

    public boolean isPalin2(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null) {
            if (stack.pop() != slow.val) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    private int listLen(ListNode head) {
        int cnt = 0;
        while (head != null) {
            cnt++;
            head = head.next;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] vals = {1,2,3,2,1};
        ListNode head = ListNode.constructList(vals);
        System.out.println(new PalinList().isPalin(head));
        System.out.println(new PalinList().isPalin2(head));
    }
}
