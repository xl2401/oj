public class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode former = head;
        ListNode later = head;
        // move later forward
        for (int i = 0; i < n; i++){
            later = later.next;
        }
        // special condition: Remove first
        if (later ==  null) return head.next;
        // move together
        while (later.next != null){
            former = former.next;
            later = later.next;
        }
        former.next = former.next.next;
        return head;
    }

    public static void main(String[] args){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        RemoveNthNode r = new RemoveNthNode();
        ListNode head = r.removeNthFromEnd(a, 2);
        // print list
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
