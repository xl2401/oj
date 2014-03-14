import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreePreorderTraversal {

    /*
     * Use a stack
     * 1. put root node into stack
     * 2. while stack is not empty
     * 3. pop stack -> cur
     * 4. save cur.val, if right or left is not null, push 
     * *****pay attention, because it's a stack, push right first, then left******
     */
    public ArrayList<Integer> preorderTraversalIterative(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            res.add(cur.val);
            // pay attention to the push sequence
            if (cur.right != null){
                stack.push(cur.right);
            }
            if (cur.left != null){
                stack.push(cur.left);
            }
        }
        return res;
    }

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
            result.addAll(leftResult);
            result.addAll(rightResult);
            return result;
        }
    }
}
