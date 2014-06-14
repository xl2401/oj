/*
 * 2.6
 * Given a linkedlist with a loop,
 * find the beginning of the loop
 *
 * Solution:
 * fast slow pointer
 */
public class FindLoopBegin {
    public ListNode findBegin(ListNode head) {
        ListNode ptr1 = head;
        ListNode ptr2 = head;
        while (ptr2 != null && ptr2.next != null) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next.next;
            // use break to end the loop
            // this is also true at the beginning of the loop, so don't put it in while condition
            if (ptr1 == ptr2){
                break;
            }
        }
        if (ptr1 == null || ptr2 == null) return null;
        ptr1 = head;
        while (ptr1 != ptr2){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(0);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = c;
        System.out.println(new FindLoopBegin().findBegin(a).val);
    }
}
