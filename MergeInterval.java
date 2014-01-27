import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * Title: Merge Intervals 
 * Description:
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 *
 * Solution:
 * First sort the intervals according to interval.start
 * then start merge, don't forget to add the last interval
 */
public class MergeInterval {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<Interval>();
        // sort by start
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start - b.start;
            }
        });
        int i = 0;
        while (true){
            // end of list
            if (i == intervals.size()){
                break;
            }
            Interval cur = intervals.get(i);
            if (i == intervals.size() - 1){// last one
                res.add(cur);
                break;
            }
            Interval next = intervals.get(i + 1);
            if (cur.end >= next.end){
                intervals.remove(next);
            }
            else if (cur.end >= next.start){
                cur.end = next.end;
                intervals.remove(next);
            }
            else{
                res.add(cur);
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args){
        Interval i1 = new Interval(1, 3);
        Interval i2 = new Interval(2, 6);
        Interval i3 = new Interval(8, 16);
        Interval i4 = new Interval(15, 18);
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        intervals.add(i1);
        intervals.add(i2);
        intervals.add(i3);
        intervals.add(i4);
        MergeInterval mi = new MergeInterval();
        ArrayList<Interval> res = mi.merge(intervals);
        for (Interval in : intervals){
            System.out.println(in.start + " " + in.end);
        }
    }
}
