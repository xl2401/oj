public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        // sort by start
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        List<Interval> res = new ArrayList<Interval>();
        for (Interval intv: intervals) {
            if (res.isEmpty()) res.add(intv);
            else {
                Interval prev = res.get(res.size()-1);
                if (prev.end >= intv.start) { // overlap
                    res.remove(res.size()-1);
                    res.add(new Interval(prev.start, Math.max(prev.end, intv.end)));
                } else {
                    res.add(intv);
                }
            }
        }
        return res;
    }
}