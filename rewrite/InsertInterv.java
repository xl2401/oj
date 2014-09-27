// the strategy is to new an interval when intersection
// add old interv to result when no intersect
// add new to result at last
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>();
        for (Interval cur: intervals) {
            if (cur.end < newInterval.start) {
                res.add(cur);
            } else if (cur.start > newInterval.end) {
                res.add(newInterval);
                // all merge complete, change newInterval in order to be added last
                newInterval = cur;
            } else {
                newInterval = new Interval(Math.min(cur.start, newInterval.start), Math.max(cur.end, newInterval.end));
            }
        }
        res.add(newInterval);
        return res;
    }
}
