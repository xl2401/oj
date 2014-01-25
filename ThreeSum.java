import java.util.ArrayList;
import java.util.Arrays;

/*
 * Title: 3Sum
 * Description:
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * For example, given array S = {-1 0 1 2 -1 -4},
 *
 *         A solution set is:
 *         (-1, 0, 1)
 *         (-1, -1, 2)
 *
 * Solution:
 * first sort the array
 * iterate over the array
 * and from i+1 - N-1
 * use two pointers l and r and move until meet
 *
 * pay special attention to the uniqueness of triplet
 */
public class ThreeSum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> resultSet = new ArrayList<ArrayList<Integer>>();
        int N = num.length;
        if (N < 3)
            return resultSet;
        // sort
        Arrays.sort(num);
        for (int i = 0; i < N-2; i++){
            int cur = num[i];
            if (i > 0 && cur == num[i-1]) continue;
            int twosum = 0 - cur;
            int l = i+1;
            int r = N-1;
            while (l < r){
                int leftVal = num[l];
                int exp = twosum - leftVal;
                if (num[r] > exp){
                    r--;
                }
                else if (num[r] < exp){
                    l++;
                }
                else{// hit!
                    ArrayList<Integer> res = new ArrayList<Integer>();
                    res.add(cur);
                    res.add(leftVal);
                    res.add(num[r]);
                    resultSet.add(res);
                    l++;
                    r--;
                    while (l < r && num[l] == num[l-1]) l++;
                    while (l < r && num[r] == num[r+1]) r--;
                }
            }
        }
        return resultSet;
    }

    public static void main(String[] args){
        ThreeSum ts = new ThreeSum();
        int[] num = {-1, 0, 1, 2, -1, -4};
        ArrayList<ArrayList<Integer>> resSet = ts.threeSum(num);
        for (ArrayList<Integer> res: resSet){
            for (Integer i: res){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
