public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        while (second != null){
            first = first.next;
            ListNode secondNext = second.next;
            if (secondNext == null) break;
            second = secondNext.next;
            if (first == second) return true;
        }
        return false;
    }
}
