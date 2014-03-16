import java.util.HashMap;

public class TwoSumHash{
    public int[] twoSum(int[] numbers, int target){
        HashMap<Integer, Integer> idxMap = new HashMap<Integer, Integer>();
        int[] res = new int[2];
        for (int i = 0; i < numbers.length; i++){
            int compliment = target - numbers[i];
            if (idxMap.containsKey(compliment)){
                int prevIdx = idxMap.get(compliment);
                res[0] = prevIdx + 1;
                res[1] = i + 1;
                return res;
            }
            // compliment not found
            // add to map
            idxMap.put(numbers[i], i);
        }
        return res;
    }
}
