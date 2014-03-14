import java.util.ArrayList;
import java.util.Arrays;

public class Subset2 {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> emptySet = new ArrayList<Integer>();
        res.add(emptySet);
        int N = S.length;
        int start = 0;
        for (int i = 0; i < N; i++){
            int size = res.size();
            for (int j = start; j < size; j++){
                ArrayList<Integer> curSet = new ArrayList<Integer>(res.get(j));
                curSet.add(S[i]);
                res.add(curSet);
            }
            if (i < N-1 && S[i] == S[i+1]){
                start = size;
            }
            else{
                start = 0;
            }
        }
        return res;
    }
}
