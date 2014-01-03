import java.util.ArrayList;

public class SumRoot {
    public int sumNumbers(TreeNode root) {
        ArrayList<Integer> num = new ArrayList<Integer>();
        sumNumbers(num, 0, root);
        int sum = 0;
        for (Integer i: num){
            sum += i;
        }
        return sum;
    }

    public void sumNumbers(ArrayList<Integer> result, int sum, TreeNode root){
        if (root == null) return;
        if (root.left == null && root.right == null){
            result.add(sum * 10 + root.val);
            return;
        }
        else{
            int curVal = sum * 10 + root.val;
            sumNumbers(result, curVal, root.left);
            sumNumbers(result, curVal, root.right);
        }
    }

    public static void main(String[] args){
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        a.left = b;
        a.right = c;
        System.out.println(new SumRoot().sumNumbers(a));
    }
}
