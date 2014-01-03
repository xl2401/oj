public class RemoveDupList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        int headVal =  head.val;
        while (head.next != null && head.next.val == headVal)
            head = head.next;
        if (head.next == null) return head;
        else{
            ListNode i = head;
            ListNode j = head.next;
            while (i != null && j != null){
                ListNode k = j.next;
                if (k == null) break;
                else{
                    if (j.val == k.val){
                        i.next = k;
                        j = k;
                    }
                    else{
                        i = j;
                        j = j.next;
                    }
                }
            }
        }
        return head;
    }

    public static void main(String[] args){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(3);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode head = new RemoveDupList().deleteDuplicates(a);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
