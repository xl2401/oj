public class Solution {
    // Bottom up
    public int minimunTotalBtmUp(List<List<Integer>> triangle) {
        int N = triangle.size();
        for (int i = N-2; i >= 0; i--) { // from last second
            List<Integer> curLayer = triangle.get(i);
            List<Integer> nextLayer = triangle.get(i+1);
            for (int j = 0; j < curLayer.size(); j++) {
                curLayer.set(j, curLayer.get(j)+Math.min(nextLayer.get(j), nextLayer.get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }

    // Top down
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return Integer.MAX_VALUE;
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> curLayer = triangle.get(i);
            for (int j = 0; j < curLayer.size(); j++) {
                curLayer.set(j, getPrevSumMin(triangle, i, j)+curLayer.get(j));
            }
        }
        return min(triangle.get(triangle.size()-1));
    }

    private int getPrevSumMin(List<List<Integer>> triangle, int i, int j) {
        if (i == 0) return 0;
        List<Integer> lastLayer = triangle.get(i-1);
        int left = j-1 < 0 ? Math.MAX_VALUE : lastLayer.get(j-1);
        int right = j == lastLayer.size() ? Math.MAX_VALUE : lastLayer.get(j);
        return Math.min(left, right);
    }

    private int min(List<Integer> layer) {
        int min = Integer.MAX_VALUE;
        for (Integer i: layer) {
            if (i < min)
                min = i;
        }
        return min;
    }
}

