/*
 * 2.4
 * Partition list around val x,
 * all nodes less than x come before nodes equal or larger than x
 */
public class PartitionList {
    // just throw every node that's smaller than x to the front
    // right after dummy
    // order not maintained
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = head;
        while (prev != null && prev.next != null) {
            ListNode cur = prev.next;
            if (cur.val < x) {
                // move to front
                prev.next = cur.next;
                cur.next = dummy.next;
                dummy.next = cur;
            } else {
                prev = prev.next;
            }
        }
        return dummy.next;
    }

    // maintain 2 list list1 list2
    // put node val < x in list1
    // other in list2
    // then connect
    public ListNode partionWithOrder(ListNode head, int x) {
        ListNode l1Dummy = new ListNode(0);
        ListNode l2Dummy = new ListNode(0);
        ListNode l1Prev = l1Dummy;
        ListNode l2Prev = l2Dummy;
        while (head != null) {
            if (head.val < x) {
                l1Prev.next = head;
                l1Prev = head;
            } else {
                l2Prev.next = head;
                l2Prev = head;
            }
            // don't forget to move forward
            // otherwise -> infinity loop
            head = head.next;
        }
        l1Prev.next = l2Dummy.next;
        l2Prev.next = null;
        return l1Dummy.next;
    }

    public static void main(String[] args) {
        int[] vals = {3,5,1,4,2};
        ListNode head = ListNode.constructList(vals);
        head = new PartitionList().partition(head, 3);
        ListNode.printList(head);
        head = ListNode.constructList(vals);
        head = new PartitionList().partionWithOrder(head, 3);
        ListNode.printList(head);
    }
}
