import java.util.ArrayList;
import java.util.HashSet;

public class Permutation2 {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // convert to list
        ArrayList<Integer> numList = new ArrayList<Integer>();
        for (int i = 0; i < num.length; i++){
            numList.add(num[i]);
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        perm(numList, numList.size(), result);
        return result;
    }

    public void perm(ArrayList<Integer> num, int n, ArrayList<ArrayList<Integer>> result){
        if (n == 1){
            result.add(num);
        }
        HashSet<Integer> swapHist = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> newNum = copyList(num); 
            // has ith element swap before? ensure unqueness
            if (swapHist.contains(newNum.get(i)))
                continue;
            swapHist.add(newNum.get(i));
            swap(newNum, i, n-1);
            perm(newNum, n-1, result);
        }
    }

    public void swap(ArrayList<Integer> num, int i, int j){
        int temp = num.get(i);
        num.set(i, num.get(j));
        num.set(j, temp);
    }

    public ArrayList<Integer> copyList(ArrayList<Integer> l){
        ArrayList<Integer> newL = new ArrayList<Integer>();
        for (Integer i: l){
            newL.add(i);
        }
        return newL;
    }

    public static void main(String[] args){
        int[] num = {1, 1,2,2,3};
        ArrayList<ArrayList<Integer>> result = new Permutation2().permuteUnique(num);
        for (ArrayList<Integer> permu: result){
            for (Integer i: permu){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
