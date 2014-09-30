class RandTreeNode {
    RandTreeNode left;
    RandTreeNode right;
    RandTreeNode rand;
    int val;

    public RandTreeNode(int val) {
        this.val = val;
    }
}

/*
 * Clone a Binary Tree with Random Pointers
 * http://www.geeksforgeeks.org/clone-binary-tree-random-pointers/
 *
 * Solution:
 * put the new node to the left of the original node and then recover
 */
public class Solution {
    public RandTreeNode cloneWithRandom(RandTreeNode root) {
        // put the new Node to the left of the original node
        insertNew(root);
        return recover(root);
    }

    // insert new node to the left of original node
    private void insertNew(RandTreeNode root) {
        // base case
        if (root == null) return;
        RandTreeNode rootLeft = root.left;
        RandTreeNode newNode = new RandTreeNode(root.val);
        root.left = newNode;
        newNode.left = rootLeft;
        insertNew(rootLeft);
        insertNew(root.right);
    }

    // extract the new tree and recover the old tree
    private RandTreeNode recover(RandTreeNode root) {
        // base case
        if (root == null) return null;
        RandTreeNode newRoot = root.left;
        RandTreeNode newLeft = recover(newRoot.left);
        RandTreeNode newRight = recover(root.right);
        newRoot.left = newLeft;
        newRoot.right = newRight;
        // rand
        newRoot.rand = root.rand == null ? null : root.rand.left;
        // recover original tree
        root.left = newRoot.left;
        return newRoot;
    }
}
