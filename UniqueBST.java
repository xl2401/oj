public class UniqueBST {
    // dp result
    private int[] num;

    public int numTrees(int n) {
        // init result;
        num = new int[n+1];
        num[0] = 1;
        num[1] = 1;
        for (int i = 2; i <= n; i++){
            num[i] = -1;
        }
        return numTreesAug(n);
    }

    public int numTreesAug(int n){
        if (n == 0) return 1;
        if (n == 1) return 1;
        // n > 1
        int sum = 0;
        for (int i = 1; i <= n; i++){
            int left = 0;
            int right = 0;
            if (num[i-1] == -1){
                left = numTreesAug(i-1);
                num[i-1] = left;
            }
            else left = num[i-1];
            if (num[n-i] == -1){
                right = numTreesAug(n-i);
                num[n-i] = right;
            }
            else right = num[n-i];
            sum += left * right;
        }
        return sum;
    }

    public static void main(String[] args){
        System.out.println(new UniqueBST().numTrees(3));
    }
}
