/*
 * Title: 
 * Container With Most Water 
 * Description:
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container.
 *
 * Solution:
 * need proof
 * see: http://oj.leetcode.com/discuss/oj/container-with-most-water
 */
public class MostContainer {
    public int maxArea(int[] height) {
        int low = 0;
        int high = height.length-1;
        int max = 0;
        while (low < high){
            max = Math.max(max, (high-low)*Math.min(height[low], height[high]));
            if (height[high] > height[low])
                low++;
            else
                high--;
        }
        return max;
    }
}
