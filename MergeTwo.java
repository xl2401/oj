public class MergeTwo {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val) {
                ListNode newNode = new ListNode(l1.val);
                prev.next = newNode;
                prev = newNode;
                l1 = l1.next;
            }
            else{
                ListNode newNode = new ListNode(l2.val);
                prev.next = newNode;
                prev = newNode;
                l2 = l2.next;
            }
        }
        if (l1 == null) prev.next = l2;
        else prev.next = l1;
        return dummy.next;
    }
}
