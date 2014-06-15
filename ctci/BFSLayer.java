import java.util.ArrayList;
import java.util.LinkedList;

/*
 * 4.4
 * Layer visit binary tree and get linkedlist of each layer
 */
public class BFSLayer {
    public ArrayList<LinkedList<TreeNode>> getLayers(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> res = new ArrayList<LinkedList<TreeNode>>();
        LinkedList<TreeNode> prevLayer = new LinkedList<TreeNode>();
        prevLayer.add(root);
        res.add(prevLayer);
        while (!prevLayer.isEmpty()) {
            LinkedList<TreeNode> curLayer = new LinkedList<TreeNode>();
            for (TreeNode node: prevLayer) {
                if (node.left != null) curLayer.add(node.left);
                if (node.right != null) curLayer.add(node.right);
            }
            if (!curLayer.isEmpty())
                res.add(curLayer);
            prevLayer = curLayer;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(0);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(5);
        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;
        e.right = f;
        ArrayList<LinkedList<TreeNode>> res = new BFSLayer().getLayers(a);
        for (LinkedList<TreeNode> layer: res) {
            for (TreeNode node: layer) {
                System.out.print(node.val + " ");
            }
            System.out.println();
        }
    }
}
