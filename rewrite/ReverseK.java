public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        int len = len(head);
        int groupCnt = len / k;
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode s = dum;
        for (int i = 0; i < groupCnt; i++) {
            ListNode ptr = s.next;
            ListNode last = null;
            ListNode first = null;
            for (int j = 0; j < k; j++) {
                if (last == null) last = ptr;
                ListNode ptrNext = ptr.next;
                ptr.next = first;
                first = ptr;
                ptr = ptrNext;
            }
            s.next = first;
            last.next = ptr;
            s = last;
        }
        return dum.next;
    }

    private int len(ListNode head) {
        int cnt = 0;
        while (head != null) {
            cnt++;
            head = head.next;
        }
        return cnt;
    }
}