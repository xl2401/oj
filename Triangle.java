import java.util.ArrayList;
import java.util.Arrays;

public class Triangle {
    /**
     * Use Dynamic programming
     * Use extra space: the space of triangle to record sum
     * There is more efficient algo, so TriangleOpt.java
     */
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int numOfLayer = triangle.size();
        int[] sum = new int[numOfLayer];
        if (numOfLayer == 1) return triangle.get(0).get(0);
        if (numOfLayer == 0) return 0;
        int[] lastSum = new int[1];
        int[] curSum = new int[0];
        lastSum[0] = triangle.get(0).get(0);
        for (int i = 1; i < numOfLayer; i++){
            curSum = new int[i+1];
            ArrayList<Integer> curLayer = triangle.get(i);
            for (int j = 1; j < i; j++){
                curSum[j] = Math.min(lastSum[j], lastSum[j-1]) + curLayer.get(j);
            }
            // update first and last
            curSum[0] = lastSum[0] + curLayer.get(0); 
            curSum[i] = lastSum[i-1] + curLayer.get(i);
            lastSum = curSum;
        }
        // get min of cursum
        return getMin(curSum);
    }

    private int getMin(int[] array){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++){
            if (array[i] < min) min = array[i];
        }
        return min;
    }

    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> a = new ArrayList(Arrays.asList(2));
        ArrayList<Integer> b = new ArrayList(Arrays.asList(3,4));
        ArrayList<Integer> c = new ArrayList(Arrays.asList(6,5,7));
        ArrayList<Integer> d = new ArrayList(Arrays.asList(4,1,8,3));
        triangle.add(a);
        triangle.add(b);
        triangle.add(c);
        triangle.add(d);
        System.out.println(new Triangle().minimumTotal(triangle));
    }
}
