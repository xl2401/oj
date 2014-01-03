import java.util.ArrayList;
import java.util.LinkedList;

public class LevelTravBottom {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
            return result;
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        LinkedList<ArrayList<Integer>> stack = new LinkedList<ArrayList<Integer>>();
        LinkedList<TreeNode> prevLevelQueue = new LinkedList<TreeNode>();
        ArrayList<Integer> rootLevel = new ArrayList<Integer>();
        rootLevel.add(root.val);
        stack.push(rootLevel);
        prevLevelQueue.add(root);
        while (!prevLevelQueue.isEmpty()){
            LinkedList<TreeNode> curLevelQueue = new LinkedList<TreeNode>();
            ArrayList<Integer> curLevel = new ArrayList<Integer>();
            for (TreeNode node: prevLevelQueue){
                TreeNode leftNode = node.left;
                TreeNode rightNode = node.right;
                if (leftNode != null) {
                    curLevelQueue.add(leftNode);
                    curLevel.add(leftNode.val);
                }
                if (rightNode != null) {
                    curLevelQueue.add(rightNode);
                    curLevel.add(rightNode.val);
                }
            }
            prevLevelQueue = curLevelQueue;
            if (!curLevel.isEmpty())
                stack.push(curLevel);
        }
        // inverse
        while (!stack.isEmpty()){
            ArrayList<Integer> level = stack.pop();
            result.add(level);
        }
        return result;
    }

    public static void main(String[] args){
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(20);
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(7);
        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;
        ArrayList<ArrayList<Integer>> result = new LevelTravBottom().levelOrderBottom(a);
        for (ArrayList<Integer> level: result){
            for (Integer i: level){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
