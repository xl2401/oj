public class UniqueBST {
    public int numTrees(int n) {
        int[] cnt = new int[n+1];
        // cnt[i]: number of unique BSTs of i nodes in total
        cnt[0] = 1; // cnt of empty BST is one kind
        cnt[1] = 1;
        // i is # of nodes of BST
        for (int i = 2; i <= n; i++) {
            int sum = 0;
            // j is # of nodes on the left subtree
            for (int j = 0; j < i; j++) {
                sum += cnt[j] * cnt[i-1-j];
            }
            cnt[i] = sum;
        }
        return cnt[n];
    }
}
