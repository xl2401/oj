import java.util.ArrayList;
import java.util.LinkedList;

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

    public ArrayList<Integer> postorderTraversalIterative(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        LinkedList<TreeNode> s1 = new LinkedList<TreeNode>();
        LinkedList<TreeNode> s2 = new LinkedList<TreeNode>();
        s1.push(root);

        while (!s1.isEmpty()){
            TreeNode cur = s1.pop();
            s2.push(cur);
            if (cur.left != null){
                s1.push(cur.left);
            }
            if (cur.right != null){
                s1.push(cur.right);
            }
        }
        // put s2 into res
        while (!s2.isEmpty()){
            res.add(s2.pop().val);
        }
        return res;
    }
}
