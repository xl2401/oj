import java.util.ArrayList;
import java.util.Arrays;

public class Subset2 {
    private ArrayList<ArrayList<Integer>> lastLayer = new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {
        Arrays.sort(S);
        return subsets(S, S.length-1);
    }

    public ArrayList<ArrayList<Integer>> subsets(int[] S, int idx){
        if (idx == -1){
            ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
            ArrayList<Integer> emptySet = new ArrayList<Integer>();
            result.add(emptySet);
            return result;
        }
        else{
            ArrayList<ArrayList<Integer>> lastResult = subsets(S, idx-1);
            ArrayList<ArrayList<Integer>> curLayer = new ArrayList<ArrayList<Integer>>();
            ArrayList<ArrayList<Integer>> prev = lastResult;
            if (idx != 0 && S[idx] == S[idx-1]){
                prev = this.lastLayer;
            }
            for (ArrayList<Integer> set: prev){
                ArrayList<Integer> newSet = copyList(set);
                newSet.add(S[idx]);
                curLayer.add(newSet);
            }
            this.lastLayer = curLayer;
            lastResult.addAll(curLayer);
            return lastResult;
        }
    }

    public ArrayList<Integer> copyList(ArrayList<Integer> l){
        ArrayList<Integer> newL = new ArrayList<Integer>();
        for (Integer i: l){
            newL.add(i);
        }
        return newL;
    }

    public static void main(String[] args){
        int[] A = {1,1,2,2,2};
        ArrayList<ArrayList<Integer>> result = new Subset2().subsetsWithDup(A);
        for (ArrayList<Integer> set: result){
            for (Integer i: set){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
