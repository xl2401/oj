public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) return null;
        return helper(lists);
    }

    public ListNode helper(List<ListNode> lists) {
        List<ListNode> newLists = new ArrayList<ListNode>();
        for (int i = 0; i < lists.size()-1; i += 2) {
            ListNode a = lists.get(i);
            ListNode b = lists.get(i+1);
            newLists.add(mergeList(a, b));
        }
        if (lists.size() % 2 == 1) newLists.add(lists.get(lists.size()-1));
        if (newLists.size() == 1) return newLists.get(0);
        else return helper(newLists);
    }

    private ListNode mergeList(ListNode a, ListNode b) {
        ListNode dum = new ListNode(0);
        ListNode prev = dum;
        while (a != null && b != null) {
            if (a.val < b.val) {
                prev.next = a;
                prev = a;
                a = a.next;
            } else {
                prev.next = b;
                prev = b;
                b = b.next;
            }
        }
        if (a != null) prev.next = a;
        if (b != null) prev.next = b;
        return dum.next;
    }
}