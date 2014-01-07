public class CutRodButtomUp{
    private int[] r;

    private void initR(int[] p){
        int N = p.length;
        r = new int[N+1];
        for (int i = 0; i < N; i++){
            r[i] = -1;
        }
    }

    public int cutRod(int[] p, int n){
        initR(p);
        r[0] = 0;
        for (int i = 1; i <= n; i++){
            // calculte r1 ... rn
            int result = 0;
            for (int j = 0; j < i; j++){
                result = Math.max(result, p[j] + r[i-j-1]);
            }
            r[i] = result;
        }
        return r[n];
    }

    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        int[] p = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        System.out.println(new CutRodButtomUp().cutRod(p, n));
    }
}
