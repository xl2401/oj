public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = {-1, -1};
        HashMap<Integer, Integer> idxMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            int cur = numbers[i];
            int exp = target - cur;
            if (idxMap.containsKey(exp)) {
                res[0] = idxMap.get(exp) + 1;
                res[1] = i + 1;
                return res;
            } else {
                idxMap.put(cur, i);
            }
        }
        return res;
    }
}