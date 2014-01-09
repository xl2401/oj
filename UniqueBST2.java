import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
 * Title: Unique Binary Search Trees II 
 * Description:
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 *
 * Solution:
 * Note: this solution is not efficient
 * copy tree waste a lot of time
 * there is a recursion solution, refer to UniqueBST2Improve.java
 */
public class UniqueBST2 {
    public ArrayList<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<TreeNode>();
        if (n == 1) return new ArrayList<TreeNode>(Arrays.asList(new TreeNode(1)));
        HashMap<Integer, ArrayList<TreeNode>> treeMap = new HashMap<Integer, ArrayList<TreeNode>>();
        ArrayList<TreeNode> nullTree = new ArrayList<TreeNode>();
        TreeNode nullNode = null;
        nullTree.add(nullNode);
        treeMap.put(0, nullTree);
        for (int i = 1; i <= n; i++){
            ArrayList<TreeNode> curTrees = new ArrayList<TreeNode>();
            for (int j = 1; j <= i; j++){
                ArrayList<TreeNode> leftTrees = treeMap.get(j-1);
                ArrayList<TreeNode> rightTrees = treeMap.get(i-j);
                for (int p = 0; p < leftTrees.size(); p++){
                    TreeNode leftTree = leftTrees.get(p);
                    for (int q = 0; q < rightTrees.size(); q++){
                        TreeNode root = new TreeNode(j);
                        TreeNode curLeftTree = copyTree(leftTree, 0);
                        TreeNode rightTree = rightTrees.get(q);
                        TreeNode curRightTree = copyTree(rightTree, j);
                        root.left = curLeftTree;
                        root.right = curRightTree;
                        curTrees.add(root);
                    }
                }
            }
            if (i == n) return curTrees;
            treeMap.put(i, curTrees);
        }
        return null;
    }

    public TreeNode copyTree(TreeNode root, int addValue){
        if (root == null) return null;
        TreeNode left = null;
        TreeNode right = null;
        if (root.left != null) left = copyTree(root.left, addValue);
        if (root.right != null) right = copyTree(root.right, addValue);
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.val += addValue;
        newRoot.left = left;
        newRoot.right = right;
        return newRoot;
    }

    public static void main(String[] args){
        ArrayList<TreeNode> trees = new UniqueBST2().generateTrees(3);
        for (TreeNode root: trees){
            System.out.println(root.val);
        }
    }
}
