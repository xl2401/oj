import java.util.ArrayList;

public class BinaryTreePreorderTraversal {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        if  (root == null) return new ArrayList<Integer>();
        if (root.left == null && root.right == null){ // leaf
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.add(root.val);
            return result;
        }
        else{
            ArrayList<Integer> result = new ArrayList<Integer>();
            int currentVal = root.val;
            result.add(currentVal);
            ArrayList<Integer> leftResult = preorderTraversal(root.left);
            ArrayList<Integer> rightResult = preorderTraversal(root.right);
            // add to result
            for (Integer val: leftResult){
                result.add(val);
            }
            for (Integer val: rightResult){
                result.add(val);
            }
            return result;
        }
    }
}
