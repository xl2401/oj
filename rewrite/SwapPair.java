public class Solution {
    public ListNode swapPairs(ListNode head) {       
    	// null check
    	if (head == null || head.next == null)
    		return head;
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	ListNode ptr = dummy;
    	while (ptr.next != null && ptr.next.next != null) {
    		ListNode last = ptr;
    		ListNode p1 = ptr.next;
    		ListNode p2 = ptr.next.next;
     		last.next = p2;
    		p1.next = p2.next;
    		p2.next = p1;
    		// advance
    		ptr = p1;
	    }
	    return dummy.next;
    }
}