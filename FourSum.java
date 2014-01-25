import java.util.ArrayList;
import java.util.Arrays;

/*
 * Title: 4Sum 
 * Description:
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
 * Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 *     For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 *
 *         A solution set is:
 *         (-1,  0, 0, 1)
 *         (-2, -1, 1, 2)
 *         (-2,  0, 0, 2)
 *  Solution:
 *  Same as 3Sum.java, add one more loop
 *  pay attention to the avoidance of dup
 */
public class FourSum {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> resSet = new ArrayList<ArrayList<Integer>>();
        int N = num.length;
        if (N < 4)
            return resSet;
        // sort
        Arrays.sort(num);
        for (int i = 0; i < N-3; i++){
            // avoid dup
            if (i > 0 && num[i] == num[i-1]) continue;
            int fir = num[i];
            for (int j = i+1; j < N-2; j++){
                // avoid dup
                if (j > i+1 && num[j] == num[j-1]) continue;
                int sec = num[j];
                int l = j+1;
                int r = N-1;
                while (l < r){
                    int third = num[l];
                    int exp = target - fir - sec - third;
                    if (num[r] > exp){
                        r--;
                    }
                    else if (num[r] < exp){
                        l++;
                    }
                    else{// hit
                        ArrayList<Integer> res = new ArrayList<Integer>();
                        res.add(fir);
                        res.add(sec);
                        res.add(third);
                        res.add(num[r]);
                        resSet.add(res);
                        // avoid dup
                        l++;
                        r--;
                        while (l < r && num[l] == num[l-1]) l++;
                        while (l < r && num[r] == num[r+1]) r--;
                    }
                }
            }
        }
        return resSet;
    }

    public static void main(String[] args){
        FourSum fs = new FourSum();
        int[] num = {1, 0, -1, 0, -2, 2};
        ArrayList<ArrayList<Integer>> resSet = fs.fourSum(num, 0);
        for (ArrayList<Integer> res: resSet){
            for (Integer i: res){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
