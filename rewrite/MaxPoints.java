public class Solution {
    public int maxPoints(Point[] points) {
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            Point p1 = points[i];
            HashMap<Double, Integer> slopeCnt = new HashMap<Double, Integer>();
            int dup = 0;
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    Point p2 = points[j];
                    if (p1.x == p2.x) {
                        if (p1.y == p2.y) dup++;
                        else {
                            // special infinity slope
                            if (slopeCnt.containsKey(Double.MAX_VALUE)) slopeCnt.put(Double.MAX_VALUE, slopeCnt.get(Double.MAX_VALUE)+1);
                            else slopeCnt.put(Double.MAX_VALUE, 2);
                        }
                    } else {
                        double slope = 1.0 * (p1.y - p2.y) / (p1.x - p2.x);
                        if (slopeCnt.containsKey(slope)) slopeCnt.put(slope, slopeCnt.get(slope)+1);
                        else slopeCnt.put(slope, 2);
                    }
                }
            }
            if (!slopeCnt.isEmpty()) max = Math.max(max, Collections.max(slopeCnt.values()) + dup);
            else max = 1+dup;
        }
        return max;
    }
}