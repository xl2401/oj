import java.util.List;
import java.util.ArrayList;

public class ZigZagTrav {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        ArrayList<Integer> prevResLayer = new ArrayList<Integer>();
        ArrayList<TreeNode> prevLayer = new ArrayList<TreeNode>();
        int layerCnt = 0;
        prevResLayer.add(root.val);
        prevLayer.add(root);
        res.add(prevResLayer);
        while (!prevLayer.isEmpty()) {
            layerCnt++;
            ArrayList<Integer> curResLayer = new ArrayList<Integer>();
            ArrayList<TreeNode> curLayer = new ArrayList<TreeNode>();
            for (int i = prevLayer.size()-1; i >= 0; i--) {
                TreeNode prevNode = prevLayer.get(i);
                if (layerCnt % 2 == 0) {
                    if (prevNode.left != null) {
                        curLayer.add(prevNode.left);
                        curResLayer.add(prevNode.left.val);
                    }
                    if (prevNode.right != null) {
                        curLayer.add(prevNode.right);
                        curResLayer.add(prevNode.right.val);
                    }
                } else {
                    if (prevNode.right != null) {
                        curLayer.add(prevNode.right);
                        curResLayer.add(prevNode.right.val);
                    }
                    if (prevNode.left != null) {
                        curLayer.add(prevNode.left);
                        curResLayer.add(prevNode.left.val);
                    }
                }
            }
            if (!curResLayer.isEmpty()) res.add(curResLayer);
            prevLayer = curLayer;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(20);
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(7);
        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;
        List<List<Integer>> res = new ZigZagTrav().zigzagLevelOrder(a);
        for (List<Integer> layer: res) {
            for (Integer i: layer) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
