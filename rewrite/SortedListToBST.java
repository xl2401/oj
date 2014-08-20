public class Solution {
    private ListNode cur;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        int N = listLen(head);
        cur = head;
        return helper(0, N-1);
    }

    private int listLen(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    private TreeNode helper(int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode left = helper(start, mid-1);
        TreeNode root = new TreeNode(cur.val);
        cur = cur.next;
        TreeNode right = helper(mid+1, end);
        root.left = left;
        root.right = right;
        return root;
    }
}