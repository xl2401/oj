public class CutRod{
    private int[] r;

    private void initR(int[] p){
        int N = p.length;
        r = new int[N];
        for (int i = 0; i < N; i++){
            r[i] = -1;
        }
    }

    public int cutRod(int[] p, int n){
        initR(p);
        return cutRodAux(p, n);
    }

    public int cutRodAux(int[] p, int n){
        if (n == 0) return 0;
        else{
            if (r[n-1] > 0) return r[n-1];
            else{
                int result = 0;
                for (int i = 0; i < n; i++){
                    result = Math.max(p[i], cutRodAux(p, n-i-1));
                }
                r[n-1] = result;
                return result;
            }
        }
    }

    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        int[] p = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        System.out.println(new CutRod().cutRod(p, n));
    }
}
