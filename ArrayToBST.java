class ArrayToBST {
    public TreeNode sortedArrayToBST(int[] num) {
        return sortedArrayToBST(num, 0, num.length-1);
    }

    public TreeNode sortedArrayToBST(int[] num, int start, int end){
        if (start > end) return null;
        if (start == end) return new TreeNode(num[start]);
        // start < end: pick mid as root and recurse
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBST(num, start, mid-1);
        root.right = sortedArrayToBST(num, mid+1, end);
        return root;
    }
}
