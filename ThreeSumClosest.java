import java.util.ArrayList;
import java.util.Arrays;

/*
 * Title: 3Sum Closest
 * Description:
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 *     For example, given array S = {-1 2 1 -4}, and target = 1.
 *
 *     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * Solution:
 * similar to ThreeSum.java
 * but when traversing, keep record of the difference.
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        int diff = Integer.MAX_VALUE;
        int N = num.length;
        if (N < 3){
            return diff;
        }
        // sort
        Arrays.sort(num);
        for (int i = 0; i < N-2; i++){
            int cur = num[i];
            if (i > 0 && cur == num[i-1]) continue;
            int twosum = target - cur;
            int l = i+1;
            int r = N-1;
            while (l < r){
                int leftVal = num[l];
                int exp = twosum - leftVal;
                int sum = cur + leftVal + num[r];
                if (num[r] > exp){
                    if (Math.abs(sum - target) < Math.abs(diff))
                        diff = sum - target;
                    r--;
                }
                else if (num[r] < exp){
                    if (Math.abs(sum - target) < Math.abs(diff))
                        diff = sum - target;
                    l++;
                }
                else{// hit!
                    return target;
                }
            }
        }
        return target + diff;
    }

    public static void main(String[] args){
        ThreeSumClosest ts = new ThreeSumClosest();
        int[] num = {-1, 1, 2, -4};
        System.out.println(ts.threeSumClosest(num, 0));
    }
}
