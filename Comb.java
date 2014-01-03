import java.util.ArrayList;

public class Comb {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        if (n < k) return null;
        else{
            if (k == n){
                ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
                ArrayList<Integer> comb = new ArrayList<Integer>();
                for (int i = 0; i < n; i++){
                    comb.add(i+1);
                }
                result.add(comb);
                return result;
            }
            if (k == 1){
                ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
                for (int i = 0; i < n; i++){
                    ArrayList<Integer> comb = new ArrayList<Integer>();
                    comb.add(i+1);
                    result.add(comb);
                }
                return result;
            }
            ArrayList<ArrayList<Integer>> prev1 = combine(n-1, k);
            ArrayList<ArrayList<Integer>> prev2 = combine(n-1, k-1);
            for (ArrayList<Integer> comb: prev2){
                comb.add(n);
            }
            prev1.addAll(prev2);
            return prev1;
        }
    }

    public static void main(String[] args){
            ArrayList<ArrayList<Integer>> result = new Comb().combine(4, 2);
            for (ArrayList<Integer> comb: result){
                for (Integer i: comb){
                    System.out.print(i + " ");
                }
                System.out.println();
            }
    }
}
