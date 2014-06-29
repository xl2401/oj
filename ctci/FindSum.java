import java.util.ArrayList;

/*
 * 4.9
 * print the path that sum to a certain value
 *
 * FindSumRoot version only start at root
 */
public class FindSum {
    public void findSumRoot(int sum, TreeNode root) {
        findRootHelper(0, sum, new ArrayList<TreeNode>(), root);
    }

    private void findRootHelper(int curSum, int sum, ArrayList<TreeNode> path, TreeNode root) {
        // base condition
        if (root == null) return;
        // visit current node
        curSum = curSum + root.val;
        path.add(root);
        if (curSum == sum) {
            printList(path);
        }
        ArrayList<TreeNode> leftPath = copyList(path);
        ArrayList<TreeNode> rightPath = path;
        findRootHelper(curSum, sum, leftPath, root.left);
        findRootHelper(curSum, sum, rightPath, root.right);
    }

    private void printList(ArrayList<TreeNode> l) {
        for (TreeNode node: l) {
            System.out.print(node.val + " ");
        }
        System.out.println();
    }

    private ArrayList<TreeNode> copyList(ArrayList<TreeNode> l) {
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        for (TreeNode node: l) {
            res.add(node);
        }
        return res;
    }
    
    // -----------------------------------------------------------
    
    public void findSum(int sum, TreeNode root) {
        int depth = getTreeDepth(root);
        int[] path = new int[depth];
        findSumHelper(sum, root, path, 1);
    }

    private void findSumHelper(int sum, TreeNode root, int[] path, int depth) {
        // base condition
        if (root == null) return;
        path[depth-1] = root.val;
        int curSum = 0;
        for (int start = depth-1; start >= 0; start--) {
            curSum += path[start];
            if (curSum == sum){
                // from start to depth-1
                printPath(path, start, depth);
            }
        }
        findSumHelper(sum, root.left, path, depth+1);
        findSumHelper(sum, root.right, path, depth+1);
    }

    private void printPath(int[] path, int start, int depth) {
        for (int i = start; i < depth; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println();
    }

    private int getTreeDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getTreeDepth(root.left), getTreeDepth(root.right));
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(-4);
        TreeNode d = new TreeNode(-2);
        TreeNode e = new TreeNode(6);
        a.left = b;
        b.left = c;
        c.left = d;
        d.left = e;
        new FindSum().findSum(5, a);
    }
}
