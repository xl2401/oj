public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dum = new ListNode(0);
        dum.next = head;
        // s is the pointer before we check dup
        ListNode s = dum;
        while (s.next != null) {
            ListNode ptr = s.next;
            int cnt = 0;
            while (ptr != null && ptr.val == s.next.val){
                ptr = ptr.next;
                cnt++;
            }
            if (cnt > 1) {
                s.next = ptr;
            } else {
                s = s.next;
            }
        }
        return dum.next;
    }
}
