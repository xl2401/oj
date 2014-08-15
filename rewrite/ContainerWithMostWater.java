public class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int leftHei = height[left];
            int rightHei = height[right];
            int curArea = Math.min(leftHei, rightHei) * (right - left);
            if (curArea > max)
            	max = curArea;
            if (leftHei > rightHei) right--;
            else left++;
        }
        return max;
    }
}
