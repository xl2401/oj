/*
 * 2.3
 * Given the middle node (not the last one) of a single linked list,
 * delete the node
 *
 * Solution:
 * copy the data of the subsequent node, delete the next node
 */
public class DeleteNode {
    public boolean deleteNode(ListNode node) {
        if (node == null || node.next == null) return false;
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
        return true;
    }

    public static void main(String[] args) {
        int[] vals = {1,2,3,4,5};
        ListNode head = ListNode.constructList(vals);
        ListNode node = head.next.next.next;
        new DeleteNode().deleteNode(node);
        ListNode.printList(head);
    }
}
