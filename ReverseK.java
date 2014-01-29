/*
 * Title: Reverse Nodes in k-Group
 * Description:
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * You may not alter the values in the nodes, only nodes itself may be changed.
 *
 * Only constant memory is allowed.
 *
 * For example,
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
 *
 * Solution:
 * the basic thought is to use 2 pointers to reverse sublist, and do additional adjust
 * pay attention to the dummy node
 * learn to use more variables to record meaningful location
 */
public class ReverseK {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevLast = dummy; 
        ListNode start = head;
        while (true){
            ListNode last = findKNext(start, k);
            if (last == null){
                break;
            }
            ListNode p = start;
            ListNode q = start.next;
            ListNode lastNext = last.next;
            for (int i = 0; i < k - 1; i++){
                ListNode qNext = q.next;
                q.next = p;
                p = q;
                q = qNext;
            }
            prevLast.next = last;
            start.next = lastNext;
            prevLast = start;
            start = lastNext;
        }
        return dummy.next;
    }

    public ListNode findKNext(ListNode head, int k){
        for (int i = 0; i < k - 1; i++){
            if (head == null){
                return null;
            }
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ReverseK rk = new ReverseK();
        ListNode head = rk.reverseKGroup(a, 3);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
