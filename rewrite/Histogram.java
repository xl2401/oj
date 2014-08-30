public class Solution {
    public int largestRectangleArea(int[] height) {
        int N = height.length;
        // add 0 to end to trigger cal
        height = Arrays.copyOf(height, height.length+1);
        Stack<Integer> idxs = new Stack<Integer>();
        int i = 0;
        int max = 0;
        while (i <= N) {
            if (idxs.isEmpty() || height[idxs.peek()] <= height[i]) {
                idxs.push(i++);
            } else {
                // cal
                int calIdx = idxs.pop();
                max = Math.max(max, height[calIdx] * (idxs.isEmpty()? i: i-idxs.peek()-1));
            }
        }
        return max;
    }
}
