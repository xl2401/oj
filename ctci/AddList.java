/*
 * 2.5
 * Add two List
 * 1. backward
 * 2. forward
 */ 
class Partial {
    ListNode node;
    int carry;

    public Partial() {
        this.node = null;
        this.carry = 0;
    }

    public Partial(ListNode node, int carry) {
        this.node = node;
        this.carry = carry;
    }
}

public class AddList {
    // adding backward
    // 1->2->3 : 321
    public ListNode addList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        int carry = 0;
        // remember to forward the loop!!
        // otherwise it won't stop
        // if <-> while
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + carry;
            int val = sum % 10;
            carry = sum / 10;
            ListNode cur = new ListNode(val);
            prev.next = cur;
            prev = cur;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry != 0) {
            ListNode cur = new ListNode(1);
            prev.next = cur;
        }
        return dummy.next;
    }

    // adding forward
    // 1->2->3: 123
    // padding list to make them same len
    // then use recursive to add
    public ListNode addListForward(ListNode l1, ListNode l2) {
        // get len
        int len1 = listLen(l1);
        int len2 = listLen(l2);
        // padding
        if (len1 > len2) {
            l2 = paddingZero(l2, len1-len2);
        }
        if (len1 < len2) {
            l1 = paddingZero(l1, len2-len1);
        }
        // add
        Partial resPartial = addHelper(l1, l2);
        if (resPartial.carry != 0) {
            ListNode carryNode = new ListNode(1);
            carryNode.next = resPartial.node;
            return carryNode;
        } else {
            return resPartial.node;
        }
    }

    // precondition, len(l1) == len(l2)
    private Partial addHelper(ListNode l1, ListNode l2) {
        // base condition!!
        if (l1 == null) {
            return new Partial();
        } else {
            Partial prevPartial = addHelper(l1.next, l2.next);
            ListNode prevNode = prevPartial.node;
            int sum = l1.val + l2.val + prevPartial.carry;
            ListNode curNode = new ListNode(sum%10);
            curNode.next = prevNode;
            return new Partial(curNode, sum/10);
        }
    }

    private ListNode paddingZero(ListNode l, int cnt) {
        ListNode head = l;
        for (int i = 0; i < cnt; i++) {
            ListNode zeroNode = new ListNode(0);
            zeroNode.next = head;
            head = zeroNode;
        }
        return head;
    }

    private int listLen(ListNode l) {
        int cnt = 0;
        while (l != null) {
            l = l.next;
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] vals1 = {8, 7, 9};
        int[] vals2 = {2, 4};
        ListNode l1 = ListNode.constructList(vals1);
        ListNode l2 = ListNode.constructList(vals2);
        ListNode res = new AddList().addList(l1, l2);
        ListNode.printList(res);
        res = new AddList().addListForward(l1, l2);
        ListNode.printList(res);
    }
}
