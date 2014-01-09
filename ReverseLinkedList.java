import java.util.LinkedList;

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
