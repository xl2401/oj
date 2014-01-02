import java.util.ArrayList;

public class InorderTraversalRecur {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> l = new ArrayList<Integer>();
        inorderTraversal(root, l);
        return l;
    }

    public void inorderTraversal(TreeNode root, ArrayList<Integer> l){
        if (root == null) return;
        inorderTraversal(root.left, l);
        l.add(root.val);
        inorderTraversal(root.right, l);
    }

    public static void main(String[] args){
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        a.right = b;
        b.left = c;
        ArrayList<Integer> l = new InorderTraversalRecur().inorderTraversal(a);
        for (Integer i: l){
            System.out.println(i);
        }
    }
}
