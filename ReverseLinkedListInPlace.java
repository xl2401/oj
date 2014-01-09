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
 * Solution:
 * 1. swap the corrosponding node `value`
 * interate over half of the sublist
 * this is O(N^2)
 * 2. directly manipulate node O(N)
 */
public class ReverseLinkedListInPlace {
    public ListNode reverseBetween2(ListNode head, int m, int n) {
        int swapNum = (n - m + 1) / 2;
        ListNode p = head;
        // push p to the start point
        for (int i = 0; i < m-1; i++){
            p = p.next;
        }
        for (int i = 0; i < swapNum; i++){
            ListNode q = p;
            int step = n - m - 2 * i;
            for (int j = 0; j < step; j++){
                q = q.next;
            }
            //swap p and q
            int temp = p.val;
            p.val = q.val;
            q.val = temp;
            p = p.next;
        }
        return head;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        ListNode q = head;
        for (int i = 0; i < m-1; i++){
            p = p.next;
            q = q.next;
        }
        // swap node q.next in front of q
        for (int i = 0; i < n-m; i++){
            ListNode r = q.next;
            q.next = r.next;
            r.next = p.next;
            p.next = r;
        }
        return dummy.next;
    }

    public static void main(String[] args){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        ListNode head = new ReverseLinkedListInPlace().reverseBetween(a, 1, 4);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
