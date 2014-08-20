public class Solution {
	public ListNode partition(ListNode head, int x) {
        ListNode sDummy = new ListNode(0);
        ListNode lDummy = new ListNode(0);
        ListNode sPrev = sDummy;
        ListNode lPrev = lDummy;
        while (head != null) {
            if (head.val < x) {
                sPrev.next = head;
                sPrev = head;
            } else {
                lPrev.next = head;
                lPrev = head;
            }
            head = head.next;
        }
        // this is very important, to terminate the list
        lPrev.next = null;
        // connect
        sPrev.next = lDummy.next;
        return sDummy.next;
    }
}