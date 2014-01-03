import java.util.ArrayList;

public class PathSum2 {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> seq = new ArrayList<Integer>();
        trav(result, seq, 0, sum, root);
        return result;
    }

    public void trav(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> seq, int sum, int targetSum, TreeNode root){
        if (root == null) return;
        if (root.left == null && root.right == null){
            if ((sum + root.val) == targetSum){
                seq.add(root.val);
                result.add(seq);
            }
            return;
        }
        else{
            int curSum = sum + root.val;
            ArrayList<Integer> leftSeq = copyList(seq);
            leftSeq.add(root.val);
            ArrayList<Integer> rightSeq = copyList(leftSeq);
            trav(result, leftSeq, curSum, targetSum, root.left);
            trav(result, rightSeq, curSum, targetSum, root.right);
        }
    }

    public ArrayList<Integer> copyList(ArrayList<Integer> l){
        ArrayList<Integer> newL = new ArrayList<Integer>();
        for (Integer i: l){
            newL.add(i);
        }
        return newL;
    }
}
