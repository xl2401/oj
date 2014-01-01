import java.util.ArrayList;

public class BinaryTreePostorderTraversal {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        if  (root == null) return new ArrayList<Integer>();
        if (root.left == null && root.right == null){ // leaf
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.add(root.val);
            return result;
        }
        else{
            ArrayList<Integer> result = new ArrayList<Integer>();
            ArrayList<Integer> leftResult = postorderTraversal(root.left);
            ArrayList<Integer> rightResult = postorderTraversal(root.right);
            // add to result
            for (Integer val: leftResult){
                result.add(val);
            }
            for (Integer val: rightResult){
                result.add(val);
            }
            int currentVal = root.val;
            result.add(currentVal);
            return result;
        }
    }
}
