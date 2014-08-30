/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        int N = listLen(head);
        if (head == null || N < 3) return;
        ListNode l = head;
        ListNode r = head;
        for (int i = 0; i < N/2; i++) {
            r = r.next;
        }
        while (r.next != null) {
            l = l.next;
            r = r.next;
        }
        ListNode p = head;
        ListNode q = l.next;
        q = reverse(q);
        l.next = null;
        while (q != null) {
            ListNode qNext = q.next;
            ListNode pNext = p.next;
            p.next = q;
            q.next = pNext;
            p = pNext;
            q = qNext;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode headNext = head.next;
            head.next = prev;
            prev = head;
            head = headNext;
        }
        return prev;
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