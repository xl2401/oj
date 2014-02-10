/*
 * Title: Swap Nodes in Pairs 
 * Description:
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 *
 * Solution:
 * When doing list operation(little complicate), first record or the relating node, and then do the operation(this is much easier to do it on the fly)
 */
public class SwapNodes {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode ptr = dummy;
        // ptr is the node before the 2 swapping node
        while (ptr.next != null && ptr.next.next != null){
            ListNode n = ptr.next;
            ListNode nn = ptr.next.next;
            ListNode nnn = ptr.next.next.next;
            ptr.next = nn;
            nn.next = n;
            n.next = nnn;
            ptr = n;
        }
        return dummy.next;
    }
}
