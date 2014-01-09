import java.util.LinkedList;

/*
 * Title: Reverse Linked List II 
 * Description:
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 *
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 *
 * return 1->4->3->2->5->NULL.
 *
 * Solution: not in place
 */
public class ReverseLinkedList {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode p = head;
        ListNode q = head;
        for (int i = 0; i < m-1; i++){
            p = p.next;
            q = q.next;
        }
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i <= n-m; i++){
            stack.push(q.val);
            q = q.next;
        }
        while (!stack.isEmpty()){
            p.val = stack.pop();
            p = p.next;
        }
        return head;
    }
}
