import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreeLevelOrderTrav {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        if (root == null) return resultList;
        LinkedList<TreeNode> ll = new LinkedList<TreeNode>();
        ll.addLast(root);
        ArrayList<Integer> subList = new ArrayList<Integer>();
        subList.add(root.val);
        resultList.add(subList);
        while (!ll.isEmpty()){
            subList = new ArrayList<Integer>();
            int pollCounter = ll.size();
            for (int i = 0; i < pollCounter; i++){
                TreeNode node = ll.poll();
                TreeNode left = node.left;
                TreeNode right = node.right;
                if (left != null){
                    subList.add(left.val);
                    ll.addLast(left);
                }
                if (right != null){
                    subList.add(right.val);
                    ll.addLast(right);
                }
            }
            if (subList.size() > 0){
                resultList.add(subList);
            } 
        }
        return resultList;
    }
}
