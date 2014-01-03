public class SwapNodes {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode i = head;
        ListNode j = head.next;
        head = j;
        while (j != null && i != null){
            ListNode nexti = j.next;
            j.next = i;
            if (nexti == null){
                i.next = null;
                break;
            }
            else{
                ListNode nextj = nexti.next;
                if (nextj == null){
                    i.next = nexti;
                    break;
                }
                else{
                    i.next = nextj;
                    i = nexti;
                    j = nextj;
                }
            }
        }
        return head;
    }

    public static void main(String[] args){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;
        ListNode head = new SwapNodes().swapPairs(a);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
