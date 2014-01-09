import java.util.ArrayList;

/*
 * Title: Unique Binary Search Trees II 
 * Description:
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 *
 * Solution:
 * recursively get lefttrees and righttrees and combine them together
 * here we reuse the left trees, thus performance improve!
 * pay special attention to start > end, add null into the trees collection
 */
class UniqueBST2Imporve{
    public ArrayList<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    public ArrayList<TreeNode> generateTrees(int start, int end){
        if (start > end){
            ArrayList<TreeNode> nullTrees = new ArrayList<TreeNode>();
            TreeNode nullRoot = null;
            nullTrees.add(nullRoot);
            return nullTrees;
        }
        ArrayList<TreeNode> curTrees = new ArrayList<TreeNode>();
        for (int i = start; i <= end; i++){
            ArrayList<TreeNode> leftTrees = generateTrees(start, i-1);
            ArrayList<TreeNode> rightTrees = generateTrees(i+1, end);
            // left root right
            for (int p = 0; p < leftTrees.size(); p++){
                TreeNode leftRoot = leftTrees.get(p);
                for (int q = 0; q < rightTrees.size(); q++){
                    TreeNode rightRoot = rightTrees.get(q);
                    TreeNode root = new TreeNode(i);
                    root.left = leftRoot;
                    root.right = rightRoot;
                    curTrees.add(root);
                }
            }
        }
        return curTrees;
    }
}
