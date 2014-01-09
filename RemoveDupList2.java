/*
 * Title:Remove Duplicates from Sorted List II
 * Description:
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 *
 * Solution:
 * Use dummy node, link operation, easy!
 */
public class RemoveDupList2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode i = dummy;
        ListNode j = head;
        ListNode k = head.next;
        while (k != null){
            if (j.val != k.val){
                i = i.next;
                j = j.next;
                k = k.next;
            }
            else{
                // j.val == k.val
                while (k != null && k.val == j.val){
                    j = j.next;
                    k = k.next;
                }
                // either k == null or k.val != j.val
                i.next = k;
                j = j.next;
                if (k != null)
                    k = k.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);

        a.next = b;
        b.next = c;
        ListNode head = new RemoveDupList2().deleteDuplicates(a);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
