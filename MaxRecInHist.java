import java.util.LinkedList;
import java.util.Arrays;

/*
 * Title:Largest Rectangle in Histogram
 * Description:
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
 * find the area of largest rectangle in the histogram.
 *
 * Solution:
 * largestRectangleArea1 is very naive method that cost O(n^2)
 * largestRectangleArea use a stack and cost O(n)
 * the thought is: when do we calculate the area using the height[i]? 
 * A: when we discover a height[j] that is smaller than height[i]
 * the end point of the rectangle will be j-1, the start point is:
 * * 0 when stack is empty
 * * stack.peek() + 1, because stack.peek() is the height that is just smaller than height[i]
 * The images in:http://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html
 * will help the thinking, but it's not correct with the start point...
 */
public class MaxRecInHist {
    public int largestRectangleArea1(int[] height) {
        int N = height.length;
        int maxArea = 0;
        int minHeight = Integer.MAX_VALUE;
        int wide = 0;
        for (int i = 0; i < N; i++){
            int combineArea = Math.min(minHeight, height[i]) * (wide + 1);
            if (combineArea <= height[i]){
                if (height[i] > maxArea){
                    maxArea = height[i];
                }
                minHeight = height[i];
                wide = 1;
            }
            else{
                if (combineArea > maxArea){
                    maxArea = combineArea;
                }
                wide++;
                minHeight = Math.min(minHeight, height[i]);
            }
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] height) {
        int N = height.length;
        height = Arrays.copyOf(height, N + 1);
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int max = 0;
        int i = 0;
        while (i <= N){
            if (stack.isEmpty() || height[stack.peek()] <= height[i]){
                stack.push(i++);
            }
            else{
                int toCalIdx = stack.pop();
                max = Math.max(max, height[toCalIdx] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        return max;
    }

    public static void main(String[] args){
        MaxRecInHist mrh = new MaxRecInHist();
        int[] A = {2,1,5,6,2,3};
        System.out.println(mrh.largestRectangleArea(A));
    }
}
