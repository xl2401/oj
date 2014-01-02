import java.util.ArrayList;

public class MergeKList {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        ListNode result = null;
        for (ListNode l: lists){
            result = merge2Lists(result, l);
        }
        return result;
    }

    public ListNode merge2Lists(ListNode l1, ListNode l2){
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val) {
                ListNode newNode = new ListNode(l1.val);
                prev.next = newNode;
                prev = newNode;
                l1 = l1.next;
            }
            else{
                ListNode newNode = new ListNode(l2.val);
                prev.next = newNode;
                prev = newNode;
                l2 = l2.next;
            }
        }
        if (l1 == null) prev.next = l2;
        else prev.next = l1;
        return dummy.next;
    }

    public static void main(String[] args){
        ArrayList<ListNode> lists = new ArrayList<ListNode>();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(5);
        ListNode c = new ListNode(10);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(6);
        ListNode f = new ListNode(8);
        ListNode g = new ListNode(9);
        ListNode h = new ListNode(12);
        ListNode m = new ListNode(15);
        a.next = b;
        b.next = c;
        d.next = e;
        f.next = g;
        g.next = h;
        h.next = m;
        lists.add(a);
        lists.add(d);
        lists.add(f);
        ListNode result = new MergeKList().mergeKLists(lists);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
