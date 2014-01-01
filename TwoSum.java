public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
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
}
