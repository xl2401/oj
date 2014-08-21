public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode dum = new ListNode(0);
        while (head != null) {
            ListNode headNext = head.next;
            ListNode ptr = dum;
            while (ptr.next != null && ptr.next.val <= head.val) {
                ptr = ptr.next;
            }
            head.next = ptr.next;
            ptr.next = head;
            head = headNext;
        }
        return dum.next;
    }
}