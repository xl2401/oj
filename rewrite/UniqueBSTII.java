import java.util.List;
import java.util.ArrayList;

public class UniqueBSTII {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        if (start > end) {
            List<TreeNode> emptyTreeList = new ArrayList<TreeNode>();
            emptyTreeList.add(null);
            return emptyTreeList;
        }
        List<TreeNode> curTrees = new ArrayList<TreeNode>();
        // i is the root
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generateTrees(start, i-1);
            List<TreeNode> rightTrees = generateTrees(i+1, end);
            for (int p = 0; p < leftTrees.size(); p++) {
                TreeNode leftRoot = leftTrees.get(p);
                for (int q = 0; q < rightTrees.size(); q++) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftRoot;
                    root.right = rightTrees.get(q);
                    curTrees.add(root);
                }
            }
        }
        return curTrees;
    }
}
