import java.util.HashSet;

/*
 * Title: Longest Consecutive Sequence 
 * Description:
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 *
 * Your algorithm should run in O(n) complexity.
 *
 * Solution:
 * Use a set to record all the numbers, contains operation will take O(1)
 * for every number, find its conseq. If the number is the conseq, remember to remove the num,
 * So that every num in the array is visted just once -> O(n)
 */
public class LongestConSeq {
    private HashSet<Integer> numSet = null;

    public int longestConsecutive(int[] num) {
        numSet = new HashSet<Integer>();
        for (int i = 0; i < num.length; i++){
            numSet.add(num[i]);
        }
        int max = 0;
        for (int i = 0; i < num.length; i++){
            int curMax = getConsecCount(num[i]);
            if (curMax > max)
                max = curMax;
        }
        return max;
    }

    private int getConsecCount(int num){
        int count = 1;
        int ascendNum = num;
        int descendNum = num;
        // ascend order
        while (true){
            ascendNum++;
            if (numSet.contains(ascendNum)){
                count++;
                numSet.remove(ascendNum);
            }
            else
                break;
        }
        while (true){
            descendNum--;
            if (numSet.contains(descendNum)){
                count++;
                numSet.remove(descendNum);
            }
            else
                break;
        }
        return count;
    }

    public static void main(String[] args){
        int[] A = {100, 4, 200, 1, 3, 2};
        System.out.println(new LongestConSeq().longestConsecutive(A));
    }
}
