import java.util.ArrayList;
import java.util.LinkedList;

/*
 * Title: Binary Tree Zigzag Level Order Traversal
 * Description:
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 *
 * Solution:
 * Use stack instead of queue, record traverse direction
 */
public class BTZigZag {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        int readOrder = 1;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) return result;
        LinkedList<TreeNode> curList = new LinkedList<TreeNode>();
        curList.add(root);
        while (!curList.isEmpty()){
            ArrayList<Integer> curResult = new ArrayList<Integer>();
            LinkedList<TreeNode> nextList = new LinkedList<TreeNode>();
            while (!curList.isEmpty()){
                TreeNode cur = curList.pop();
                curResult.add(cur.val);
                if (readOrder == -1){// right to left
                    if (cur.right != null)
                        nextList.push(cur.right);
                    if (cur.left != null)
                        nextList.push(cur.left);
                }
                else if (readOrder == 1){// left to right
                    if (cur.left != null)
                        nextList.push(cur.left);
                    if (cur.right != null)
                        nextList.push(cur.right);
                }
            }
            readOrder *= -1;
            result.add(curResult);
            curList = nextList;
        }
        return result;
    }

    public static void main(String[] args){
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        ArrayList<ArrayList<Integer>> result = new BTZigZag().zigzagLevelOrder(a);
        for (ArrayList<Integer> layer: result){
            for (Integer i: layer){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
