import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Arrays;

/*
 * Title: Two Sum
 * Description:
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 *
 * You may assume that each input would have exactly one solution.
 *
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 *
 * Solution:
 * The first solution takes O(n^2) time and O(1) space,
 * the second solution record every number and its idx, sort the array
 * so it takes O(n) time and O(n) space
 */
public class TwoSum {
    public int[] twoSum1(int[] numbers, int target) {
        int[] indexs = new int[2];
        indexs[0] = 0;
        indexs[1] = 0;
        for (int i = 0; i < numbers.length; i++){
            int current = numbers[i];
            int tar = target - current;
            int index = search(numbers, tar, i+1);
            if (index != -1){
                indexs[0] = i+1;
                indexs[1] = index+1;
                break;
            }
        }
        return indexs;
    }
    
    public int search(int[] numbers, int target, int start){
        for (int i = start; i < numbers.length; i++){
            if (numbers[i] == target) return i;
        }
        return -1;
    }

    class NumItem{
        int idx;
        int num;
        public NumItem(int idx, int num){
            this.idx = idx;
            this.num = num;
        }
    }

    public int[] twoSum(int[] numbers, int target){
        int N = numbers.length;
        ArrayList<NumItem> numList = new ArrayList<NumItem>();
        for (int i = 0; i < N; i++){
            NumItem item = new NumItem(i + 1, numbers[i]);
            numList.add(item);
        }
        Collections.sort(numList, new Comparator<NumItem>(){
            public int compare(NumItem a, NumItem b){
                return a.num - b.num;
            }
        });
        int i = 0;
        int j = N - 1;
        int[] res = new int[2];
        while (i < j){
            int a = numList.get(i).num;
            int expectB = target - a;
            int b = numList.get(j).num;
            if (expectB == b){
                res[0] = numList.get(i).idx;
                res[1] = numList.get(j).idx;
                Arrays.sort(res);
                return res;
            }
            else if (expectB > b){
                i++;
            }
            else{
                j--;
            }
        }
        return res;
    } 

    public static void main(String[] args){
        int[] numbers = {5,75,25};
        TwoSum twoSum = new TwoSum();
        int[] idxs = twoSum.twoSum(numbers, 100);
        System.out.println(idxs[0] + " " + idxs[1]);
    }
}
