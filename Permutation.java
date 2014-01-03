import java.util.ArrayList;

public class Permutation {
    public ArrayList<ArrayList<Integer>> permute(int[] num, int idx){
        if (idx == 0){
            ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
            if (num.length == 0) return result;
            else{
                ArrayList<Integer> permu = new ArrayList<Integer>();
                permu.add(num[0]);
                result.add(permu);
                return result;
            }
        }
        else{
            ArrayList<ArrayList<Integer>> prevResult = permute(num, idx-1);
            ArrayList<ArrayList<Integer>> curResult = new ArrayList<ArrayList<Integer>>();
            int curInt = num[idx];
            for (ArrayList<Integer> permu: prevResult){
                for (int i = 0; i < permu.size(); i++){
                    ArrayList<Integer> newPermu = new ArrayList<Integer>();
                    for (int j = 0; j < permu.size(); j++){
                        if (j == i) newPermu.add(curInt);
                        newPermu.add(permu.get(j));
                    }
                    curResult.add(newPermu);
                }
                permu.add(curInt);
                curResult.add(permu);
            }
            return curResult;
        }
    }

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        return permute(num, num.length-1);
    }

    public static void main(String[] args){
        int[] A = {1,2,3};
        ArrayList<ArrayList<Integer>> result = new Permutation().permute(A);
        for (ArrayList<Integer> permu: result){
            for (Integer i: permu){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
