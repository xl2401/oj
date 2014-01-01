public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        ListNode fastNode = head;
        ListNode slowNode = head;
        // special condition
        if (head == null || head.next == null || head.next.next == null) return null;
        fastNode = head.next.next;
        slowNode = head.next;
        // chasing til collide
        while (fastNode != slowNode){
            if (fastNode == null || fastNode.next == null) return null;
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        // reset and collide at first node
        fastNode = head;
        while (fastNode != slowNode){
            if (fastNode == null || slowNode == null) return null;
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }
}
