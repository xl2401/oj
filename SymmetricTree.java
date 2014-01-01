public class SymmetricTree {
    public boolean symmetric(TreeNode a, TreeNode b){
        if (a == null && b == null){
            return true;
        }
        if (!(a != null && b != null)){
            return false;
        }
        return symmetric(a.left, b.right) & (a.val == b.val) & symmetric(a.right, b.left);
    }
    
    public boolean isSymmetric(TreeNode root) {
        if (root  ==  null){
            return true;
        }
        if (root.left == null && root.right == null){
            return true;
        }
        if (!(root.left != null && root.right != null)){
            return false;
        }
        return symmetric(root.left, root.right);
    }
}
