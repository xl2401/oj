public class HasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // should check after advancing,
            // because fast == slow at first
            if (slow == fast)
                return true;
        }
        return false;
    }
}
