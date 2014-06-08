/*
 * 2.2
 * retrieve the kth to the last element
 * if k=1, then return the last element
 *
 * Solution
 * runner technique
 */
public class LastK {
    public ListNode lastK(ListNode head, int k) {
        ListNode p1 = head;
        ListNode p2 = head;
        for (int i = 0; i < k; i++) {
            if (p2 == null)
                return null;
            p2 = p2.next;
        }
        // sometimes I mistakenly use `if` instead of `while`
        // which will cause error!!
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        int[] vals = {1,2,3,4,5};
        ListNode head = ListNode.constructList(vals);
        System.out.println(new LastK().lastK(head, 3).val);
    }
}
