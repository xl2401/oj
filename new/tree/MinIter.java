import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Minimum # of iterations to pass information to all nodes in the tree
 *
 * Solution:
 * Break the problem down into smaller problems -> subtree
 * http://www.geeksforgeeks.org/minimum-iterations-pass-information-nodes-tree/
 */
public class Solution {
    public int getMinIter(NaryTreeNode root) {
        // base case
        if (root == null || (root.children.isEmpty())) return 0;
        int max = Integer.MIN_VALUE;
        List<Integer> minIterList = new ArrayList<Integer>();
        List<NaryTreeNode> children = root.children;
        // get the miniter value of all substrees of root -> subproblems
        for (int i = 0; i < children.size(); i++) {
            int minIter = getMinIter(children.get(i));
            minIterList.add(minIter);
        }
        // sort the result -> decision/ merge
        Collections.sort(minIterList, Collections.reverseOrder());
        for (int i = 0; i < minIterList.size(); i++) {
            max = Math.max(max, minIterList.get(i) + i + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        NaryTreeNode n = new NaryTreeNode();
        NaryTreeNode o = new NaryTreeNode();
        NaryTreeNode i = new NaryTreeNode();
        NaryTreeNode j = new NaryTreeNode();
        NaryTreeNode p = new NaryTreeNode();
        NaryTreeNode q = new NaryTreeNode();
        NaryTreeNode m = new NaryTreeNode();
        NaryTreeNode c = new NaryTreeNode();
        NaryTreeNode d = new NaryTreeNode();
        NaryTreeNode f = new NaryTreeNode();
        List<NaryTreeNode> no = new ArrayList<NaryTreeNode>(Arrays.asList(n, o));
        NaryTreeNode h = new NaryTreeNode(no);
        List<NaryTreeNode> hij = new ArrayList<NaryTreeNode>(Arrays.asList(h, i, j));
        NaryTreeNode b = new NaryTreeNode(hij);
        NaryTreeNode k = new NaryTreeNode(new ArrayList<NaryTreeNode>(Arrays.asList(p)));
        NaryTreeNode l = new NaryTreeNode(new ArrayList<NaryTreeNode>(Arrays.asList(q)));
        NaryTreeNode e = new NaryTreeNode(new ArrayList<NaryTreeNode>(Arrays.asList(k, l)));
        NaryTreeNode g = new NaryTreeNode(new ArrayList<NaryTreeNode>(Arrays.asList(m)));
        NaryTreeNode a = new NaryTreeNode(new ArrayList<NaryTreeNode>(Arrays.asList(b, c, d, e, f, g)));
        System.out.println(new Solution().getMinIter(a));
    }
}

/*
 * Definition of NaryTreeNode
 */
public class NaryTreeNode {
    List<NaryTreeNode> children;

    public NaryTreeNode(List<NaryTreeNode> children) {
        this.children = children;
    }

    public NaryTreeNode() {
        this.children = new ArrayList<NaryTreeNode>();
    }
}
