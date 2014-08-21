/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m >= n) return head;
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode ptr = dum;
        for (int i = 0; i < m-1; i++) ptr = ptr.next;
        ListNode s = ptr;
        ptr = ptr.next;
        ListNode last = null;
        ListNode first = null;
        for (int i = 0; i < n-m+1; i++) {
            ListNode ptrNext = ptr.next;
            ptr.next = first;
            first = ptr;
            if (last == null) last = ptr;
            ptr = ptrNext;
        }
        ListNode e = ptr;
        s.next = first;
        last.next = e;
        return dum.next;
    }
}