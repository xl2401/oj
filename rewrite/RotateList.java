public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) return null;
        int len = listLen(head);
        n = n % len;
        if (n == 0) return head;
        ListNode p = head;
        ListNode q = head;
        for (int i = 0; i < n; i++) {
            q = q.next;
        }
        while (q.next != null) {
            p = p.next;
            q = q.next;
        }
        ListNode r = p.next;
        p.next = null;
        q.next = head;
        return r;
    }

    private int listLen(ListNode head) {
        int cnt = 0;
        while (head != null) {
            cnt++;
            head = head.next;
        }
        return cnt;
    }
}