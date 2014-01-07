import java.util.ArrayList;
import java.util.Arrays;

public class Triangle {
    /**
     * Still use Dynamic programming
     * Use the original triangle space to record sum
     * From bottom to top of the trianle, not need to find min any more
     */
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int numOfLayer = triangle.size();
        for (int i = numOfLayer-2; i >= 0; i--){// from the last second one
            ArrayList<Integer> nextLayer = triangle.get(i+1);
            ArrayList<Integer> curLayer = triangle.get(i);
            for (int j = 0; j < curLayer.size(); j++){
                curLayer.set(j, Math.min(nextLayer.get(j), nextLayer.get(j+1))
                                + curLayer.get(j));
            }
        }
        return triangle.get(0).get(0);
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
