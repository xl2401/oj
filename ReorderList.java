import java.util.LinkedList;

/*
 * Title: Reorder List 
 * Description:
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You must do this in-place without altering the nodes' values.
 *
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 *
 * Solution:
 * fast slow pointer -> find mid
 * use stack to reverse
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null) return;
        LinkedList<ListNode> stack = new LinkedList<ListNode>();
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rHead = slow.next;
        slow.next = null;
        while (rHead != null){
            stack.push(rHead);
            rHead = rHead.next;
        }
        ListNode ptr = head;
        while (!stack.isEmpty()){
            ListNode r = stack.pop();
            r.next = ptr.next;
            ptr.next = r;
            ptr = r.next;
        }
    }

    public static void main(String[] args){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        ReorderList rl = new ReorderList();
        rl.reorderList(a);
        while (a != null){
            System.out.println(a.val);
            a = a.next;
        }
    }
}
