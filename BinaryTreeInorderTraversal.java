import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreeInorderTraversal {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        boolean done = false;
        TreeNode cur = root;
        while (!done){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            else{// cur is null, to most left
                if (!stack.isEmpty()){
                    TreeNode last = stack.pop();
                    res.add(last.val);
                    cur = last.right;
                }
                else{ // stack is empty and cur is null
                    done = true;
                }
            }
        }
        return res;
    }
}
