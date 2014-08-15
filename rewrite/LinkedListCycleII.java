public class Solution {
    public ListNode detectCycle(ListNode head) {        
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            slow = slow.next;
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        slow = head;
        while (slow != fast) {
        	slow = slow.next;
        	fast = fast.next;
        }
        return slow;
    }
}