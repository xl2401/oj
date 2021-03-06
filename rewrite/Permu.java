import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Permu {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(num, 0, res);
        return res;
    }
    
    private void helper(int[] num, int idx, List<List<Integer>> res) {
    	if (idx == num.length-1) res.add(arrayToList(num));
        for (int i = idx; i < num.length; i++) {
            swap(num, idx, i);
            helper(num, idx+1, res);
            swap(num, idx, i);
        }
    }
    
    private void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    private List<Integer> arrayToList(int[] array) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i: array) {
            res.add(i);
        }
        return res;
    }
}
