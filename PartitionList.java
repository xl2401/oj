import java.util.ArrayList;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ArrayList<ListNode> less = new ArrayList<ListNode>();
        ArrayList<ListNode> greater = new ArrayList<ListNode>();
        while (head != null){
            if (head.val >= x) greater.add(head);
            else less.add(head);
            head = head.next;
        }
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        for (ListNode cur: less){
            prev.next = cur;
            prev = cur;
        }
        for (int i = 0; i < greater.size(); i++){
            ListNode cur = greater.get(i);
            prev.next = cur;
            prev = cur;
            if (i == greater.size()-1) cur.next = null;
        }
        return dummy.next;
    }

    public static void main(String[] args){
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(1);
        a.next = b;
        ListNode head = new PartitionList().partition(a, 2);
        System.out.println(head.val);
        System.out.println(head.next.val);
    }
}
