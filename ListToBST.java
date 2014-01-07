public class ListToBST {
    public class Wrapper{
        public ListNode node;
        public Wrapper(ListNode n){
            this.node = n;
        }
    }
    public TreeNode sortedListToBST(ListNode head) {
        int N = listSize(head);
        return sortedListToBST(this.new Wrapper(head), 0, N-1);
    }

    public int listSize(ListNode ptr){
        int size = 0;
        while (ptr != null){
            size++;
            ptr = ptr.next;
        }
        return size;
    }

    public TreeNode sortedListToBST(Wrapper head, int start, int end){
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode left = sortedListToBST(head, start, mid - 1);
        TreeNode root = new TreeNode(head.node.val);
        head.node = head.node.next;
        TreeNode right = sortedListToBST(head, mid + 1, end);
        root.left = left;
        root.right = right;
        return root;
    }
}
