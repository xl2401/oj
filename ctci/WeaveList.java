/*
 * 2.0
 * Weave a list as follows:
 * a1->a2->a3->...->an->b1->b2->b3->...->bn
 * weave into
 * a1->b1->a2->b2->...->an->bn
 *
 * Solution:
 * Runner Technique to find the middle point, draw the graph to determine the final condition of while loop
 * use tmp variable to record nodes
 */
public class WeaveList {
    public void weave(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        if (p2.next == null || p2.next.next == null) return;
        while (p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        p2 = p1.next;
        p1.next = null;
        p1 = head;
        // start to weave
        while (p1 != null && p2 != null) {
            ListNode p2Next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = p2Next;
        }
    }

    public static void main(String[] args) {
        int[] vals = {1, 2, 3, 4, 5, 6};
        ListNode head = ListNode.constuctList(vals);
        new WeaveList().weave(head);
        ListNode.printList(head);
    }
}
