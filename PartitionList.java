public class PartitionList{
    public ListNode partition(ListNode head, int x) {
        // prepresnet the smaller list
        ListNode sDummy = new ListNode(0);
        // the original list, go over it, remove the smaller one
        // and insert to smaller list. at last, it will only
        // contains equal or larger element
        ListNode lDummy = new ListNode(0);
        lDummy.next = head;
        // maintain for deletion
        ListNode prev = lDummy;
        // the last element of smaller list
        ListNode sLast = sDummy;
        
        while (prev != null && prev.next != null){
            ListNode cur = prev.next;
            if (cur.val < x){
                // delete
                prev.next = cur.next;
                // move to smaller list
                sLast.next = cur;
                sLast = cur;
                sLast.next = null;
            }
            else{
                prev = cur;
            }
        }
        // combine
        sLast.next = lDummy.next;
        return sDummy.next;
    }
}
