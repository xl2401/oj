public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode result = head;
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null){
            // iterate from head to cur
            ListNode iterPrev = null;
            ListNode iterCur = result;
            while (iterCur != cur){
                if (iterCur.val > cur.val){
                    break;
                }
                iterPrev = iterCur;
                iterCur = iterCur.next;
            }
            if (iterCur != cur){// need to insert
                prev.next = cur.next;
                if (iterPrev != null){
                    iterPrev.next = cur;
                }
                if (iterPrev == null){
                    result = cur;
                }
                cur.next = iterCur;
                cur = prev.next;
                continue;
            }
            prev = cur;
            cur = cur.next;
        }
        return result;
    }
}
