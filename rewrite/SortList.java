public class Solution {
    public ListNode sortList(ListNode head) {
        // base condition
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode slowNext = slow.next;
        slow.next = null;
        ListNode l = sortList(head);
        ListNode r = sortList(slowNext);
        return merge(l, r);
    }

    private ListNode merge(ListNode l, ListNode r) {
        ListNode dum = new ListNode(0);
        ListNode prev = dum;
        while (l != null && r != null) {
            if (l.val < r.val) {
                prev.next = l;
                prev = l;
                l = l.next;
            } else {
                prev.next = r;
                prev = r;
                r = r.next;
            }
        }
        if (l != null) prev.next = l;
        if (r != null) prev.next = r;
        return dum.next;
    }
}