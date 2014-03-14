import java.util.ArrayList;
import java.util.Arrays;

public class Subset {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        int N = S.length;
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> emptySet = new ArrayList<Integer>();
        res.add(emptySet);
        for (int i = 0; i < N; i++){
            int size = res.size();
            // iterate over previous result
            for (int j = 0; j < size; j++){
                ArrayList<Integer> curSet = new ArrayList<Integer>(res.get(j));
                curSet.add(S[i]);
                res.add(curSet);
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[] A = {4,1,0};
        ArrayList<ArrayList<Integer>> result = new Subset().subsets(A);
        for (ArrayList<Integer> set: result){
            for (Integer i: set){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
