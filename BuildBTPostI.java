/*
 * Title: Construct Binary Tree from Inorder and Postorder Traversal 
 * Descrption:
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * Solution:
 * Recursive, find root in post order first, find its indx in inorder
 */
public class BuildBTPostI {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, 
                             int il, int ir, int pl, int pr){
        if (il <= ir && pl <= pr){
            // last element of postorder is root
            int rootNum = postorder[pr];
            TreeNode root = new TreeNode(rootNum);
            // find root index in inorder
            int idx = 0;
            for (int i = il; i <= ir; i++){
                if (inorder[i] == rootNum){
                    idx = i;
                    break;
                }
            }
            int leftCnt = idx - il;
            TreeNode leftRoot = buildTree(inorder, postorder, il, idx-1, pl, pl+leftCnt-1);
            TreeNode rightRoot = buildTree(inorder, postorder, idx+1, ir, pl+leftCnt, pr-1);
            root.left = leftRoot;
            root.right = rightRoot;
            return root;
        }
        return null;
    }

    public static void main(String[] args){
        int[] inorder = {2,1,3};
        int[] postorder = {2,3,1};
        TreeNode root = new BuildBTPostI().buildTree(inorder, postorder);
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
    }
}
