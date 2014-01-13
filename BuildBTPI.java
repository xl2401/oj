/*
 * Title: Construct Binary Tree from Preorder and Inorder Traversal
 * Description:
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * Solution:
 * recursive, find root in preorder first, find the element in inorder to get idx
 */
public class BuildBTPI {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int pl, int pr, int il, int ir){
        if (pl <= pr && il <= ir){
            // the first element of preorder is root
            int rootNum = preorder[pl];
            TreeNode root = new TreeNode(rootNum);
            // find root in inorder
            int rootInorderIdx = 0;
            for (int i = il; i <= ir; i++){
                if (inorder[i] == rootNum){
                    rootInorderIdx = i;
                    break;
                }
            }
            int leftTreeCount = rootInorderIdx - il;
            int rightTreeCount = ir - rootInorderIdx;
            TreeNode leftTree = buildTree(preorder, inorder, pl+1, pl+leftTreeCount, il, rootInorderIdx-1);
            TreeNode rightTree = buildTree(preorder, inorder, pl+leftTreeCount+1, pr, rootInorderIdx+1, ir);
            root.left = leftTree;
            root.right = rightTree;
            return root;
        }
        return null;
    }

    public static void main(String[] args){
        int[] preorder = {1,2,4,5,3,6};
        int[] inorder = {4,2,5,1,6,3};
        new BuildBTPI().buildTree(preorder, inorder);
    }
}
