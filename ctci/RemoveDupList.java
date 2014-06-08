import java.util.HashSet;


/*
 * 2.1
 * Remove duplicate number in a list
 * use a hashset as a record
 * when remove, maintain a ptr to record the prev node
 */
public class RemoveDupList {
    public void rmDup(ListNode head) {
        HashSet<Integer> appear = new HashSet<Integer>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (prev.next != null) {
            ListNode cur = prev.next;
            if (appear.contains(cur.val)) {
                // delete
                prev.next = cur.next;
            } else {
                appear.add(cur.val);
                prev = cur;
            }
        }
    }

    public void rmDupWithoutBuffer(ListNode head) {
        ListNode ptr = head;
        ListNode prev = head;
        while (ptr != null) {
            while (prev.next != null) {
                if (prev.next.val == ptr.val) {
                    prev.next = prev.next.next;
                } else {
                    prev = prev.next;
                }
            }
            ptr = ptr.next;
            prev = ptr;
        }
    }

    public static void main(String[] args) {
        int[] vals = {3,3,1,4,2,1,3,2};
        ListNode head = ListNode.constuctList(vals);
        // new RemoveDupList().rmDup(head);
        new RemoveDupList().rmDupWithoutBuffer(head);
        ListNode.printList(head);
    }
}
