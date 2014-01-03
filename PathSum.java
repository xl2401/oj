import java.util.ArrayList;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        travSum(result, 0, root);
        return result.contains(sum);
    }

    public void travSum(ArrayList<Integer> result, int sum, TreeNode root){
        if (root == null) return;
        if (root.left == null && root.right == null){
            result.add(sum + root.val);
            return;
        }
        else{
            travSum(result, sum + root.val, root.left);
            travSum(result, sum + root.val, root.right);
        }
    }
}
