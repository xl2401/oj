/**
 * Title: Rotate List 
 * Description:
 * Given a list, rotate the list to the right by k places, where k is non-negative
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 *
 * Solution:
 * Consider n larger than the len of list, so make `mod`
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) return null;
        if (head.next == null) return head;
        int len = listLen(head);
        n = n % len;
        if (n == 0) return head;
        ListNode pre = head;
        ListNode latter = head;
        for (int i = 0; i < n; i++){
            latter = latter.next;
        }
        while (latter.next != null){
            pre = pre.next;
            latter = latter.next;
        }
        latter.next = head;
        head = pre.next;
        pre.next = null;
        return head;
    }

    public int listLen(ListNode head){
        int len = 0;
        while (head != null){
            len++;
            head = head.next;
        }
        return len;
    }
}
